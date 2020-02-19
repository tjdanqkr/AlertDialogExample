package com.example.android.alertdialogexample;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int indexSingleChoice=0;
    private  boolean[] indexMultiChoice = {false,false,false,false,false,false,false};
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
    //프로그레스 다이알로그 안씀 그래서 다른 방법을 해야함 작대기 쳐진것 deflicate
    public void  dialogProgress(View v){
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("처리중");
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setMessage("잠시만 기다려주세요");
        progressDialog.show();
    }
    // 단일 항목 선택 대화상자
    public void dialogSingleChoice(View v){
        new AlertDialog.Builder(this).setTitle("단일 항목 선택").setIcon(R.mipmap.ic_launcher).setSingleChoiceItems(R.array.lists,indexSingleChoice,new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String[] androidList = getResources().getStringArray(R.array.lists);
                Toast.makeText(MainActivity.this,androidList[i]+"선택하셧습니다.",Toast.LENGTH_LONG).show();
            }
        }).setPositiveButton("ok", null).show();
    }
    public void dialogMultipleChoice(View v){

       new AlertDialog.Builder(this).setTitle("중복대화 상자").setIcon(R.mipmap.ic_launcher).
                setMultiChoiceItems(R.array.lists, indexMultiChoice, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        Log.d("선택", i + "항목선택?" + b);
                        indexMultiChoice[i] = b;
                    }
                }).show();
    }
    public void dialogCustomLayout(View v){
        //dialog_custom.xml 객체로 만들어야함
        LayoutInflater inflater = getLayoutInflater();
        //inglater 는 xml 레이아웃을 실제 객체로 변환해주는 기능을 수행
        final View rootView = inflater.inflate(R.layout.dialog_custom, null);
        new AlertDialog.Builder(this).setTitle("커스텀").setIcon(R.mipmap.ic_launcher).setView(rootView)//다이얼로그 내부에서 사용할 레이아웃 객체
        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("customDialog","사용자 정의 다이얼로그");
                EditText password = rootView.findViewById(R.id.password);
                Toast.makeText(MainActivity.this,"사용자 암호:" + password.getText().toString(),Toast.LENGTH_LONG).show();
            }
        }).show();
    }
}
