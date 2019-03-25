package com.fatec.mauricio.tictactoe.activies;

import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.fatec.mauricio.tictactoe.R;

public class MainActivity extends AppCompatActivity {

    private static final String PLAYER_1 = "Bolinha";
    private static final String PLAYER_2 = "Xis";
    private String turn = PLAYER_1;
    private Button[][] arrayBut;

    private void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arrayBut[j][i].setBackgroundResource(0);
                arrayBut[j][i].setTag("1");
            }
        }
        turn = PLAYER_1;
    }

    private void showItemDialog(String winner) {

        try {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
            View view = getLayoutInflater().inflate(R.layout.dialog_winner, null);
            TextView win = (TextView) view.findViewById(R.id.textWinner);
            win.setText(winner);
            Button again = view.findViewById(R.id.butAgain);
            mBuilder.setView(view);

            final AlertDialog dialog = mBuilder.create();
            dialog.show();


            again.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reset();
                    dialog.dismiss();
                }
            });


        } catch (Exception e) {
            System.out.println(" ta dando pau " + e);
        }

    }

    private boolean verificaCelula(Button b1, Button b2, Button b3, Object string) {
        System.out.println("Linha:" + b1.getTag() + ";" + b2.getTag() + ";" + b3.getTag());
        return b1.getTag().equals(string) && b2.getTag().equals(b1.getTag()) && b3.getTag().equals(b2.getTag());
    }

    private void win(Button b1, Button b2, Button b3, View view) {
        Handler h = new Handler();
        final String winner = (String) view.getTag();
        try {
            if (view.getTag().equals("Bolinha")) {
                view.setBackgroundResource(R.drawable.circle_black);

                b1.setBackgroundResource(R.drawable.circle_red);
                b2.setBackgroundResource(R.drawable.circle_red);
                b3.setBackgroundResource(R.drawable.circle_red);
            } else {
                view.setBackgroundResource(R.drawable.cross_black);

                b1.setBackgroundResource(R.drawable.cross_red);
                b2.setBackgroundResource(R.drawable.cross_red);
                b3.setBackgroundResource(R.drawable.cross_red);
            }

            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    showItemDialog(winner);
                }
            }, 2000)
            ;
        } catch (Exception e) {

        }

    }

    private void verificar(View view) {
        try {
            if (verificaCelula(arrayBut[0][0], arrayBut[0][1], arrayBut[0][2], view.getTag())) {
                win(arrayBut[0][0], arrayBut[0][1], arrayBut[0][2], view);
            }
            if (verificaCelula(arrayBut[1][0], arrayBut[1][1], arrayBut[1][2], view.getTag())) {
                win(arrayBut[1][0], arrayBut[1][1], arrayBut[1][2], view);

            }
            if (verificaCelula(arrayBut[2][0], arrayBut[2][1], arrayBut[2][2], view.getTag())) {
                win(arrayBut[2][0], arrayBut[2][1], arrayBut[2][2], view);
            }

            if (verificaCelula(arrayBut[0][0], arrayBut[1][0], arrayBut[2][0], view.getTag())) {
                win(arrayBut[0][0], arrayBut[1][0], arrayBut[2][0], view);
            }
            if (verificaCelula(arrayBut[0][1], arrayBut[1][1], arrayBut[2][1], view.getTag())) {
                win(arrayBut[0][1], arrayBut[1][1], arrayBut[2][1], view);
            }
            if (verificaCelula(arrayBut[0][2], arrayBut[1][2], arrayBut[2][2], view.getTag())) {
                win(arrayBut[0][2], arrayBut[1][2], arrayBut[2][2], view);
            }
            if (verificaCelula(arrayBut[0][0], arrayBut[1][1], arrayBut[2][2], view.getTag())) {
                win(arrayBut[0][0], arrayBut[1][1], arrayBut[2][2], view);

            }
            if (verificaCelula(arrayBut[0][2], arrayBut[1][1], arrayBut[2][0], view.getTag())) {
                win(arrayBut[0][2], arrayBut[1][1], arrayBut[2][0], view);
            }

        } catch (Exception e) {
            System.out.println("Erro 2 " + e);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayBut = new Button[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String name = "but" + i + j;
                int resId = getResources().getIdentifier(name, "id", getPackageName());
                arrayBut[j][i] = findViewById(resId);
            }
        }

    }

    public void resetGame(View view) {
        reset();
    }

    public void Jogada(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        String test = (String) view.getTag();
        try {
            if (test.equals("1")) {
                if (turn.equals("Bolinha")) {
                    view.setTag("Bolinha");
                    view.setBackgroundResource(R.drawable.circle_black);
                    turn = PLAYER_2;
                } else {
                    view.setTag("Xis");
                    view.setBackgroundResource(R.drawable.cross_black);
                    turn = PLAYER_1;
                }
                verificar(view);
            }
        } catch (Exception e) {
            System.out.println(e + "!");
        }
    }
}
