package com.example.bs148.nfctestdemo;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    NfcAdapter nfcAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!weHavePermissionToReadContacts())
            requestReadContactsPermissionFirst();
        nfcAdapter= NfcAdapter.getDefaultAdapter(this);
        if(nfcAdapter !=null && nfcAdapter.isEnabled()){
            //Toast.makeText(this,"NFC available",Toast.LENGTH_LONG).show();
        }else{
            //Toast.makeText(this,"NFC not available",Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Toast.makeText(this,"NFC intent received",Toast.LENGTH_LONG).show();
        super.onNewIntent(intent);

    }

    @Override
    protected void onResume() {
        Intent intent=new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);
        IntentFilter[] intentFilter=new IntentFilter[]{};
        nfcAdapter.enableForegroundDispatch(this,pendingIntent,intentFilter,null);
        super.onResume();
    }

    @Override
    protected void onPause() {
        nfcAdapter.disableForegroundDispatch(this);
        super.onPause();
    }


    private boolean weHavePermissionToReadContacts() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.NFC) == PackageManager.PERMISSION_GRANTED;
    }
    private void requestReadContactsPermissionFirst() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.NFC)) {
            Toast.makeText(this, "We need permission so you can text your friends.", Toast.LENGTH_LONG).show();
            requestForResultContactsPermission();
        } else {
            requestForResultContactsPermission();
        }
    }
    private void requestForResultContactsPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.NFC}, 123);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 123
                && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }
}
