package g61305.othello.model;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Represents the easy mode against which you can play.
 */
class EasyMode implements Mode {

    private final LinkedList<Move> possibleMove;

    private final LinkedList<Integer> wallPosition;
    private final LinkedList<Integer> whitePieces;

    private final LinkedList<Integer> blackPieces;


    private final String nameMode;

    private final int size;

    public EasyMode(LinkedList<Move> possibleMove, LinkedList<Integer> wallPosition, int size, LinkedList<Integer> whitePieces, LinkedList<Integer> blackPieces) {
        Objects.requireNonNull(possibleMove, "The list of possible movements cannot be null.");
        Objects.requireNonNull(wallPosition, "The list of wall positions cannot be null.");
        Objects.requireNonNull(whitePieces, "The list of white pawn positions cannot be null.");
        Objects.requireNonNull(blackPieces, "The list of black pawn positions cannot be null.");
        this.wallPosition = wallPosition;
        this.possibleMove = possibleMove;
        this.nameMode = "human vs easy bot";
        this.size =size;
        this.blackPieces = blackPieces;
        this.whitePieces = whitePieces;
    }
    /**
     * Returns a randomly selected movement from the list of possible movements.
     * @return returns the selected movement.
     */
    @Override
    public Move getMove() {
        int randomValue = (int) (Math.random() * (possibleMove.size()));
        return possibleMove.get(randomValue);
    }

    /**
     * Provides the name of the game mode.
     * @return returns the name of the game mode.
     */
    @Override
    public String getNameMode() {
        return nameMode;
    }

    @Override
    public int getWall() {
        int newWall = 0;
        do{
            newWall =  (int) (Math.random() * (size*size));
        }while (wallPosition.contains(newWall) || whitePieces.contains(newWall) || blackPieces.contains(newWall));
        return newWall;
    }
}
