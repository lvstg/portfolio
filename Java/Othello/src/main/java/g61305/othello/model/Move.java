package g61305.othello.model;

import java.util.LinkedList;

/**
 * Represents a movement, a move to be made by a user or the algorithm.
 * @param pieceToPlace is the part that will be installed.
 * @param piecesToReturn is the list of parts that must be returned because of the new part.
 */

public record Move(int pieceToPlace, LinkedList<Integer> piecesToReturn) {

    public void addPiecesToReturns(LinkedList<Integer> piecesToAdd) {
        piecesToReturn.addAll(piecesToAdd);
    }
}
