package epping.ian.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new Game();
        setContentView(R.layout.activity_main);
    }

    public void tileClicked(View view) {
        int id = view.getId();


    }

    public void resetClicked(View view){
        game = new Game();
    }
}
