package g61305.othello.model;

import java.util.LinkedList;
import java.util.Objects;

class HardMode implements Mode {

    private final LinkedList<Move> possibleMove;

    public final  String nameMode;

    HardMode(LinkedList<Move> possibleMove) {
        Objects.requireNonNull(possibleMove, "The list of movements cannot be null.");
        this.possibleMove = possibleMove;
        this.nameMode = "human vs hard bot";
    }


    /**
     * Find the move that eats the most of your opponent's pieces.
     * @return Flip the move that eats the most coins.
     */
    @Override
    public Move getMove() {
        Move bestMove = possibleMove.get(0);
        for (Move move:possibleMove) {
            bestMove = move.piecesToReturn().size() > bestMove.piecesToReturn().size() ?
                    move : bestMove;
        }
        return bestMove;
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
        return 0;
    }


}
