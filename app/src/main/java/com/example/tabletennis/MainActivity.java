package com.example.tabletennis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tabletennis.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding bind;
    int count1, count2= 0;
    int scoreDifference = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        bind.txtScorePlayer1.setText("0");
        bind.txtScorePlayer2.setText("0");
        bind.txtWinnerStatus.setText("");
        bind.tvPlayerLoseStatusTitle.setText("");
        bind.tvPlayerLoseStatus.setText("");
        bind.playStatus.setText("");

        showScore();

    }

    private void showScore() {

        bind.btnPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bind.txtWinnerStatus.setText("");
                bind.tvPlayerLoseStatus.setText("");
                bind.tvPlayerLoseStatusTitle.setText("");
                bind.playStatus.setText("");

                count1 ++;
                scoreDifference = count1 - count2;
                bind.txtScorePlayer1.setText(String.valueOf(count1));

                if (count1 > count2 ) {
                    bind.playStatus.setText("Player 1 has a advantage");}
                else if (count1 ==9 && count2 ==9){
                    bind.playStatus.setText("Duse Ball");
                }else
                    bind.playStatus.setText("Draw");


                if (count1 >= 10 && scoreDifference >= 2){
                    bind.txtWinnerStatus.setText("Player 1");
                    bind.tvPlayerLoseStatus.setText("Player 2");
                    bind.tvPlayerLoseStatusTitle.setText(" lost.");
                    //reset
                    count1 = 0;
                    count2 = 0;
                    bind.txtScorePlayer1.setText("0");
                    bind.txtScorePlayer2.setText("0");
                }
            }

          
        });

        bind.btnPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bind.txtWinnerStatus.setText("");
                bind.tvPlayerLoseStatus.setText("");
                bind.tvPlayerLoseStatusTitle.setText("");
                bind.playStatus.setText("");

                count2 ++;
                bind.txtScorePlayer2.setText(String.valueOf(count2));

                if (count2 > count1 ){
                    bind.playStatus.setText("Player 2 has a advantage");
                }else
                    bind.playStatus.setText("Draw");

                if (count2 == 10){
                    bind.txtWinnerStatus.setText("Player 2");
                    bind.tvPlayerLoseStatus.setText("Player 1");
                    bind.tvPlayerLoseStatusTitle.setText(" lost.");
                    
                    //reset
                    count2 = 0;
                    count1 = 0;
                    bind.txtScorePlayer1.setText("0");
                    bind.txtScorePlayer2.setText("0");


                }

            }
        });
    }



}