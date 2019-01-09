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
            <td align="center">用户只需安装好app,并且在保持网络良好的情况下，即可进行十八种语言的相互翻译</td>
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
             <th>语音转文字</th>
            <td align="center">用户通过点击该功能，可以将语音转为文字，暂时也是只支持英语跟汉语</td>
        </tr>
        <tr>
            
</table>

<br />

</div>

<div align="center">

## 功能界面
||||
|:--:|:--:|:--:|
|百度翻译界面(十八种语言)|侧滑栏界面|侧滑栏的生词本|
|![Screenshot_20180805-170422.png](https://upload-images.jianshu.io/upload_images/9140378-c9d2a4ba02ab625f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/250)|<div align=center><img width="250" height="405" src="https://github.com/wanghao15536870732/Translation-Voice/blob/master/picture/Screenshot_20180712-162101.png"/>|<div align=center><img width="250" height="405" src="https://github.com/wanghao15536870732/Translation-Voice/blob/master/picture/Screenshot_20180712-162237.png"/></div>|
|主界面翻译过的组可进行收藏跟删除|科大讯飞语音识别跟界面|科大讯飞语音合成界面|
|![Screenshot_20180805-170415.png](https://upload-images.jianshu.io/upload_images/9140378-ed116e6bc4feac16.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/250) |<div align=center><img width="250" height="405" src="https://github.com/wanghao15536870732/Translation-Voice/blob/master/picture/Screenshot_20180712-162224.png"/></div> | <div align=center><img width="250" height="405" src="https://github.com/wanghao15536870732/Translation-Voice/blob/master/picture/Screenshot_20180712-162231.png"/></div>|
 
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
 #### [科大讯飞语音开放平台](http://www.xfyun.cn/)
 
 MyApplication.java
 ```java
SpeechUtility.createUtility(this, SpeechConstant.APPID + "=5ad97691");
RecognitionManager.getSingleton().init(this,"5ad97691");
SynthesisManager.getSingleton().init(this,"5ad97691");
 ```
 #### [百度翻译开放平台](https://fanyi-api.baidu.com/api/trans/product/index)
 
 IDActivity.class
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
 ```
## LICENSE
```java
   Copyright 2018 wanghao15536870732

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
limitations under the License.
```
