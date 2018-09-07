package demo.otote.cn.translationdemo.Application;

import android.app.Application;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import demo.otote.cn.translationdemo.utils.RecognitionManager;
import demo.otote.cn.translationdemo.utils.SynthesisManager;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=5ad97691");
        RecognitionManager.getSingleton().init(this,"5ad97691");
        SynthesisManager.getSingleton().init(this,"5ad97691");
    }
}
