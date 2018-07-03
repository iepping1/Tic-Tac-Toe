package epping.ian.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Game game;
    int row;
    int column;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new Game();
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState); //always call super

        outState.putString("Button1", (String) button1.getText());


        //outState.putString("name", value);
    }

    public void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);

        button1.setText(inState.getString("Button1"));

    }


    public void tileClicked(View view) {
        int id = view.getId();
        if(id==R.id.button || id == R.id.button2 || id == R.id.button3){
            row = 0;
        }

        if(id==R.id.button4 || id == R.id.button5 || id == R.id.button6){
            row = 1;
        }

        if(id==R.id.button7 || id == R.id.button8 || id == R.id.button9){
            row = 2;
        }

        if(id==R.id.button || id == R.id.button4 || id == R.id.button7){
            column = 0;
        }

        if(id==R.id.button2 || id == R.id.button5 || id == R.id.button8){
            column = 1;
        }

        if(id==R.id.button3 || id == R.id.button6 || id == R.id.button9){
            column = 2;
        }

        Tile tile = game.draw(row, column);
        Button button= findViewById(id);

        switch(tile) {
            case CROSS:
                button.setText("X");
                break;
            case CIRCLE:
                button.setText("O");
                break;
            case INVALID:
                break;
        }
    }

    public void resetClicked(View view){
        game = new Game();

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        //int id = view.getId();
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");

    }
}
