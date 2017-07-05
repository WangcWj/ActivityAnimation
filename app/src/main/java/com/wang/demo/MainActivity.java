package com.wang.demo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] imageId ={
            "http://preview.quanjing.com/tongrorf0010/tip101t011779.jpg",
            "http://preview.quanjing.com/mhrf006/mhrf-cpmh-85596f07z.jpg",
            "http://preview.quanjing.com/bjisub006/bji04320269.jpg",
            "http://preview.quanjing.com/tongrorf0048/ti302a1201.jpg",
            "http://preview.quanjing.com/tongrorf0048/ti219a6606.jpg",
            "http://preview.quanjing.com/tongrorf0048/ti219a6604.jpg"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final List<String> list = new ArrayList<>();
        for (int i = 0; i <imageId.length ; i++) {
            list.add(imageId[i]);
        }
        ImageAdapter adapter = new ImageAdapter(list,this);
        adapter.setMeOnclick(new ImageAdapter.MeOnclick() {
            @Override
            public void mOnClick(ImageView view, int position) {
                //点击全屏跳转
                Intent intent = new Intent(MainActivity.this, BigImageActivity.class);
                intent.putExtra("path", list.get(position));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions
                            .makeSceneTransitionAnimation(MainActivity.this, (ImageView)view, "图片");
                    startActivity(intent, options.toBundle());
                } else {
                    //让新的Activity从一个小的范围扩大到全屏
                    ActivityOptionsCompat options = ActivityOptionsCompat
                            .makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);
                    ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());
                }
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
