package g61305.othello.model;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

import static g61305.othello.model.Colors.BLACK;
import static g61305.othello.model.Colors.WHITE;
import static g61305.othello.model.Direction.*;

/**
 * This class represents the model's game board.
 */

class Board {

    private final LinkedList<Integer> whitePieces;

    private final LinkedList<Integer> blackPieces;

    private final LinkedList<Move> possibleMove;

    private final LinkedList<Integer> wallPosition;

    private final int size;

    private Colors currentPlayer;

    private boolean gameOn;

    private int passTurn;

    private boolean giveUp;

    private Mode mode;


    Board(int size, String mode) {
        this.whitePieces = new LinkedList<>();
        this.blackPieces = new LinkedList<>();
        this.possibleMove = new LinkedList<>();
        this.wallPosition = new LinkedList<>();
        this.size = size;
        this.passTurn = 0;

        this.mode = mode.equals("human vs human") ?
                null : mode.equals("human vs easy bot") ?
                new EasyMode(getPossibleMove(),
                        getWallPosition(),
                        size,
                        whitePieces,
                        getPositionBlackPieces()
                ) : new HardMode(getPossibleMove());

        for (Direction direction : Direction.values()) {
            direction.setX(size); // Updates the X
            direction.setValue(); // Updates the direction value
        }

        this.currentPlayer = BLACK;
        this.gameOn = true;
        this.giveUp = false;

    }


    /**
     * Place the first squares on the board.
     */
    void addFirstPieces() {
        int nbrCaseToJump = size % 2 == 0 ? (size / 2) - 1 : (size / 2);
        int firstWhitePiece = 1;

        for (int i = 0; i < nbrCaseToJump; i++) {
            firstWhitePiece += DOWN_RIGHT.getValue();
        }

        int secondWhitePiece = firstWhitePiece + DOWN_RIGHT.getValue();
        int firstBlackPiece = firstWhitePiece + RIGHT.getValue();
        int secondBlackPiece = firstBlackPiece + DOWN_LEFT.getValue();

        whitePieces.add(firstWhitePiece);
        whitePieces.add(secondWhitePiece);

        blackPieces.add(firstBlackPiece);
        blackPieces.add(secondBlackPiece);

        setPossibleMove();
    }

    void addWall(int newWall)throws IllegalArgumentException{
        if (blackPieces.contains(newWall)||whitePieces.contains(newWall)){
            throw new IllegalArgumentException("The wall can only be placed on empty squares.");
        }
        wallPosition.add(newWall);
        upDateEndTurn();
    }

    /**
     * Adds a part to the board and returns the parts that need to be added.
     *
     * @param move is the movement, the piece to be placed on the board, supplied by the user or the game algorithm.
     * @throws NullPointerException This exception may occur if the user selects
     *                              a box that is not in the possible movements.
     */

    void addPiece(@NotNull Move move){
        List<Integer> currentPlayerPieces = (currentPlayer == BLACK) ? blackPieces : whitePieces;
        List<Integer> notCurrentPlayerPieces = (currentPlayer == BLACK) ? whitePieces : blackPieces;


        currentPlayerPieces.add(move.pieceToPlace());

        for (int pieceToReturn : move.piecesToReturn()) {
            currentPlayerPieces.add(pieceToReturn);
            notCurrentPlayerPieces.remove(Integer.valueOf(pieceToReturn));
        }
        upDateEndTurn();
    }

    /**
     * Remove a coin from the board and return the coins it had eaten when it was placed.
     *
     * @param move is the movement containing the part to be removed and the parts to be returned.
     * @throws NullPointerException This exception can occur if there are no more movements to be withdrawn.
     */
    void removeLastMove(@NotNull Move move) {
        LinkedList<Integer> currentPlayerPieces = (currentPlayer == BLACK) ? blackPieces : whitePieces;
        LinkedList<Integer> notCurrentPlayerPieces = (currentPlayer == BLACK) ? whitePieces : blackPieces;

        for (int pieceToReturn : move.piecesToReturn()) {
            notCurrentPlayerPieces.remove(Integer.valueOf(pieceToReturn));
            currentPlayerPieces.add(pieceToReturn);
        }

        notCurrentPlayerPieces.remove(Integer.valueOf(move.pieceToPlace()));

        upDateEndTurn();
    }

    /**
     * Find the player with the most coins.
     *
     * @return the colour of the player with the most coins, or null if there is a tie.
     */
    Colors findWinner() {
        int score1 = getNumberBlackPieces();
        int score2 = getNumberWhitePieces();
        return score1 > score2 ? BLACK : score1 < score2 ? WHITE : null;
    }

    /**
     * Replaces the old mode with the new one.
     *
     * @param newMode is the new mode that will replace the old one.
     */
    void setMode(String newMode) {
        switch (newMode) {
            case "human vs easy bot" -> mode = new EasyMode(getPossibleMove(),getWallPosition(), size, whitePieces, getPositionBlackPieces());
            case "human vs hard bot" -> mode = new HardMode(getPossibleMove());
            default -> mode = null;
        }
    }

    /**
     * Set giveUp value if one of the players to subscribe.
     */
    void setGiveUp() {
        giveUp = !giveUp;
    }

    LinkedList<Move> getPossibleMove() {
        return possibleMove;
    }

    Mode getMode() {
        return mode;
    }

    Move getComputerMove() throws NullPointerException {
        return mode.getMove();
    }

    int getSize() {
        return size;
    }

    /**
     * Check the game status with four end's conditions.
     * @return True if the game stays on and false if it's turn off.
     */
    boolean getGameStatus() {
        if (getNumberBlackPieces() == 0 || getNumberWhitePieces() == 0) { // If one of the two players has no coins left.
            setGameOn();
        } else if (getNumberWhitePieces() + getNumberBlackPieces() == size * size) { //If the board is full.
            setGameOn();
        } else if (passTurn > 2) { // If neither player can play.
            setGameOn();
        } else if (giveUp) { // If a player gives up.
            setGameOn();
        }
        passTurn = 0;
        return gameOn;
    }

    LinkedList<Integer> getPositionWhitePieces() {
        return whitePieces;
    }

    LinkedList<Integer> getPositionBlackPieces() {
        return blackPieces;
    }

    Colors getCurrentPlayer() {
        return currentPlayer;
    }


    boolean getGiveUp() {
        return giveUp;
    }

    private int getNumberWhitePieces() {
        return whitePieces.size();
    }

    private int getNumberBlackPieces() {
        return blackPieces.size();
    }


    /**
     * Used to change the current player and find the possible moves for the new current player.
     */
    private void upDateEndTurn() {
        do {
            setCurrentPlayer();
            setPossibleMove();
            passTurn++;
        } while (possibleMove.isEmpty() && passTurn <= 2);
    }

    /**
     * Find the possible moves for the current player.
     */

    private void setPossibleMove() {
        possibleMove.clear();

        LinkedList<Integer> piecesToReturn = new LinkedList<>();

        List<Integer> currentPlayerPieces = (currentPlayer == BLACK) ? blackPieces : whitePieces;
        List<Integer> notCurrentPlayerPieces = (currentPlayer == BLACK) ? whitePieces : blackPieces;


        for (int currentPiece : currentPlayerPieces) { // For each of the current player's pieces.
            int nextPiece;
            for (Direction direction : Direction.values()) { // For each direction.
                nextPiece = checkBounds(currentPiece, direction);

                while (notCurrentPlayerPieces.contains(nextPiece)) {//As long as the next piece is the opposite colour.
                    piecesToReturn.add(nextPiece);
                    nextPiece = checkBounds(nextPiece, direction);
                }

                if (piecesToReturn.size() > 0 && !currentPlayerPieces.contains(nextPiece)&& nextPiece != -1&&!wallPosition.contains(nextPiece)){

                    Move move = findMoveInPossibleMove(nextPiece);

                    //If the movement already exists, we add the pieces it returns to it.
                    if (move != null) {
                        move.addPiecesToReturns(piecesToReturn);
                    } else { // Otherwise we create a new one and add it to the list of possible movements.
                        Move newMove = new Move(nextPiece, new LinkedList<>(piecesToReturn));
                        possibleMove.add(newMove);
                    }
                }
                piecesToReturn.clear();
            }
        }
    }

    /**
     * Check whether a movement is in the list of possible movements.
     *
     * @param position the position of the movement we are looking for.
     * @return the movement if it exists, otherwise returns the sentinel value null.
     */
    Move findMoveInPossibleMove(int position) {
        for (Move move : possibleMove) {
            if (move.pieceToPlace() == position) {
                return move;
            }
        }
        return null;
    }

    /**
     * Check that the following piece is still within the limits of the board.
     *
     * @param currentPiece is the piece we want to check if the next one is still in the board.
     * @param direction    is the direction in which we are going to check.
     * @return the position of the next piece if it is in the board, otherwise returns the sentinel value of -1,
     * which indicates that it is no longer in the board.
     */
    private int checkBounds(int currentPiece, Direction direction) {
        int nextPiece = currentPiece + direction.getValue();
        if (direction == UP || direction == UP_RIGHT || direction == UP_LEFT) {
            if (nextPiece <= 0) {
                return -1;
            }
        }
        if (direction == DOWN || direction == DOWN_LEFT || direction == DOWN_RIGHT) {
            if (nextPiece >= (size * size) + 1) {
                return -1;
            }
        }
        if (direction == RIGHT || direction == DOWN_RIGHT || direction == UP_RIGHT) {
            if (nextPiece % size == 1) {
                return -1;
            }
        }
        if (direction == LEFT || direction == UP_LEFT || direction == DOWN_LEFT) {
            if (nextPiece % size == 0) {
                return -1;
            }
        }
        return nextPiece;
    }

    private void setCurrentPlayer() {
        currentPlayer = (currentPlayer == BLACK) ? WHITE : BLACK;
    }

    private void setGameOn() {
        gameOn = !gameOn;
    }

    public LinkedList<Integer> getWallPosition() {
        return wallPosition;
    }
}