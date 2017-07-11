# Launcher
===
##介绍

1.MVC设计模式，
2.搭建RxJava框架，Viewpager+fragment懒加载。rxjava+retrofit2 实现网络请求。<br>
3.设置界面的编写PreferenceFragment。可设置无图，自动加载，双击退出<br>
4.pull和sax 解析xml。<br>
5.添加主页图片，图片浏览photoview。将图片保存至本地。本地选取图片，matisse<br>
6.视频界面。recycleview中5中布局加载。banner的使用。 <br>
7.番剧详情界面。多个recycleview，toolbar透明设置。<br>

用到的第三方库：<br>
    compile 'com.android.support:cardview-v7:25.1.0'<br>
    compile 'com.android.support:design:25.1.0'<br>
    //rx+retrofit<br>
    compile 'com.trello:rxlifecycle-components:0.6.1'<br>
    compile 'io.reactivex:rxandroid:1.1.0'<br>
    compile 'io.reactivex:rxjava:1.1.0'<br>
    compile 'com.squareup.retrofit2:retrofit:2.0.0-beta4'<br>
    compile 'com.squareup.retrofit2:adapter-rxjava:2.0.0-beta4'<br>
    compile 'com.squareup.retrofit2:converter-gson:2.0.0-beta4'<br>
    compile 'com.squareup.okhttp3:okhttp:3.2.0'<br>
    //butterknife<br>
    compile 'com.jakewharton:butterknife:8.4.0'<br>
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.4.0'<br>
    compile 'com.github.bumptech.glide:glide:3.7.0'<br>
    //选取图库图片<br>
    compile 'com.zhihu.android:matisse:0.4.3'<br>
    //内存泄露检测<br>
    testCompile 'com.squareup.leakcanary:leakcanary-android-no-op:1.5.1'<br>
    debugCompile 'com.squareup.leakcanary:leakcanary-android:1.5.1'<br>
    releaseCompile 'com.squareup.leakcanary:leakcanary-android-no-op:1.5.1'<br>
    /* 图片浏览器所需 */<br>
    compile 'com.github.chrisbanes:PhotoView:2.0.0'<br>
    //数据库<br>
    compile 'org.litepal.android:core:1.5.1'<br>
    compile 'com.youth.banner:banner:1.4.9'<br>
    //图片模糊<br>
    compile 'jp.wasabeef:glide-transformations:2.0.1'<br>
    //标签<br>
    compile 'com.zhy:flowlayout-lib:1.0.1'<br>
    //沉浸式状态栏<br>
    compile 'com.jaeger.statusbarutil:library:1.4.0'<br>

##随便贴贴图<br>
![](https://github.com/LinKermit/Laucher/raw/master/screen/home.PNG)

![](https://github.com/LinKermit/Laucher/raw/master/screen/image.PNG)

![](https://github.com/LinKermit/Laucher/raw/master/screen/shipin.PNG)

![](https://github.com/LinKermit/Laucher/raw/master/screen/详情.PNG)

![](https://github.com/LinKermit/Laucher/raw/master/screen/设置.PNG)

