package com.example.admin.kavik;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {
    private    int[] images;
    private  ImageView imageSlide;
    private    Handler handler;
    private    int imageNo = 0;




    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);
        setContentView(R.layout.activity_gallery);

        final HorizontalScrollView horiscrollView;

        images = new int[]{R.drawable.kavik_nzwhitebait, R.drawable.kavik_strawberrydesert,
                R.drawable.kavik_newseasonasparagus, R.drawable.kavik_canterberryduskbreast};

        imageSlide = findViewById(R.id.imageslide);


        handler = new Handler();

        new ChangeImagesThread().start();



    }
    class ChangeImagesThread extends Thread{
        public void run() {
            while(true){
                final int imageLocation= images[imageNo];
                Log.d("Image Number = ", ""+imageNo);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageSlide.setImageResource(imageLocation);
                    }
                });
                imageNo++;
                if(imageNo >= images.length) imageNo=0;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }



}





