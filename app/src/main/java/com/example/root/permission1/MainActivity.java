package com.example.root.permission1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView imageview,imageview1;
    Bitmap bitmap;
    View view;
    ByteArrayOutputStream bytearrayoutputstream,bytearrayoutputstream1,bytearrayoutputstream2,bytearrayoutputstream3;
    File file, file1,file2,file3,file4;
    FileOutputStream fileoutputstream,fileoutputstream1,fileoutputstream2,fileoutputstream3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageview = (ImageView)findViewById(R.id.imageView2);
        imageview = (ImageView)findViewById(R.id.imageView3);

        imageview = (ImageView)findViewById(R.id.imageView4);
        imageview = (ImageView)findViewById(R.id.imageView5);

        bytearrayoutputstream = new ByteArrayOutputStream();
        bytearrayoutputstream1 = new ByteArrayOutputStream();
        bytearrayoutputstream2 = new ByteArrayOutputStream();
        bytearrayoutputstream3 = new ByteArrayOutputStream();

        button = (Button) findViewById(R.id.button1);



    button.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub




                Drawable drawable1 = getResources().getDrawable(R.drawable.reminder1);
                Drawable drawable2 = getResources().getDrawable(R.drawable.alarm1);
                 Drawable drawable3 = getResources().getDrawable(R.drawable.reminder4);
                Drawable drawable4= getResources().getDrawable(R.drawable.reminder3);


                Bitmap bitmap1 = ((BitmapDrawable) drawable1).getBitmap();
                Bitmap bitmap2 = ((BitmapDrawable) drawable2).getBitmap();
                Bitmap bitmap3 = ((BitmapDrawable) drawable3).getBitmap();
                Bitmap bitmap4 = ((BitmapDrawable) drawable4).getBitmap();


                bitmap1.compress(Bitmap.CompressFormat.PNG, 60, bytearrayoutputstream);
                bitmap2.compress(Bitmap.CompressFormat.PNG, 60, bytearrayoutputstream1);
                bitmap3.compress(Bitmap.CompressFormat.PNG, 60, bytearrayoutputstream2);
                bitmap4.compress(Bitmap.CompressFormat.PNG, 60, bytearrayoutputstream3);


             file = new File(Environment.getExternalStorageDirectory() + "/SampleImage.png");
          file1= new File(Environment.getExternalStorageDirectory() + "/SampleImage1.png");
            file2= new File(Environment.getExternalStorageDirectory() + "/SampleImage3.png");
                file3= new File(Environment.getExternalStorageDirectory() + "/SampleImage4.png");




                try {

                    Log.e("path", "path= " + new File(Environment.getExternalStorageDirectory() + "/SampleImage.png").getCanonicalPath());
                  Log.e("path1", "path1= " + new File(Environment.getExternalStorageDirectory() + "/SampleImage1.png").getCanonicalPath());
                   Log.e("path", "path= " + new File(Environment.getExternalStorageDirectory() + "/SampleImage3.png").getCanonicalPath());
                   Log.e("path", "path= " + new File(Environment.getExternalStorageDirectory() + "/SampleImage4.png").getCanonicalPath());

                } catch (IOException e) {
                    e.printStackTrace();
                }

                sendBroadcast(new Intent(
                        Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));

                sendBroadcast(new Intent(
                      Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file1)));
              sendBroadcast(new Intent(
                      Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file2)));

                sendBroadcast(new Intent(
                       Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file3)));


                try

                {

                    file.createNewFile();
                 file1.createNewFile();
                  file2.createNewFile();
                  file3.createNewFile();


                    fileoutputstream = new FileOutputStream(file);
                  fileoutputstream1 = new FileOutputStream(file1);
                 fileoutputstream2 = new FileOutputStream(file2);
                  fileoutputstream3 = new FileOutputStream(file3);


                    fileoutputstream.write(bytearrayoutputstream.toByteArray());

                    fileoutputstream1.write(bytearrayoutputstream1.toByteArray());
                    fileoutputstream2.write(bytearrayoutputstream2.toByteArray());
                    fileoutputstream3.write(bytearrayoutputstream3.toByteArray());

                    fileoutputstream.close();
                    fileoutputstream1.close();
                    fileoutputstream2.close();
                    fileoutputstream3.close();


                } catch (Exception e)

                {

                    e.printStackTrace();

                }

                Toast.makeText(MainActivity.this, "Image Saved Successfully", Toast.LENGTH_LONG).show();

            }
        });
    }

}