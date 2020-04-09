package cn.edu.sdwu.android.classroom.sn170507180122;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ch4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载界面,引用，使用资源ID引用资源，通过编号来访问
        setContentView(R.layout.layout_ch4_1);

        //(1)获取界面组件,通过id找界面，然后放到类里，保存一下
        Button button=(Button) findViewById(R.id.button1);
        //(2)实现事件监听类，
        //（3）调用事件源的setxxxListener方法注册事件监听器

 

    }
    //写一个内部类，实现监听器的接口,onclick方法
    class MyClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {

        }
    }
}
