package com.example.ruedy.barrageviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BarrageView bv;
    private Button bt;
    List<String> strings = new ArrayList<String>();
    private int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        strings.add("伴君一生，不寂寞。");
        strings.add("感君一回顾，思君朝雨幕");
        strings.add("陪我到成都的街道走一走");
        strings.add("你会挽着我的衣袖，我会把手塞进裤兜");
        strings.add("我是在等待你的回来");
        strings.add("你是我一生最大的骄傲");
        strings.add("遇上你这男人，就像心沉大海，提也提不起方也放不开");
        size = strings.size();
        bv = ((BarrageView) findViewById(R.id.bv));
        bt = ((Button) findViewById(R.id.bt_add));
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (String content : strings)
                    bv.addTextitem(content);

            }
        });
    }
}
