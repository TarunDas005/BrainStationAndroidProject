package com.example.bs148.firebaseretrieveimage;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private Button uploadButton;
    private ImageView imageView;
    private static final int CAMERA_REQ_CODE = 1;
    private StorageReference storageReference;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storageReference = FirebaseStorage.getInstance().getReference();
        uploadButton = (Button) findViewById(R.id.uploadButton);
        imageView = (ImageView) findViewById(R.id.imageView);
        progressDialog = new ProgressDialog(this);
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQ_CODE && resultCode == RESULT_OK) {
            progressDialog.setMessage("Uploading Image ...");
            progressDialog.show();
            progressDialog.setCancelable(false);
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Uri uri = getImageUri(imageBitmap);
            StorageReference filePath = storageReference.child("Photos").child(uri.getLastPathSegment());
            filePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progressDialog.dismiss();

                    //for downloading
                    Uri downloadUri=taskSnapshot.getDownloadUrl();
                    Picasso.with(MainActivity.this).load(downloadUri).fit().centerCrop().into(imageView);
                    Toast.makeText(MainActivity.this, "Uploading Complete", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public Uri getImageUri(Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(MainActivity.this.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }
}
