package g61305.othello.controller;

import g61305.othello.model.Game;
import g61305.othello.model.Move;
import g61305.othello.view.sceneGame.GamePane;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

import java.util.Objects;

public class OthelloCommands implements Command {

    private Move humanMove;

    private Move computerMove;

    private String newMode;

    private final Game model;

    private final GamePane view;

    private int newWall = 0;


    public OthelloCommands(Game model, GamePane view) {
        Objects.requireNonNull(model, "The model cannot be null.");
        Objects.requireNonNull(view, "The view cannot be null.");
        this.model = model;
        this.view = view;
    }
    public OthelloCommands( Game model, GamePane view, int newWall) {
        Objects.requireNonNull(model, "The model cannot be null.");
        Objects.requireNonNull(view, "The view cannot be null.");
        this.model = model;
        this.view = view;
        this.newWall = newWall;
    }

    public OthelloCommands(int position, Game model, GamePane view) {
        Objects.requireNonNull(model, "The model cannot be null.");
        Objects.requireNonNull(view, "The view cannot be null.");
        this.model = model;
        this.view = view;
        this.humanMove = model.searchPieceInPossibleMove(position);
        this.computerMove = null;
        this.newWall = position;
    }

    public OthelloCommands( String newMode,  Game model,  GamePane view) {
        Objects.requireNonNull(newMode, "The new mode cannot be null.");
        Objects.requireNonNull(model, "The model cannot be null.");
        Objects.requireNonNull(view, "The view cannot be null.");
        this.newMode = newMode;
        this.model = model;
        this.view = view;
    }

    @Override
    public void addWall()throws IllegalArgumentException{
        model.addWall(newWall);
        if (model.isNotHuman() && model.getGameStatus()) {
            computerAddPiece();
        }
    }
    @Override
    public void addPiece() throws NullPointerException {
        model.addPiece(humanMove);
        if (model.isNotHuman() && model.getGameStatus()) {
            computerAddPiece();
        }
    }

    public void computerAddPiece() {
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> {
            computerMove = model.getComputerMove();
            model.addPiece(computerMove);
            if (!model.computerIsCurrentPlayer() || !model.getGameStatus()) {
                pause.stop();
            } else {
                pause.play();
            }
        });
        if (model.computerIsCurrentPlayer() && model.getGameStatus()) {
            pause.play();
        }

    }

    @Override
    public void addFirstPiece() {
        model.addFirstPiece();
    }

    @Override
    public void giveUp() {
        if (model.getGameStatus()){
            model.setGiveUp();
        }
    }

    @Override
    public void setMode() {
        model.setMode(newMode);
    }

    @Override
    public void undo() {
        try {
            if (model.isNotHuman()) {
                model.removeLastMove(computerMove);
            }
            model.removeLastMove(humanMove);
        } catch (NullPointerException e) {
            view.displayError(e.getMessage());
        }
    }

    @Override
    public void redo() {
        try {
            model.addPiece(humanMove);
            if (model.isNotHuman()) {
                model.addPiece(computerMove);
            }
        } catch (NullPointerException e) {
            view.displayError(e.getMessage());
        }
    }


}
