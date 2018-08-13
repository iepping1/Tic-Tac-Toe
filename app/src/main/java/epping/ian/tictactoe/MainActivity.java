package epping.ian.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // declares the variables
    Game game;
    int row;
    int column;

    // creates an array for all the button IDs
    public int[] buttons = new int[]{R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5,
            R.id.button6, R.id.button7, R.id.button8, R.id.button9};

    // creates an array for the button names
    public String[] names = {"Button1", "Button2", "Button3", "Button4", "Button5", "Button6",
            "Button7", "Button8", "Button9"};

    // variable for the total number of images
    public int length = names.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new Game();
        setContentView(R.layout.activity_main);

        // restores the main window after reload
        if(savedInstanceState != null) {
            for (int i = 0; i < length; i++) {
                Button button = findViewById(buttons[i]);
                button.setText(savedInstanceState.getString("Button"));
            }
        }
    }

    // saves the board settings after a window reload
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState); //always call super

        for (int i = 0; i < length; i++) {
            Button button = findViewById(buttons[i]);
            outState.putString("Button", (String) button.getText());
        }
    }

    // assigns the buttons their coordinates
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

        // sets up the possible game states
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

    // clears the board when clicked
    public void resetClicked(View view){
        game = new Game();

        for (int i = 0; i < length; i++) {
            Button button = findViewById(buttons[i]);
            button.setText("");
        }
    }
}
