package com.example.testt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
        private Button btn_2;
        private ImageView iv_image;
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.e(this.getClass().getName(), "onCreate");
            setContentView(R.layout.activity_main);
            btn_2 = findViewById(R.id.btn_2);
            iv_image = findViewById(R.id.iv_image);
            btn_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_PICK, null);
                    intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                    startActivityForResult(intent, 2);
                }
            });
        }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 2) {
                // 从相册返回的数据
                Log.e(this.getClass().getName(), "Result:" + data.toString());
                if (data != null) {
                    // 得到图片的全路径
                    Uri uri = data.getData();
                    iv_image.setImageURI(uri);
                    Log.e(this.getClass().getName(), "Uri:" + String.valueOf(uri));
                }
            }
        }
    }