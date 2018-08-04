<div align="center">
<img src="https://github.com/wanghao15536870732/Translation-Voice/blob/master/logo_t.png" height="100px" width="100px"/>
 
<h1>  Translation-Voice（语译） </h1>

#### 一个整合百度翻译（支持多种语言）跟科大讯飞的口语翻译app
<br />
<a href="https://github.com/wanghao15536870732/Translation-Voice/blob/master/app-release.apk?raw=true">点击下载</a>

<br />

### Feature (功能)

<table border="1px solid green" style="border-collapse: collapse" cellpadding="15">
        <tr>
            <th width="100px">功能名称</th>
            <td align="center"><strong>功能描述</strong></td>
        </tr>
        <tr>
            <th>翻译功能</th>
            <td align="center">用户只需安装好app,并且在保持网络良好的情况下，即可进行十几种语言的相互翻译</td>
        </tr>
        <tr>
            <th>生词本功能</th>
            <td align="center">1) 用户在进行语言的翻译后，就会出现一个对应的翻译item,用户通过点击星星即可进行收藏，之后可以在侧滑栏当中的生词本进行查看
        </tr>
        <tr>
            <th>语音识别功能</th>
            <td align="center">用户通过点击该功能，可以将不标准的语言转换成普通话，进行播放，只是暂时只支持汉语跟英语</td>
        </tr>
        <tr>
            <th>语音合成</th>
            <td align="center">用户通过点击该功能，可以将翻译界面翻译好的词，进行语音播放，暂时只支持汉语跟英语</td>
        </tr>
        <tr>
            
</table>

<br />


## 功能界面
|||
|:--:|:--:|
|百度翻译界面|侧滑栏界面|
|<div align=center><img width="290" height="505" src="https://github.com/wanghao15536870732/Translation-Voice/blob/master/picture/Screenshot_20180712-162118.png"/></div>|<div align=center><img width="290" height="505" src="https://github.com/wanghao15536870732/Translation-Voice/blob/master/picture/Screenshot_20180712-162101.png"/>|
|实际中语言互相翻译|侧滑栏的生词本|
|<div align=center><img width="290" height="505" src="https://github.com/wanghao15536870732/Translation-Voice/blob/master/picture/Screenshot_20180712-162149.png"/></div> |<div align=center><img width="290" height="505" src="https://github.com/wanghao15536870732/Translation-Voice/blob/master/picture/Screenshot_20180712-162237.png"/></div>|
|科大讯飞语音识别跟界面|科大讯飞语音合成界面|
|<div align=center><img width="290" height="505" src="https://github.com/wanghao15536870732/Translation-Voice/blob/master/picture/Screenshot_20180712-162224.png"/></div> | <div align=center><img width="290" height="505" src="https://github.com/wanghao15536870732/Translation-Voice/blob/master/picture/Screenshot_20180712-162231.png"/></div>|
 
 </div>
 
 
## 添加的依赖
```java
 implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:26.1.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.0'
    implementation 'com.android.support:design:26.1.0'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    implementation files('libs/Msc.jar')
    implementation files('libs/gson-2.8.1.jar')
 ```
 ## 登陆[科大讯飞的官网](http://www.xfyun.cn/)注册账号下载新的SDK导入<br>并且修改MyApplication.java类的科大讯飞的参数即可使用
 ```java
        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=5ad97691");
        RecognitionManager.getSingleton().init(this,"5ad97691");
        SynthesisManager.getSingleton().init(this,"5ad97691");
 ```
 ## 登陆[翻译开放平台](https://fanyi-api.baidu.com/api/trans/product/index)<br>并申请成为开发者创建应用将你的AppID和password写入对应文件即可<br>别忘了重新导入jar包
 #### IDActivity.class
 ```java
                String appid = "你应用的AppID"
                String pw = "对应的password"

                File dir = getApplicationContext().getFilesDir();//查找这个应用下的所有文件所在的目录
                Log.d("文件夹：" , dir.getAbsolutePath());
                FileWriter writer;
                try {
                    writer = new FileWriter(dir.getAbsolutePath() + "/userinfo.txt");
                    writer.append(appid+","+pw+","+choose);
                    writer.close();
                    ToastUtil.showToast(IDActivity.this,"设置成功");
                } catch (IOException e) {
                    e.printStackTrace();
                }
           }
 ```
