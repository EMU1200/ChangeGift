package com.example.merrychristmas;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
        int namenum[];
        int num = 0;
        int count=0;
        int drawcount=0;
        String[] nameArr = new String[0];
        String[] nameArrbackup = new String[0];
        String[] drawarr = new String[0];
        EditText etName;
        TextView tvTextview;
        TextView tvnumber,tvrenumber;
        TextView tvtable_name,tvrename;
    String result = "";
    String renum = "";
    MediaPlayer player;
    MediaPlayer player2;
    VideoView videoView;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            etName = findViewById(R.id.name);

            player = MediaPlayer.create(this,R.raw.merrychristmas);
            player.start();
            player.setLooping(true);


        }

        public void goCheckList(View view) {

            String nameSt = etName.getText().toString();
            if (nameSt.length() == 0) {
                String message = "請輸入名稱";
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            } else {

                nameArr = Push_Arr.push(nameArr, etName.getText().toString());
                nameArrbackup = Push_Arr.push(nameArrbackup, etName.getText().toString());
                drawarr = Push_Arr.push(drawarr, etName.getText().toString());
                count ++;


                setContentView(R.layout.check_layout);
                Toast.makeText(this, "恭喜您報名成功:" + etName.getText().toString(), Toast.LENGTH_LONG).show();
                tvTextview = findViewById(R.id.checkTV);
         //       tvTextview.setText("姓名:"+etName.getText().toString()+"\n編號:"+nameArr.length);
                tvTextview.setText("姓名:"+nameArr[nameArr.length-1]+"\n編號:"+nameArr.length);


            }
        }

        public void start(View view) {
            setContentView(R.layout.result);
            tvrenumber = findViewById(R.id.result_id);
            tvrename = findViewById(R.id.result_name);
            tvrenumber.setText(renum);
            tvrename.setText(result);
        }

        public void prePage(View view) {
            setContentView(R.layout.activity_main);

            etName = findViewById(R.id.name);
        }

        public void result_prepage(View view) {
            setContentView(R.layout.activity_main);

            etName = findViewById(R.id.name);

        }

        public void surprise_prepage(View view) {
            setContentView(R.layout.activity_main);

            etName = findViewById(R.id.name);
        }

        public void table_prepage(View view) {
            setContentView(R.layout.activity_main);

            etName = findViewById(R.id.name);
        }
        public void solo(View view) {
            double random;
            int randomint = 0;
            double draw = 0;
            int remind=0;
            random = Math.random() * nameArr.length;
            if (nameArr.length == 0) {
                Toast.makeText(this, "名單尚未有人加入，請確認名單", Toast.LENGTH_LONG).show();

            } else {
                getrandom:
                do {
                    for (int i = 0; i < nameArr.length; i++) {
                        if (nameArr[i] != "") {
                            break;
                        } else {
                            if (i == nameArr.length - 1) {
                                if (nameArr[nameArr.length - 1] == "") {
                                    Toast.makeText(this, "名單上已經沒有人可以抽取了", Toast.LENGTH_LONG).show();
                                   remind=1;
                                    break getrandom;
                                }
                            }
                        }
                    }
                    random = Math.random() * nameArr.length;


                } while (nameArr[(int) random] == "");
                if(count>1) {
                    do {


                        draw = Math.random() * drawarr.length;
                    } while (drawarr[(int) draw] == "" || (int) draw == (int) random);
                }
              if(count>1 && drawcount==0){


                    if (count > 0 && (int) random != (int) draw) {
                        if (nameArr[(int) random] != "") {
                            nameArr[(int) random] = "";
                            result += (nameArrbackup[(int) random] +"　"+ "\n");


                            drawarr[(int) draw] = "";
                            //       randomint = (int) (random + 1);
                            randomint = (int) (draw + 1);
                            renum += randomint +"　"+ "\n";
                        }
                        tvrenumber.setText(renum);
                        tvrename.setText(result);
                        count--;
                        drawcount++;
                    }
                    } else if(count>0 && drawcount>=1) {
                  do {


                      draw = Math.random() * drawarr.length;
                  } while (drawarr[(int) draw] == "" || (int) draw == (int) random);
                  if (count > 0 && (int) random != (int) draw) {
                      if (nameArr[(int) random] != "") {
                          nameArr[(int) random] = "";
                          result += (nameArrbackup[(int) random] +"　"+ "\n");


                          drawarr[(int) draw] = "";
                          //       randomint = (int) (random + 1);
                          randomint = (int) (draw + 1);
                          renum += randomint + "　"+"\n";
                      }
                      tvrenumber.setText(renum);
                      tvrename.setText(result);
                      count--;
                      if(count>0){

                      }else {
                          drawcount = 0;
                      }
                  }
              }else{
                  if(remind==0) {
                      Toast.makeText(this, "名單剩餘人數為0或是整體剩餘1個只能抽取到自己的目標可以抽取\n請添加其他人", Toast.LENGTH_LONG).show();
                      remind=0;
                  }else{

                  }
                  }

            }
        }
        public void all(View view) {
            double random;
            int randomint = 0;
            random = Math.random() * nameArr.length;
            double draw = 0;
            int remind = 0;
            if (nameArr.length == 0) {
                Toast.makeText(this, "名單尚未有人加入，請確認名單", Toast.LENGTH_LONG).show();

            } else {

                    getrandom:
                    do {
                    do {
                        for (int i = 0; i < nameArr.length; i++) {
                            if (nameArr[i] != "") {
                                break;
                            } else {
                                if (i == nameArr.length - 1) {
                                    if (nameArr[nameArr.length - 1] == "") {
                                        Toast.makeText(this, "名單上已經沒有人可以抽取了", Toast.LENGTH_LONG).show();
                                        remind = 1;
                                        break getrandom;
                                    }
                                }
                            }
                        }
                        random = Math.random() * nameArr.length;


                    } while (nameArr[(int) random] == "");
                    if (count > 1) {
                        do {


                            draw = Math.random() * drawarr.length;
                        } while (drawarr[(int) draw] == "" || (int) draw == (int) random);
                    }
                    if (count > 1 && drawcount == 0) {


                        if (count > 0 && (int) random != (int) draw) {
                            if (nameArr[(int) random] != "") {
                                nameArr[(int) random] = "";
                                result += (nameArrbackup[(int) random] +"　"+ "\n");


                                drawarr[(int) draw] = "";
                                //       randomint = (int) (random + 1);
                                randomint = (int) (draw + 1);
                                renum += randomint +"　"+ "\n";
                            }
                            tvrenumber.setText(renum);
                            tvrename.setText(result);
                            count--;
                            drawcount++;
                        }
                    } else if (count > 0 && drawcount >= 1) {
                        do {


                            draw = Math.random() * drawarr.length;
                        } while (drawarr[(int) draw] == "" || (int) draw == (int) random);
                        if (count > 0 && (int) random != (int) draw) {
                            if (nameArr[(int) random] != "") {
                                nameArr[(int) random] = "";
                                result += (nameArrbackup[(int) random] +"　"+ "\n");


                                drawarr[(int) draw] = "";
                                //       randomint = (int) (random + 1);
                                randomint = (int) (draw + 1);
                                renum += randomint + "　"+"\n";
                            }
                            tvrenumber.setText(renum);
                            tvrename.setText(result);
                            count--;
                            if (count > 0) {

                            } else {
                                drawcount = 0;
                            }
                        }
                    } else {
                        if (remind == 0) {
                            Toast.makeText(this, "名單剩餘人數為0或是整體剩餘1個只能抽取到自己的目標可以抽取\n請添加其他人", Toast.LENGTH_LONG).show();
                            remind = 0;
                            break getrandom;
                        } else {

                        }
                    }

                }while (count >0);
            }
        }

        public void show_list(View view) {
            setContentView(R.layout.table_layout);
            tvnumber = findViewById(R.id.table_number);
            tvtable_name = findViewById(R.id.table_name);
            String show_number = "",show_name = "";
            for(int i=0;i<nameArr.length;i++){
                show_number += i+1+"　"+"\n";
                show_name += nameArrbackup[i]+"　"+"\n";
            }
            tvnumber.setText(show_number);
            tvtable_name.setText(show_name);

        }

    public void surprise(View view) {
        setContentView(R.layout.surprise);
        player.pause();
        videoView = findViewById(R.id.rick_video);
        //player2 = new MediaPlayer();
        /*
        try {
            player2.setDataSource(this, Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rickrolled));
            player2.prepare();
        } catch (IOException e){
            e.printStackTrace();
        }
         */
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rickrolled));
        //videoView.setVisibility(View.VISIBLE);
        videoView.start();
    }

    public void playMusic(View view) {
            //player.start();
            //player.setLooping(true);
            num++;
            if(num%2!=0){
                player.pause();
            }
            else if(num%2==0){
                player.start();
            }
    }


    @Override
    protected void onPause() {
        super.onPause();
        player.pause();
    }
}
