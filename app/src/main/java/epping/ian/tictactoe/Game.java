package epping.ian.tictactoe;

import java.io.Serializable;

public class Game implements Serializable{

    // set up board
    final private int BOARD_SIZE = 3;
    private Tile[][] board;

    // set up two players
    private Boolean playerOneTurn;

    // set up gameover state
    private Boolean gameOver;

    // track number of moves
    private int moves = 0;

    public Game() {

        // fill board with blank tiles
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        for (int i=0; i<BOARD_SIZE; i++)
            for (int j=0; j<BOARD_SIZE; j++)
                board[i][j] = Tile.BLANK;

        // player one always starts game
        playerOneTurn = true;
        gameOver = false;
        moves = 0;
    }

    // draw cross or circle in tile
    public Tile draw(int row, int column) {

        if(board[row][column]==Tile.BLANK){

            // first players turns
            if(playerOneTurn){
                board[row][column] = Tile.CROSS;
                playerOneTurn = false;
                moves += 1;
                return Tile.CROSS;
            }

            // second players turns
            else{
                board[row][column] = Tile.CIRCLE;
                playerOneTurn = true;
                moves += 1;
                return Tile.CIRCLE;
            }
        }
        // illegal moves
        else
            return Tile.INVALID;
    }

    // check for endgame
    public GameState ended() {

        // check for stalemate
        if (moves == (BOARD_SIZE * BOARD_SIZE)) {
            return GameState.DRAW;
        }

        for (int i = 0; i < BOARD_SIZE; i++) {

            // check for horizontal victory
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                if (board[i][0] == Tile.CROSS) {
                    return GameState.PLAYER_ONE;
                }
                if (board[i][0] == Tile.CIRCLE) {
                    return GameState.PLAYER_TWO;
                }
            }
            // check for vertical victory
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                if (board[0][i] == Tile.CROSS) {
                    return GameState.PLAYER_ONE;
                }
                if (board[0][i] == Tile.CIRCLE) {
                    return GameState.PLAYER_TWO;
                }
            }
        }

        // check for diagonal victory
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == Tile.CROSS) {
                return GameState.PLAYER_ONE;
            }
            if (board[0][0] == Tile.CIRCLE) {
                return GameState.PLAYER_TWO;
            }
        }

        else if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == Tile.CROSS) {
                return GameState.PLAYER_ONE;
            }
            if (board[0][2] == Tile.CIRCLE) {
                return GameState.PLAYER_TWO;
            }
        }

        // game stil ongoing
        return GameState.IN_PROGRESS;
    }
}