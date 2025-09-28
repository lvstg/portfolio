package g61305.othello.model;

import g61305.othello.view.sceneGame.GamePane;

import java.beans.PropertyChangeSupport;
import java.util.LinkedList;

import static g61305.othello.model.Colors.WHITE;


/**
 * This class is the model's facade class.
 * It is normally the only possible access to the model for the view and the controller.
 */
public class Game {

    private final PropertyChangeSupport observables;

    private final Board board;


    public Game(int size, String mode) throws IllegalArgumentException {
        if (size < 3 || size > 15) {
            throw new IllegalArgumentException("The board size must be between 3 and 15.");
        }
        board = new Board(size, mode);
        observables = new PropertyChangeSupport(this);
    }

    public Move getComputerMove() throws NullPointerException{
        return board.getComputerMove();
    }


    public LinkedList<Integer> getPositionWhitePieces() {
        return board.getPositionWhitePieces();
    }


    /**
     * Checks whether the part passed in parameter is in the list of possible movements.
     * @param piece The piece we're looking for in the possible movements
     * @return the movement if it exists
     *          or null if it does not exist.
     */
    public Move searchPieceInPossibleMove(int piece) {
        return board.findMoveInPossibleMove(piece);
    }

    public LinkedList<Move> getPossibleMove() {
        return board.getPossibleMove();
    }

    public LinkedList<Integer> getPositionBlackPieces() {
        return board.getPositionBlackPieces();
    }

    public int getSize() {
        return board.getSize();
    }

    public boolean getGameStatus() {
        return board.getGameStatus();
    }

    public Colors getCurrentPlayer() {
        return board.getCurrentPlayer();
    }


    public boolean getGiveUp(){
        return board.getGiveUp();
    }

    /**
     * Add a piece and return the pieces that need to be added.
     * @param position is the position where the new part was to be added.
     */
    public void add(int position) {
        Move move = searchPieceInPossibleMove(position);
        board.addPiece(move);
    }

    /**
     * Indicates to which view notifications are sent.
     * @param view is the view that will receive notifications.
     */
    public void addObserver(GamePane view) {
        observables.addPropertyChangeListener(view);
    }

    public Mode getMode() {
        return board.getMode();
    }

    public LinkedList<Integer> getWallPosition(){
        return board.getWallPosition();
    }

    public void addWall(int newWall)throws IllegalArgumentException{
        board.addWall(newWall);
        State state = new State(
                getPositionBlackPieces(),
                getPositionWhitePieces(),
                getWallPosition(),
                getCurrentPlayer(),
                getGameStatus(),
                getPossibleMove(),
                getMode(),
                null
        );
        observables.firePropertyChange("newWall", null, state);

    }
    /**
     * Add a piece and return the pieces that need to be added.
     * @param move is the element that contains both the part to be installed and the parts to be returned.
     * @throws NullPointerException
     *          This exception occurs if the user indicates a square that is not a possible movement.
     */
    public void addPiece(Move move) throws NullPointerException {
        board.addPiece(move);
        State state = new State(
                getPositionBlackPieces(),
                getPositionWhitePieces(),
                getWallPosition(),
                getCurrentPlayer(),
                getGameStatus(),
                getPossibleMove(),
                getMode(),
                move);
        observables.firePropertyChange("addNewPiece", null, state);
    }



    /**
     * Add the first pieces to the board.
     */
    public void addFirstPiece()  {
        board.addFirstPieces();
        State state = new State(
                getPositionBlackPieces(),
                getPositionWhitePieces(),
                getWallPosition(),
                getCurrentPlayer(),
                getGameStatus(),
                getPossibleMove(),
                getMode(),
                null);
        observables.firePropertyChange("addFirstPiece", null, state);
    }

    /**
     * Updates if one of the players wants to abandon a game.
     */
    public void setGiveUp() {
        board.setGiveUp();
        State state = new State(
                getPositionBlackPieces(),
                getPositionWhitePieces(),
                getWallPosition(),
                getCurrentPlayer(),
                getGameStatus(),
                getPossibleMove(),
                getMode(),
                null);
        observables.firePropertyChange("giveUp", null, state);
    }

    /**
     * Updates the game mode during a game.
     * @param newMode is the new mode for the current game.
     */
    public void setMode(String newMode) {
        board.setMode(newMode);
        State state = new State(
                getPositionBlackPieces(),
                getPositionWhitePieces(),
                getWallPosition(),
                getCurrentPlayer(),
                getGameStatus(),
                getPossibleMove(),
                getMode(),
                null);
        observables.firePropertyChange("setMode", null, state);
    }

    /**
     * Used to remove the last move played.
     * @param move is the movement to be withdrawn.
     * @throws NullPointerException occurs when the movement is invalid.
     */
    public void removeLastMove(Move move) throws NullPointerException {
        board.removeLastMove(move);
        State state = new State(
                getPositionBlackPieces(),
                getPositionWhitePieces(),
                getWallPosition(),
                getCurrentPlayer(),
                getGameStatus(),
                getPossibleMove(),
                getMode(),
                null);
        observables.firePropertyChange("undo", null, state);

    }

    /**
     * Find the winner between the two players.
     * @return the name of the winner or a sentinel value if there is a tie.
     */

    public Colors findWinner() {
        return board.findWinner();
    }

    /**
     * Checks whether the opponent is human or algorithmic.
     * @return True if the second player is an algorithm
     *          and false if the second player is a human.
     */
    public boolean isNotHuman() {
        return board.getMode() != null;
    }

    /**
     * Check if it's the algorithm's turn.
     * @return true if it's the algorithm's turn and false if it's not.
     */
    public boolean computerIsCurrentPlayer(){
        return getCurrentPlayer() == WHITE;
    }


}
