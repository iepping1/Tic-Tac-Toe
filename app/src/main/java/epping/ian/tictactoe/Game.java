package epping.ian.tictactoe;

public class Game {
    //sets the size of the board
    final private int BOARD_SIZE = 3;
    private Tile[][] board;

    private Boolean playerOneTurn; // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

    public Game() {
        //fills the board with blank tiles
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        for (int i=0; i<BOARD_SIZE; i++)
            for (int j=0; j<BOARD_SIZE; j++)
                board[i][j] = Tile.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    public Tile draw(int row, int column) {

        for (int row=0; row<BOARD_SIZE; row++)
            for (int column = 0; column < BOARD_SIZE; column++)
                if board[row][column] = Tile.BLANK{

                    if playerOneTurn {
                        board[row][column] = Tile.CROSS;
                        playerOneTurn = false;
                        return Tile.CROSS;
                    }
                    else{
                        board[row][column] = Tile.CIRCLE;
                        playerOneTurn = true;
                        return Tile.CIRCLE;
                    }
                    movesPlayed++
                }
                else
                    return Tile.INVALID;
    }
}
