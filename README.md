# Translation-Voice
## 一个整合百度翻译（支持多种语言）跟科大讯飞的口语翻译app
|||
|:--:|:--:|
|百度翻译界面|科大讯飞语音识别跟语音合成界面|
|<div align=center><img width="290" height="505" src="https://github.com/wanghao15536870732/Translation-Voice/blob/master/Screenshot_20180621-190257.png"/></div>|<div align=center><img width="290" height="505" src="https://github.com/wanghao15536870732/Translation-Voice/blob/master/Screenshot_20180621-190304.png"/>|
|选择想要翻译的语言|选择目标语言|
|<div align=center><img width="290" height="505" src="https://github.com/wanghao15536870732/Translation-Voice/blob/master/Screenshot_20180621-190249.png"/></div> |<div align=center><img width="290" height="505" src="https://github.com/wanghao15536870732/Translation-Voice/blob/master/Screenshot_20180621-190238.png"/></div>|

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
