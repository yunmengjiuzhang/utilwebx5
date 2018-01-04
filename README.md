# utilwebx5
腾讯x5内核的X5WebView
1.根build.gradle

    allprojects {
        repositories {
            google()
            jcenter()
            maven { url 'https://jitpack.io' } //添加仓库
        }
    }
2.module的build.gradle

    compile 'com.github.wangfeixixi:utilwebx5:v1.4'//添加依赖
     
     
完工体验：
          方法一：布局中
             <wangfei.utilwebx5.X5WebView
                android:id="@+id/webview"
                android:layout_width="match_parent"
                android:layout_height="match_parent"/>
     
           方法二：new 对象
     
     
如果觉得好请给我点赞哈！

如果需要进一步交流，邮件哦：xuanyuanxixi@foxmail.com
[![](https://jitpack.io/v/wangfeixixi/utilwebx5.svg)](https://jitpack.io/#wangfeixixi/utilwebx5)
