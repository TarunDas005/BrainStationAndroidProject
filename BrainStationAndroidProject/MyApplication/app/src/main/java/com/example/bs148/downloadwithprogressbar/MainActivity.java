package com.example.bs148.downloadwithprogressbar;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    ImageView my_image,picassoImage;
    Button btnShowProgress;
    Button btnClearImage;
    Button picassoButton;
    private ProgressDialog pDialog;
    private static String file_url = "http://api.androidhive.info/progressdialog/hive.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowProgress= (Button) findViewById(R.id.btnProgressBar);
        btnClearImage= (Button) findViewById(R.id.clearImageButton);
        my_image= (ImageView) findViewById(R.id.asynctaskImage);
        picassoImage= (ImageView) findViewById(R.id.picassoImage);
        picassoButton= (Button) findViewById(R.id.picassoButton);
        my_image.setImageResource(0);
        picassoImage.setImageResource(0);
        btnShowProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadFileFromURL().execute(file_url);
            }
        });
        btnClearImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_image.setImageResource(0);
                picassoImage.setImageResource(0);
            }
        });
        picassoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(getApplicationContext()).load("http://i.imgur.com/DvpvklR.png").into(picassoImage);
            }
        });
    }

    public  void setProgressDialog() {
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Downloading file. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setMax(100);
        pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pDialog.setCancelable(false);
        pDialog.show();


    }
    public  void dismissDialog() {
        try {
            if ((pDialog != null) && pDialog.isShowing()) {
                pDialog.dismiss();
            }
        } catch (final IllegalArgumentException e) {
            e.printStackTrace();

        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            pDialog = null;
        }
    }

    class DownloadFileFromURL extends AsyncTask<String,String,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setProgressDialog();
        }
        @Override
        protected String doInBackground(String... params) {
            int count=0;
            try{
                URL url=new URL(params[0]);
                URLConnection connection=url.openConnection();
                connection.connect();
                // getting file length
                int lengthOfFile=connection.getContentLength();
                // input stream to read file - with 8k buffer
                InputStream inputStream=new BufferedInputStream(url.openStream(),8192);
                // Output stream to write file
                OutputStream outputStream=new FileOutputStream("/sdcard/downloadedfile.jpg");
                byte data[]=new byte[1024];
                long total=0;
                while ((count=inputStream.read(data))!=-1){
                    total+=count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress(""+(int)((total*100)/lengthOfFile));

                    // writing data to file
                    outputStream.write(data,0,count);
                }

                outputStream.flush();
                outputStream.close();
                inputStream.close();
            }catch (Exception e){
                Log.e("Error: ",e.getMessage());
            }
            return null;
        }
        /**
         * Updating progress bar
         * */
        @Override
        protected void onProgressUpdate(String... progress) {
            super.onProgressUpdate(progress);
            pDialog.setProgress(Integer.parseInt(progress[0]));
        }

        /**
         * After completing background task
         * Dismiss the progress dialog
         * **/

        @Override
        protected void onPostExecute(String file_url) {
            super.onPostExecute(file_url);
            dismissDialog();
            // Displaying downloaded image into image view
            // Reading image path from sdcard
            String imagePath = Environment.getExternalStorageDirectory().toString() + "/downloadedfile.jpg";
            // setting downloaded into image view
            my_image.setImageDrawable(Drawable.createFromPath(imagePath));
        }
    }
}
