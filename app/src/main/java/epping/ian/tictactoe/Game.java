package epping.ian.tictactoe;

public class Game {

    // sets the size of the board
    final private int BOARD_SIZE = 3;
    private Tile[][] board;

    // setting up the two players
    private Boolean playerOneTurn;
    private Boolean gameOver;

    public Game() {

        // fills the board with blank tiles
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        for (int i=0; i<BOARD_SIZE; i++)
            for (int j=0; j<BOARD_SIZE; j++)
                board[i][j] = Tile.BLANK;

        // player one always starts the game
        playerOneTurn = true;
        gameOver = false;
    }

    // draws the crosses and circles
    public Tile draw(int row, int column) {

        if(board[row][column]==Tile.BLANK){

            // first players turns
            if(playerOneTurn){
                board[row][column] = Tile.CROSS;
                playerOneTurn = false;
                return Tile.CROSS;
            }

            // second players turns
            else{
                board[row][column] = Tile.CIRCLE;
                playerOneTurn = true;
                return Tile.CIRCLE;
            }
        }
        // illegal moves
        else
            return Tile.INVALID;
    }
}
