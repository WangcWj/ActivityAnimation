# ActivityAnimation
Activity跳转动画
## 这里采用的是自带的动画处理效果    
```
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
```   
 
## 要注意的是在你的ImageView的xml里面要加上android:transitionName="@string/图片"这个标记和你设置的makeSceneTransitionAnimation里面的第三个参数 要一致,另外在你的将要跳转的Activity里面的ImageView的xml里面也要定义这个属性.   
```
 <ImageView
     android:id="@+id/image"
     android:scaleType="centerCrop"
     android:layout_width="match_parent"
     android:fitsSystemWindows="true"
     android:transitionName="@string/transition_movie_photos"
     android:layout_height="200dp" />   
```
             
