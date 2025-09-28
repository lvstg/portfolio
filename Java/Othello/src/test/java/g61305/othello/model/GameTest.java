package g61305.othello.model;

import org.junit.jupiter.api.Test;

import static g61305.othello.model.Colors.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void Game(){
        // Générer en tableau pair
        assertThrows(IllegalArgumentException.class, ()->new Game(2, "human vs human"));
        assertThrows(IllegalArgumentException.class, ()->new Game(16, "human vs human"));
    }
    @Test
    void getCurrentPlayer() {
        Game game = new Game(4, "human vs human");
        game.addFirstPiece();
        assertEquals(BLACK, game.getCurrentPlayer());
        game.add(2);
        assertEquals(WHITE, game.getCurrentPlayer());
    }

    @Test
    void add() {
        Game game = new Game(4, "human vs human");
        game.addFirstPiece();
        game.add(2);
        assertEquals(6, game.getPositionBlackPieces().getLast());
        assertThrows(IllegalArgumentException.class, ()->game.add(12));
    }
    @Test
    void addFirstPiece() {
        Game game = new Game(4, "human vs human");
        game.addFirstPiece();

        assertEquals(6, game.getPositionWhitePieces().getFirst());
        assertEquals(11, game.getPositionWhitePieces().getLast());
        assertEquals(7, game.getPositionBlackPieces().getFirst());
        assertEquals(10, game.getPositionBlackPieces().getLast());
    }
    @Test
    void addPiece() {
        Game game = new Game(4, "human vs human");
        game.addFirstPiece();

        game.addPiece(game.searchPieceInPossibleMove(2));
        assertEquals(6, game.getPositionBlackPieces().getLast());
    }

    @Test
    void computerAddPiece() {
        Game game = new Game(4, "human vs hard computer");
        game.addFirstPiece();

        game.addPiece(game.searchPieceInPossibleMove(2));

        game.addPiece(game.getComputerMove());
        assertEquals(7,game.getPositionWhitePieces().getLast());
    }



    @Test
    void setGiveUp() {
        Game game = new Game(4, "human vs hard computer");
        game.addFirstPiece();

        game.setGiveUp();
        assertTrue(game.getGiveUp());
    }

    @Test
    void setMode() {
        Game game = new Game(4, "human vs human");
        game.addFirstPiece();

        game.setMode("human vs hard computer");

        assertEquals(new HardMode(game.getPossibleMove()).getNameMode(), game.getMode().getNameMode());

        game.setMode("human vs easy computer");

        //assertEquals(new EasyMode(game.getPossibleMove()).getNameMode(), game.getMode().getNameMode());

        game.setMode("human vs human");

        assertNull(game.getMode());

    }

    @Test
    void removeLastMove() {
        Game game = new Game(4, "human vs human");
        game.addFirstPiece();

        Move move = game.searchPieceInPossibleMove(2);
        game.addPiece(move);

        game.removeLastMove(move);
        assertEquals(10, game.getPositionBlackPieces().getLast());

        Move moveCanBeRemove = game.searchPieceInPossibleMove(1);
        assertThrows(NullPointerException.class, ()->game.removeLastMove(moveCanBeRemove));
    }

    @Test
    void findWinner() {
        Game game = new Game(4, "human vs human");
        game.addFirstPiece();

        assertNull(game.findWinner());

        Move moveP1 = game.searchPieceInPossibleMove(2);
        game.addPiece(moveP1);

        assertEquals(BLACK, game.findWinner());

        Move moveP2 = game.searchPieceInPossibleMove(3);
        game.addPiece(moveP2);

        moveP1 = game.searchPieceInPossibleMove(8);
        game.addPiece(moveP1);

        moveP2 = game.searchPieceInPossibleMove(1);
        game.addPiece(moveP2);

        assertEquals(WHITE, game.findWinner());
    }

    @Test
    void isNotHuman() {
        Game gameEasyBot= new Game(4, "human vs easy computer");
        assertTrue(gameEasyBot.isNotHuman());

        Game gameMiddleBot = new Game(4, "human vs hard computer");
        assertTrue(gameMiddleBot.isNotHuman());

        Game gameHuman = new Game(4, "human vs human");
        assertFalse(gameHuman.isNotHuman());
    }

    @Test
    void computerIsCurrentPlayer() {
        Game game = new Game(4, "human vs hard computer");
        game.addFirstPiece();

        assertFalse(game.computerIsCurrentPlayer());

        Move moveP1 = game.searchPieceInPossibleMove(2);
        game.addPiece(moveP1);

        assertTrue(game.computerIsCurrentPlayer());

    }
}