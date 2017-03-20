

![Image text](https://github.com/385841539/BarrageView/blob/master/app/src/main/res/mipmap-hdpi/xiahoushi.jpg)

# BarrageView- 

 效果图  ：
 
![Image text](https://github.com/385841539/BarrageView/blob/master/app/src/main/res/drawable/dangif.gif)</br>

## HowTo Use?/如何使用?-
 
### 1:添加 依赖（或者直接把BarrageView这个类放到项目里面)</br>
>> 1.先在 build.gradle(Project:XXXX) 的 repositories 添加:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

>> 2.然后在 build.gradle(Module:app) 的 dependencies 添加:
 
 ```
 dependencies {
	        compile 'com.github.385841539:BarrageView:-SNAPSHOT'
	}
```

### 2:布局文件


```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.ruedy.barrageviewtest.MainActivity">

    <com.example.ruedy.barrageviewtest.BarrageView
        android:id="@+id/bv"
        android:layout_width="match_parent"
        android:layout_height="350dp" />

    <Button
        android:id="@+id/bt_add"
        android:layout_width="70dp"
        android:layout_height="45dp"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="100dp"
        android:text="添加" />
</RelativeLayout>

```

### 3:添加 字幕的方法：

```
 bv.addTextitem(content);
```
 
 
自定义弹幕View，简单实现安卓弹幕，一个类BarrageView搞定，用法简单

具体实现思路请看博客 http://blog.csdn.net/iamdingruihaha/article/details/61421381

有问题欢迎多多反馈，相信我们会做的更好）
