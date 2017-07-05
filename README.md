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
                  
