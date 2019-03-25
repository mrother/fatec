package br.edu.fatec.aula.trucoscoreapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    Stack pilha = new Stack();

    private final int TEAM_A = 1;
    private final int TEAM_B = 2;

    private AlertDialog alerta;

    private void reset(){
            TextView scoreA = findViewById(R.id.player1_score);
            TextView scoreB = findViewById(R.id.player2_score);
            scoreA.setText(String.valueOf("0"));
            scoreB.setText(String.valueOf("0"));
    }

    private void finale(int playerNumber){
        AlertDialog.Builder alertDialogo = new AlertDialog.Builder(this);
        alertDialogo.setTitle("Parabéns");
        alertDialogo.setMessage("Jogo finalizado! O jogador " + playerNumber + " venceu!");
        alertDialogo.setPositiveButton("Novo Jogo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset();
            }
        });
        alerta = alertDialogo.create();
        alerta.show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increasePointInPlayer(int playerNumber, int point){

        TextView playerScore = null;


        if (playerNumber == TEAM_A){
            playerScore = (TextView) findViewById(R.id.player1_score);
        } else {
            playerScore = (TextView) findViewById(R.id.player2_score);
        }

        int score = Integer.parseInt((String) playerScore.getText());
        if(score < 12 ){
            score += point;
            pilha.push(point);
            pilha.push(playerNumber);

            if(score >= 12){
                finale(playerNumber);
            }else{
                playerScore.setText(String.valueOf(score));
            }

        }else{
           finale(playerNumber);
        }

        Log.d("BUTTON", playerNumber + " | " + point);
    }


    public void increasePlayerOne(View view) {
        String numberAdd = (String) view.getTag();
        increasePointInPlayer(TEAM_A, Integer.parseInt(numberAdd));
    }

    public void increasePlayerTwo(View view) {
        String numberAdd = (String) view.getTag();
        increasePointInPlayer(TEAM_B, Integer.parseInt(numberAdd));
    }



    public void resetScore(View view) {
        reset();
    }


    public void undoScore(View view) {
        TextView playerScore = null;

        int playerNumber = (int)pilha.pop();
        int sub = (int) pilha.pop();

        if(playerNumber == 1){
            playerScore = (TextView) findViewById(R.id.player1_score);
        }else{
            playerScore = (TextView) findViewById(R.id.player2_score);
        }

        int score = Integer.parseInt((String) playerScore.getText());
        score -= sub;

        playerScore.setText(String.valueOf(score));
    }
}
