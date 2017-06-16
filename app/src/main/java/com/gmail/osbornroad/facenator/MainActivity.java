package com.gmail.osbornroad.facenator;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_STORAGE_PERMISSION = 1;


    private ImageView mImageView;

    private FloatingActionButton mStartCameraButton;
    private FloatingActionButton mShareFab;
    private FloatingActionButton mSaveFab;
    private FloatingActionButton mClearFab;
    private TextView mTitleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.main_image_view);
        mStartCameraButton = (FloatingActionButton) findViewById(R.id.start_camera_button);
        mShareFab = (FloatingActionButton) findViewById(R.id.share_button);
        mSaveFab = (FloatingActionButton) findViewById(R.id.save_button);
        mClearFab = (FloatingActionButton) findViewById(R.id.clear_button);
        mTitleTextView = (TextView) findViewById(R.id.title_text);
    }

    public void takePicture(View view) {
        // Check for the external storage permission
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // If you do not have permission, request it
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_STORAGE_PERMISSION);
        } else {
            // Launch the camera if the permission exists
            launchCamera();
        }
    }

    private void launchCamera() {

    }
}
