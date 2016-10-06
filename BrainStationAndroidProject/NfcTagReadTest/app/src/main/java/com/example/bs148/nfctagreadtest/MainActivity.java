package com.example.bs148.nfctagreadtest;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    NfcAdapter nfcAdapter;
    ToggleButton toggleButton;
    EditText textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nfcAdapter=NfcAdapter.getDefaultAdapter(this);
        toggleButton= (ToggleButton) findViewById(R.id.toggleReadWrite);
        textView= (EditText) findViewById(R.id.textView);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if(intent.hasExtra(NfcAdapter.EXTRA_TAG)){
            Toast.makeText(this,"NfcIntent!",Toast.LENGTH_LONG).show();

            if(toggleButton.isChecked()){
                Parcelable[] parcelables=intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
                if(parcelables!=null && parcelables.length>0){
                    readTextFromMessage((NdefMessage)parcelables[0]);
                }else{
                    Toast.makeText(this,"No ndef message found",Toast.LENGTH_LONG).show();
                }
            }else{
                Tag tag=intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
                NdefMessage ndefMessage=createNdefMessage(textView.getText()+"");
                writeNdefMessage(tag,ndefMessage);
            }


        }else{
            Toast.makeText(this,"NfcIntent not found!",Toast.LENGTH_LONG).show();
        }
    }

    private void readTextFromMessage(NdefMessage ndefMessage) {
        NdefRecord[] ndefRecords=ndefMessage.getRecords();
        if(ndefRecords!=null && ndefRecords.length>0){
            NdefRecord ndefRecord=ndefRecords[0];
            String tagContent=getTextFromNdefRecord(ndefRecord);
            textView.setText(tagContent);

        }else{
            Toast.makeText(this,"No message found",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        enableForegroundDispatchSystem();
    }

    @Override
    protected void onPause() {
        super.onPause();
        disableForegroundDispatchSystem();
    }

    private void enableForegroundDispatchSystem(){
        Intent intent=new Intent(this,MainActivity.class).addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        IntentFilter[] intentFilter=new IntentFilter[]{};
        nfcAdapter.enableForegroundDispatch(this,pendingIntent,intentFilter,null);
    }
    private void disableForegroundDispatchSystem(){
        nfcAdapter.disableForegroundDispatch(this);
    }

    private void formatTag(Tag tag, NdefMessage ndefMessage){
        try{
            NdefFormatable ndefFormatable=NdefFormatable.get(tag);
            if(ndefFormatable==null){
                Toast.makeText(this,"Tag is not formatable",Toast.LENGTH_LONG).show();
            }
            ndefFormatable.connect();
            ndefFormatable.format(ndefMessage);
            ndefFormatable.close();
            Toast.makeText(this,"tag written",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Log.e("formatTag",e.getMessage());
        }
    }

    private void writeNdefMessage(Tag tag,NdefMessage ndefMessage){
        try{
            if(tag==null){
                Toast.makeText(this,"tag object can not be null",Toast.LENGTH_LONG).show();
                return;
            }

            Ndef ndef=Ndef.get(tag);
            if(ndef==null){
                //format tag with ndef format and write the message
                formatTag(tag,ndefMessage);

            }else{
                ndef.connect();
                if(!ndef.isWritable()){
                    Toast.makeText(this,"tag is not writeable",Toast.LENGTH_LONG).show();
                    ndef.close();
                    return;
                }
                ndef.writeNdefMessage(ndefMessage);
                ndef.close();
                Toast.makeText(this,"tag written",Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Log.e("writeNdefMessage",e.getMessage());
        }
    }

    private NdefRecord createTextRecord(String content){
        try {
            byte[] language;
            language= Locale.getDefault().getLanguage().getBytes("UTF-8");
            final byte[] text=content.getBytes("UTF-8");
            final int languageSize=language.length;
            final int textLength=text.length;
            final ByteArrayOutputStream payload=new ByteArrayOutputStream(1+languageSize+textLength);
            payload.write((byte)(languageSize & 0x1F));
            payload.write(language,0,languageSize);
            payload.write(text,0,textLength);
            return new NdefRecord(NdefRecord.TNF_WELL_KNOWN,NdefRecord.RTD_TEXT,new byte[0],payload.toByteArray());
        } catch (UnsupportedEncodingException e) {
            Log.e("createTextRecord",e.getMessage());
        }
        return null;
    }

    private NdefMessage createNdefMessage(String content){
        NdefRecord ndefRecord=createTextRecord(content);
        NdefMessage ndefMessage=new NdefMessage(new NdefRecord[]{ndefRecord});
        return ndefMessage;
    }

    public void readWriteClick(View view){
        textView.setText("");

    }

    public String getTextFromNdefRecord(NdefRecord ndefRecord){
        String tagContent=null;
        try{
            byte[] payload=ndefRecord.getPayload();
            String textEncoding=((payload[0] & 128) == 0)?"UTF-8":"UTF-16";
            int languageSize=payload[0] & 0063;
            tagContent=new String(payload,languageSize+1,payload.length-languageSize-1,textEncoding);

        } catch (UnsupportedEncodingException e) {
            Log.e("error",e.getMessage());
        }
        return  tagContent;
    }
}
