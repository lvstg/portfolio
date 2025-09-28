package g61305.othello.model;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Represents the state of the game at a given moment.
 */
public class State {
    private final LinkedList<Integer> blackPieces;
    private final LinkedList<Integer> whitePieces;

    private final LinkedList<Integer> wallPosition;
    private final Colors currentPlayer;
    private final boolean gameOn;
    private final Mode mode;
    private final LinkedList<Move> possibleMove;
    private final Move lastMove;

    public State( LinkedList<Integer> blackPieces,
                  LinkedList<Integer> whitePieces,
                  LinkedList<Integer> wallPosition,
                  Colors currentPlayer,
                 boolean gameOn,
                  LinkedList<Move> possibleMove,
                 Mode mode,
                 Move lastMove){

        Objects.requireNonNull(blackPieces, "The list of black parts cannot be null.");
        Objects.requireNonNull(whitePieces, "The list of white parts cannot be null.");
        Objects.requireNonNull(wallPosition, "The list of wall positions cannot be null.");
        Objects.requireNonNull(currentPlayer, "The player cannot be null.");
        Objects.requireNonNull(possibleMove, "The list of possible movements cannot be null.");

        this.blackPieces = blackPieces;
        this.whitePieces = whitePieces;
        this.wallPosition = wallPosition;
        this.currentPlayer = currentPlayer;
        this.gameOn = gameOn;
        this.possibleMove = possibleMove;
        this.mode = mode;
        this.lastMove = lastMove;
    }
    public int getLastPiece() {
        return lastMove==null?0:lastMove.pieceToPlace();
    }
    public LinkedList<Integer> getBlackPieces() {
        return blackPieces;
    }
    public LinkedList<Integer> getWhitePieces() {
        return whitePieces;
    }
    public Colors getCurrentPlayer() {
        return currentPlayer;
    }
    public boolean getStatusGameOn() {
        return gameOn;
    }
    public LinkedList<Move> getPossibleMove() {
        return possibleMove;
    }
    public String getNameMode() {
        if (mode == null){
            return "human vs human";
        }
        return mode.getNameMode();
    }

    public int getPrise(){
        if (lastMove!=null){
            return lastMove.piecesToReturn().size()+1;
        }
        return 0;
    }

    public LinkedList<Integer> getWallPosition(){
        return wallPosition;
    }
}
