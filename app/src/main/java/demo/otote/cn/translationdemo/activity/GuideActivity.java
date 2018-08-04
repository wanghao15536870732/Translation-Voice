package demo.otote.cn.translationdemo.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import demo.otote.cn.translationdemo.R;

public class GuideActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int[]images={R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
    private List<ImageView> imageViews;//用来存放几个imageview的实例
    private LinearLayout li;
    private RelativeLayout rl;
    private ImageView red_Iv;
    private int left;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);
        viewPager=(ViewPager) findViewById(R.id.viewPager);
        li=(LinearLayout) findViewById(R.id.linear);
        rl=(RelativeLayout) findViewById(R.id.rl);
        btn=(Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GuideActivity.this,VoiceActivity.class);
                startActivity(intent);
            }
        });

        viewPager.setAdapter(new MyAdapter());
        imageViews=new ArrayList<ImageView>();
        for(int i=0;i<images.length;i++){
            ImageView imageView=new ImageView(this);
            imageView.setImageResource(images[i]);
            imageViews.add(imageView);
            ImageView gray_Iv=new ImageView(this);
            gray_Iv.setImageResource(R.drawable.gray_circle);
            //使用LayoutParams改变控件的位置
            LinearLayout.LayoutParams layoutParams=
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
            if(i>0){
                layoutParams.leftMargin=20;
            }
            gray_Iv.setLayoutParams(layoutParams);
            li.addView(gray_Iv);
        }
        red_Iv=new ImageView(this);
        red_Iv.setImageResource(R.drawable.red_circle);
        rl.addView(red_Iv);
        //示图树
        red_Iv.getViewTreeObserver().
                addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    //该方法就是在界面全面绘制结束之后回调
                    @Override
                    public void onGlobalLayout() {
                        // TODO Auto-generated method stub
                        //求距离
                        left=li.getChildAt(1).getLeft()-li.getChildAt(0).getLeft();
                        System.out.println("left为"+left);
                        red_Iv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                if(position==images.length-1){
                    btn.setVisibility(View.VISIBLE);
                }else{
                    btn.setVisibility(View.GONE);
                }
            }
            //滑动的时候
            @Override
            public void onPageScrolled(int position, float posionOffset, int arg2) {
                // TODO Auto-generated method stub
                System.out.println(posionOffset);//滑动的百分比
                RelativeLayout.LayoutParams layoutParams=
                        (RelativeLayout.LayoutParams)red_Iv.getLayoutParams();
                layoutParams.leftMargin=(int)(left*posionOffset+position*left);
                red_Iv.setLayoutParams(layoutParams);
            }
            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub
            }
        });
    }
    class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return images.length;
        }
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0==arg1;
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
            container.addView(imageViews.get(position));
            return imageViews.get(position);
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            container.removeView((View)object);
        }
    }
}
