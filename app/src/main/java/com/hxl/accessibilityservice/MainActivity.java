package com.hxl.accessibilityservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText replyWords;
    private Button button;
    private ImageView exa_image;
    private LinearLayout instruction_layout;
    private LinearLayout input_layout;
    private ImageView bigImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        replyWords = (EditText) findViewById(R.id.reply_words);
        button = (Button) findViewById(R.id.ok_btn);
        exa_image = (ImageView) findViewById(R.id.example_image);
        instruction_layout = (LinearLayout) findViewById(R.id.instruction);
        input_layout = (LinearLayout) findViewById(R.id.input);
        bigImage = (ImageView) findViewById(R.id.example_big);

        button.setOnClickListener(this);
        exa_image.setOnClickListener(this);
        bigImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok_btn:
                final String reply = replyWords.getText().toString();
                if (reply == null || reply.equals("")){
                    Toast.makeText(this, "调皮！不可以设置空消息哦", Toast.LENGTH_SHORT).show();
                }else{
                    AutoManager.getInstance().setReplyListener(new AutoManager.ReplyKeywordsChangeListenner() {
                        @Override
                        public String getReplyWords() {
                            return reply;
                        }
                    });
                    Toast.makeText(this, "设置完成", Toast.LENGTH_SHORT).show();
                    instruction_layout.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.example_image:
                input_layout.setVisibility(View.GONE);
                instruction_layout.setVisibility(View.GONE);
                bigImage.setVisibility(View.VISIBLE);
                break;
            case R.id.example_big:
                input_layout.setVisibility(View.VISIBLE);
                instruction_layout.setVisibility(View.VISIBLE);
                bigImage.setVisibility(View.GONE);
                break;
        }
    }




}





