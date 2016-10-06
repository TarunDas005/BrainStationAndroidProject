package com.example.bs148.uploadaudioinfirebase;

import android.app.ProgressDialog;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button recordButton;
    private TextView recordLevel;
    private MediaRecorder mRecorder;
    private String mFileName;
    private static final String LOG_TAG="Record_log";
    private StorageReference storageReference;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recordButton= (Button) findViewById(R.id.recordButton);
        recordLevel= (TextView) findViewById(R.id.recordLevel);
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/record_audio.3gp";
        progressDialog=new ProgressDialog(this);
        storageReference= FirebaseStorage.getInstance().getReference();
        recordButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    startRecording();
                    recordLevel.setText("Recording Started ...");
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    stopRecording();
                    recordLevel.setText("Recording Stopped");
                }
                return false;
            }
        });
    }
    private void startRecording() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        mRecorder.start();
    }

    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
        UploadAudio();
    }

    private void UploadAudio() {
        progressDialog.setMessage("Uploading Audio ...");
        progressDialog.show();
        StorageReference filePath=storageReference.child("Audio").child("new_audio.3gp");
        Uri uri=Uri.fromFile(new File(mFileName));
        filePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                progressDialog.dismiss();
                recordLevel.setText("Uploading Finished");
            }
        });
    }

}
