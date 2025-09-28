package g61305.othello.model;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static g61305.othello.model.Colors.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void addFirstPiecesEvenBoard() {

        Board evenBoard = new Board(8, "human vs human");

        evenBoard.addFirstPieces();
        assertEquals(2, evenBoard.getPositionBlackPieces().size()); // Test s'il y a bien deux pieces noire
        assertEquals(2, evenBoard.getPositionWhitePieces().size()); // Test s'l y a deux pieces blancs

        // Test si les pieces blanches sont au bon endroit
        assertEquals(28, evenBoard.getPositionWhitePieces().get(0));
        assertEquals(37, evenBoard.getPositionWhitePieces().get(1));

        // Test si les pieces noirs sont au bon endroit
        assertEquals(29, evenBoard.getPositionBlackPieces().get(0));
        assertEquals(36, evenBoard.getPositionBlackPieces().get(1));


    }
    @Test
    void addFirstPiecesOddBoard() {
        //Générer un tableau impair
        Board oddBoard = new Board(7, "human vs human");
        oddBoard.addFirstPieces();
        assertEquals(2, oddBoard.getPositionBlackPieces().size()); // Test s'il y a bien deux pieces noire
        assertEquals(2, oddBoard.getPositionWhitePieces().size()); // Test s'l y a deux pieces blancs

        // Test si les pieces blanches sont au bon endroit
        assertEquals(25, oddBoard.getPositionWhitePieces().get(0));
        assertEquals(33, oddBoard.getPositionWhitePieces().get(1));
        // Test si les pieces noirs sont au bon endroit
        assertEquals(26, oddBoard.getPositionBlackPieces().get(0));
        assertEquals(32, oddBoard.getPositionBlackPieces().get(1));
    }

    @Test
    void findWinner() {
        Board board = new Board(8, "human vs human");
        board.addFirstPieces();
        // equality
        assertNull(board.findWinner());
        //P1 win
        board.getPositionBlackPieces().add(7);
        assertEquals(BLACK, board.findWinner());
        //P2 win
        board.getPositionWhitePieces().add(9);
        board.getPositionWhitePieces().add(8);
        assertEquals(WHITE, board.findWinner());
    }


    @Test
    void addPiece() {
        Board board = new Board(4, "human vs human");
        board.addFirstPieces();

        // Piece 2 black bon
        Move move = board.findMoveInPossibleMove(2);
        board.addPiece(move);
        // Last value is 6 because piece 2 returns piece 6.
        assertEquals(6, board.getPositionBlackPieces().getLast());

        // null
        Move nullMove = board.findMoveInPossibleMove(12);
        assertThrows(IllegalArgumentException.class, ()-> board.addPiece(nullMove));
    }

    @Test
    void removeLastMove() {
        Board board = new Board(4, "human vs human");
        board.addFirstPieces();

        Move move = board.findMoveInPossibleMove(2);
        board.addPiece(move);
        // Last value is 6 because piece 2 returns piece 6.

        assertEquals(6, board.getPositionBlackPieces().getLast());


        LinkedList<Integer> piecesToReturn = new LinkedList<>();
        assertTrue( piecesToReturn.add(6));

        Move moveNeedToRemove = new Move(2, piecesToReturn);

        board.removeLastMove(moveNeedToRemove);

        assertNotEquals(2, board.getPositionBlackPieces().getLast());

        Move moveCantBeRemoved = board.findMoveInPossibleMove(0);
        assertThrows(IllegalArgumentException.class, ()-> board.removeLastMove(moveCantBeRemoved));
    }

    @Test
    void searchPieceInPossibleMove() {
        Board board = new Board(8, "human vs human");
        board.addFirstPieces();

        LinkedList<Integer> piecesToReturn = new LinkedList<>();
        piecesToReturn.add(28);
        Move realMove = new Move(20, piecesToReturn);

        // Est un movement possible
        Move move  = board.findMoveInPossibleMove(20);
        assertEquals(realMove, move);

        // N'est aps un mouvement possible
        move = board.findMoveInPossibleMove(50);
        assertNull(move);
    }

    @Test
    void setMode() {
        Board boardHuman = new Board(8, "human vs human");

        Mode easy = new EasyMode(boardHuman.getPossibleMove(), boardHuman.getWallPosition(), boardHuman.getSize(), boardHuman.getPositionWhitePieces(), boardHuman.getPositionBlackPieces());
        Mode middle = new HardMode(boardHuman.getPossibleMove());

        boardHuman.setMode("human vs easy computer");
        assertEquals(easy.getNameMode(), boardHuman.getMode().getNameMode());

        boardHuman.setMode("human vs hard computer");
        assertEquals(middle.getNameMode(), boardHuman.getMode().getNameMode());


        Board boardEasy = new Board(8, "human vs easy computer");

        boardEasy.setMode("human vs human");
        assertNull(boardEasy.getMode());

        boardEasy.setMode("human vs hard computer");
        assertEquals(middle.getNameMode(), boardEasy.getMode().getNameMode());

        Board boardMiddle = new Board(8, "human vs hard computer");

        boardMiddle.setMode("human vs human");
        assertNull(boardMiddle.getMode());

        boardMiddle.setMode("human vs easy computer");
        assertEquals(easy.getNameMode(), boardMiddle.getMode().getNameMode());
    }

    @Test
    void setGiveUp() {
        Board board = new Board(8, "human vs human");
        assertFalse(board.getGiveUp());
        board.setGiveUp();
        assertTrue(board.getGiveUp());
    }

    @Test
    void getComputerMoveWithBot() {
        Board board = new Board(4, "human vs hard computer");
        board.addFirstPieces();

        board.addPiece(board.findMoveInPossibleMove(2));

        LinkedList<Integer> piecesToReturns = new LinkedList<>();
        piecesToReturns.add(7);
        Move move = new Move(3, piecesToReturns);

        assertEquals(move, board.getComputerMove());
    }

    @Test
    void getComputerMoveWithoutBot() {
        Board board = new Board(4, "human vs human");
        board.addFirstPieces();

        board.addPiece(board.findMoveInPossibleMove(2));

        assertThrows(NullPointerException.class, board::getComputerMove);
    }
    @Test
    void getSize() {
        Board board = new Board(8, "human vs human");
        assertEquals(8, board.getSize());
    }

    @Test
    void getGameStatusGiveUp() {
        Board boardGiveUp = new Board(3, "human vs human");
        boardGiveUp.addFirstPieces();
        boardGiveUp.setGiveUp();
        assertFalse(boardGiveUp.getGameStatus());
    }

    @Test
    void getGameStatusNoMoreMove() {
        Board boardNoOneCantPlay = new Board(4, "human vs human");
        boardNoOneCantPlay.addFirstPieces();

        boardNoOneCantPlay.addPiece(boardNoOneCantPlay.findMoveInPossibleMove(2));
        assertTrue(boardNoOneCantPlay.getGameStatus());

        boardNoOneCantPlay.addPiece(boardNoOneCantPlay.findMoveInPossibleMove(3));
        assertTrue(boardNoOneCantPlay.getGameStatus());

        boardNoOneCantPlay.addPiece(boardNoOneCantPlay.findMoveInPossibleMove(4));
        assertTrue(boardNoOneCantPlay.getGameStatus());

        boardNoOneCantPlay.addPiece(boardNoOneCantPlay.findMoveInPossibleMove(9));
        assertTrue(boardNoOneCantPlay.getGameStatus());

        boardNoOneCantPlay.addPiece(boardNoOneCantPlay.findMoveInPossibleMove(13));
        assertTrue(boardNoOneCantPlay.getGameStatus());

        boardNoOneCantPlay.addPiece(boardNoOneCantPlay.findMoveInPossibleMove(1));
        assertTrue(boardNoOneCantPlay.getGameStatus());

        boardNoOneCantPlay.addPiece(boardNoOneCantPlay.findMoveInPossibleMove(5));
        assertTrue(boardNoOneCantPlay.getGameStatus());

        boardNoOneCantPlay.addPiece(boardNoOneCantPlay.findMoveInPossibleMove(16));
        assertFalse(boardNoOneCantPlay.getGameStatus());
    }

    @Test
    void getGameStatusNoMorePieces() {
        Board boardHallPiecesEaten = new Board(3, "human vs human");
        boardHallPiecesEaten.addFirstPieces();

        boardHallPiecesEaten.addPiece(boardHallPiecesEaten.findMoveInPossibleMove(4));
        assertTrue(boardHallPiecesEaten.getGameStatus());

        boardHallPiecesEaten.addPiece(boardHallPiecesEaten.findMoveInPossibleMove(3));
        assertTrue(boardHallPiecesEaten.getGameStatus());

        boardHallPiecesEaten.addPiece(boardHallPiecesEaten.findMoveInPossibleMove(7));
        assertTrue(boardHallPiecesEaten.getGameStatus());

        boardHallPiecesEaten.addPiece(boardHallPiecesEaten.findMoveInPossibleMove(1));
        assertFalse(boardHallPiecesEaten.getGameStatus());
    }

    @Test
    void getGameStatusBoardIsFull() {
        //The board is full
        Board boardFullOfPiece = new Board(3, "human vs human");
        boardFullOfPiece.addFirstPieces();

        boardFullOfPiece.addPiece(boardFullOfPiece.findMoveInPossibleMove(2));
        assertTrue(boardFullOfPiece.getGameStatus());

        boardFullOfPiece.addPiece(boardFullOfPiece.findMoveInPossibleMove(1));
        assertTrue(boardFullOfPiece.getGameStatus());

        boardFullOfPiece.addPiece(boardFullOfPiece.findMoveInPossibleMove(4));
        assertTrue(boardFullOfPiece.getGameStatus());

        boardFullOfPiece.addPiece(boardFullOfPiece.findMoveInPossibleMove(7));
        assertTrue(boardFullOfPiece.getGameStatus());

        boardFullOfPiece.addPiece(boardFullOfPiece.findMoveInPossibleMove(3));
        assertFalse(boardFullOfPiece.getGameStatus());
    }

    @Test
    void getCurrentPlayer() {
        Board board = new Board(4, "human vs human");
        board.addFirstPieces();

        assertEquals(BLACK, board.getCurrentPlayer());
        board.addPiece(board.findMoveInPossibleMove(2));
        assertEquals(WHITE, board.getCurrentPlayer());
    }
}