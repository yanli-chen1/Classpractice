package cn.edu.sdwu.android.classroom.sn170507180122;

import android.app.WallpaperManager;
import android.media.MediaCodec;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ch4Activity extends AppCompatActivity implements View.OnFocusChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载界面,引用，使用资源ID引用资源，通过编号来访问
        setContentView(R.layout.layout_ch4_1);

        //(1)获取界面组件,通过id找界面，然后放到类里，保存一下.必须在设置布局文件后，才能调用
        Button button=(Button) findViewById(R.id.button1);
        ImageView imageView=(ImageView) findViewById(R.id.ch4_iv);

        //（3）调用事件源的setxxxListener方法注册事件监听器
        button.setOnClickListener(new MyClickListener());

        //使用内部匿名类注册监听器，写在oncreate里
        imageView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                //设置壁纸
                WallpaperManager wallpaperManager=(WallpaperManager) getSystemService(WALLPAPER_SERVICE);
                try{
                    wallpaperManager.setResource(R.raw.timg);
                }catch (Exception e){
                    Log.e(Ch4Activity.class.toString(),e.toString());
                }


                return true;
            }
        });
        EditText email=(EditText) findViewById(R.id.ch4_1_email);
        email.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        //参数B代表是否获取焦点
        //判读邮箱地址的合法性
        EditText editText=(EditText)view;
        if(!b){
            String content =editText.getText().toString();//得到Edittext内容
            //正则表达式，判断邮箱合法性
            String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern pattern=Pattern.compile(regEx1);
            Matcher matcher=pattern.matcher(content);
            TextView textView=(TextView)findViewById(R.id.ch4_1_tv);
            if(matcher.matches()){
                textView.setText("");
            }else{
                textView.setText("email invalidate");

            }

        }
    }

    //(2)实现事件监听类，写一个内部类，实现监听器的接口,onclick方法
    class MyClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Log.i (Ch4Activity.class.toString(),"button click");}
    }
}
