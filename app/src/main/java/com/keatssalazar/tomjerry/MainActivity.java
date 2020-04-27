package com.keatssalazar.tomjerry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView txt;
    GridLayout grdlayout;
    int[][] winningposition = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    int []playerNuber = {5, 5, 5, 5, 5, 5, 5, 5, 5};
    int currentPLayer = 1;
    int t;
    boolean gameOver = false;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        txt=findViewById(R.id.res);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
        grdlayout=findViewById(R.id.gridLayout);
    }

    public void imagetapped(View image) {

        ImageView src = (ImageView) image;
        t = Integer.parseInt(src.getTag().toString());
        if (!gameOver && playerNuber[t] == 5) {
            counter++;
            playerNuber[t] = currentPLayer;

            if (currentPLayer == 1) {
                src.setTranslationX(-2000f);
                src.setImageResource(R.drawable.tom);
                src.animate().rotation(3600).translationXBy(2000f).alpha(1).setDuration(900);
                currentPLayer = 2;
            } else if (currentPLayer == 2) {
                src.setTranslationX(2000f);
                src.setImageResource(R.drawable.jerrry);
                src.animate().translationXBy(-2000f).alpha(1).rotation(3600).setDuration(900);
                currentPLayer = 1;
            }
            for (int[] q : winningposition) {
                //SOMEONE WON IF 'IF STATEMENT' SUCCESSFULLY EXECUTE!!
                if (playerNuber[q[0]] == playerNuber[q[1]] && playerNuber[q[1]] == playerNuber[q[2]] && playerNuber[q[0]] != 5) {

                    gameOver = true;
                    btn.setVisibility(View.VISIBLE);
                    if(currentPLayer==1){
                        txt.setVisibility(View.VISIBLE);
                        txt.setText(R.string.jw);
                    }
                    else{
                        txt.setVisibility(View.VISIBLE);
                        txt.setText(R.string.tw);
                    //    Toast.makeText(getApplicationContext(),"TOM W0N", Toast.LENGTH_SHORT).show();

                    }
                }
            }
            if (counter == 9 && !gameOver) {
                txt.setVisibility(View.VISIBLE);
                txt.setText("MATCH DRAW");
               // Toast.makeText(getApplicationContext(), "MATCH DRAW", Toast.LENGTH_SHORT).show();
                btn.setVisibility(View.VISIBLE);
            }

        }

    }
    public void reset() {
        currentPLayer=1;
        for(int i=0;i<9;i++)
            playerNuber[i]=5;

        gameOver = false;
        counter=0;

        for(int j=0;j<grdlayout.getChildCount();j++) {
            ImageView imageView = (ImageView) grdlayout.getChildAt(j);
            imageView.setImageDrawable(null);
            imageView.setAlpha(0.4f);
        }
        btn.setVisibility(View.INVISIBLE);
        txt.setVisibility(View.INVISIBLE);

    }
}

