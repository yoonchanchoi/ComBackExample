package com.example.combackexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextView tv_comback;
    private Button btn_go;
    private static final int REQUEST_CODE = 777;                    // 상수 값을 선언 +상수(항상 같은 수 + 변하지않을 수)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv_comback=findViewById(R.id.tv_comback);
        btn_go=findViewById(R.id.btn_go);

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SubActivity.class);
                startActivityForResult(intent, REQUEST_CODE);       // 해당 deprecated는 2020/5에 되었다고 한다. 하지만 공식문에서 찾아보지는 못했다.ㅠㅠ
                                                                    // AndroidX Activity, Fragment에 도입된 Activity Result API 사용권장과
                                                                    // 로직을 사용할 때, 메모리 부족으로 인해 프로세스와 Activity가 사라질 수 있음
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Toast.makeText(getApplicationContext(), "수신 성공", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getApplicationContext(), "수신 실패", Toast.LENGTH_SHORT).show();
        }

        if(requestCode == REQUEST_CODE){
            String resultTxt =data.getStringExtra("comeback");
            tv_comback.setText(resultTxt);
        }
    }
}