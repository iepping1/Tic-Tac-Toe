package epping.ian.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // declare board variables
    Game game;
    int row;
    int column;

    // array for all button IDs
    public int[] buttons = new int[]{R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5,
            R.id.button6, R.id.button7, R.id.button8, R.id.button9};

    // array for button names
    public String[] button_names = {"Button1", "Button2", "Button3", "Button4", "Button5", "Button6",
            "Button7", "Button8", "Button9"};

    // total number of images
    public int length = button_names.length;

    // start game
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new Game();
        setContentView(R.layout.activity_main);

        //restores the main window after reload or orientation switch
        if(savedInstanceState != null) {
            for (int i = 0; i < length; i++) {
                Button button = findViewById(buttons[i]);
                if(button != null) {
                    button.setText(savedInstanceState.getString( button_names[i]));
                }
            }
        }
    }

    // assign button coordinates
    public void tileClicked(View view) {
        int id = view.getId();
        if(id==R.id.button1 || id == R.id.button2 || id == R.id.button3){
            row = 0;
        }

        if(id==R.id.button4 || id == R.id.button5 || id == R.id.button6){
            row = 1;
        }

        if(id==R.id.button7 || id == R.id.button8 || id == R.id.button9){
            row = 2;
        }

        if(id==R.id.button1 || id == R.id.button4 || id == R.id.button7){
            column = 0;
        }

        if(id==R.id.button2 || id == R.id.button5 || id == R.id.button8){
            column = 1;
        }

        if(id==R.id.button3 || id == R.id.button6 || id == R.id.button9){
            column = 2;
        }

        // possible game states
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

        // check for game end
        GameState gameState = game.ended();

        switch(gameState) {

            case PLAYER_ONE:
                TextView OneWon = findViewById(R.id.message);
                OneWon.setText("Player 1 Won!");
                break;
            case PLAYER_TWO:
                TextView TwoWon = findViewById(R.id.message);
                TwoWon.setText("Player 2 Won!");
                break;
            case DRAW:
                TextView draw = findViewById(R.id.message);
                draw.setText("It's a Tie!");
                break;
        }
    }

    // clear board when clicked
    public void resetClicked(View view){
        game = new Game();

        for (int i = 0; i < length; i++) {
            Button button = findViewById(buttons[i]);
            button.setText("");
        }

        TextView message = findViewById(R.id.message);
        message.setText("");
    }

    // save board settings after window reload/reorientation
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        for (int i = 0; i < length; i++) {
            Button button = findViewById(buttons[i]);
            outState.putString(button_names[i], (String) button.getText());
        }
    }
}
