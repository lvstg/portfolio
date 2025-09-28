package g61305.othello.console;


import g61305.othello.model.Colors;
import g61305.othello.model.Game;
import java.util.Scanner;

import static g61305.othello.model.Colors.BLACK;
import static g61305.othello.model.Colors.WHITE;

/**
 * This class handles the game's console display.
 */

public class View {

    /**
     * Displays all the boxes according to their position in the table and
     * gives them a colour according to their specificity.
     * Black : pieces belonging to player 1 (the player with the black pieces).
     * Yellow : pieces belonging to player 2 (the player with the white pieces).
     * Red : are the possible moves for the current player.
     * Green : are the other pieces in the picture.
     *
     * @param game : gives access to the status of the game.
     */
    public void displayBoard(Game game) {
        int nbrTiles = game.getSize() * game.getSize();
        for (int posOnBoard = 1; posOnBoard <= nbrTiles; posOnBoard++) {
            if (game.getPositionWhitePieces().contains(posOnBoard)) {
                System.out.print("\033[93m  W\033[0m"); // Yellow
            } else if (game.getPositionBlackPieces().contains(posOnBoard)) {
                System.out.print("  B"); //Black
            } else if (game.searchPieceInPossibleMove(posOnBoard) != null) {
                System.out.printf("\033[91m%3d\033[0m", posOnBoard); // Red
            } else {
                System.out.printf("\033[92m%3d\033[0m", posOnBoard); // Green
            }
            if (posOnBoard % game.getSize() == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }


    /**
     * Displays the winning player.
     * @param winner : name of the winning player.
     */
    public void displayWinner(Colors winner){
        String name = winner==BLACK?"Player 1" :winner == WHITE ? "Player 2" : "Both";
        System.out.println("Winner is "+name);
    }

    /**
     * Displays the scores of both players.
     * @param game : gives access to the status of the game.
     */
    public void displayScores(Game game) {
        System.out.println("Score Player 1 : "+game.getPositionBlackPieces().size());
        System.out.println("Score \033[93mPlayer 2 \033[0m: "+game.getPositionWhitePieces().size());
        System.out.println();
    }

    /**
     * Affiche le joueur courant, le joueur dont c'est le tour de jouer.
     * @param game : gives access to the status of the game.
     */
    public void displayCurrentPlayer(Game game) {
        System.out.print("Current player is ");
        switch (game.getCurrentPlayer()) {
            case BLACK -> System.out.println("Player 1 : ");
            case WHITE -> System.out.println("\033[93mPlayer 2 : \033[0m");
        }
        System.out.println();
    }

    /**
     * Tests if the user gives an int as input.
     *
     * @param message for the user
     * @return the user's input
     */
    public int testEntier(String message) {
        Scanner clavier = new Scanner(System.in);
        System.out.print(message);
        while (!clavier.hasNextInt()) {
            clavier.next();
            displayError("The number entered is not an integer.");
            System.out.print(message);
        }
        return clavier.nextInt();
    }

    /**
     * This method checks that a value is between the min and the max
     *
     * @param message for the user
     * @param min     is the minimum value that must be respected
     * @param max     is the max value that must be respected
     * @return the user's input
     */
    public int testBorne(String message, int min, int max) {
        int valeur = testEntier(message);
        while (valeur < min || valeur > max) {
            displayError("The value is not between " + min + " and " + max);
            valeur = testEntier(message);
        }
        return valeur;
    }

    /**
     * Displays a boxed error message.
     *
     * @param message is the message to display.
     */
    public void displayError(String message) {
        System.out.println();
        System.out.println("\u274C \033[91m" + message + "\033[0m \u274C");
        System.out.println();
    }



}
