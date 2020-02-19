package com.example.android.alertdialogexample;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //단순 메세지 대화상자 출력

    }
    public void dialogMessege(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Hello, android");

        builder.show();
    }
    //닫기 버튼
    public void dialogCloseButton(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림").setIcon(R.mipmap.ic_launcher).setMessage("Hello, android").setCancelable(true).setNegativeButton("닫기",null).show();
    }
    //ok,cancel , neutral 세개의 버튼이 있는 다이알로그
    public void dialogOKCancelButton(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림").setIcon(R.mipmap.ic_launcher).setMessage("헹로 안드로이드").setCancelable(false).setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"yes버튼 클릭",Toast.LENGTH_LONG).show();
            }
        }).setNeutralButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "No 클릭",Toast.LENGTH_LONG).show();
            }
        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "캔슬 클릭",Toast.LENGTH_LONG).show();

            }
        });
        builder.show();
    }
    public void dialogList(View v){
        //R.Array.Lists
        new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher).setTitle("선택하세료").setItems(R.array.lists,new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {  //선택된 항목의 인덱스
                //array 리소스로 string 배열 만들기
                String[] andriodList= getResources().getStringArray(R.array.lists);
                Toast.makeText(MainActivity.this, andriodList[i], Toast.LENGTH_LONG).show();
            }
        }).setCancelable(false).show();
    }

}
