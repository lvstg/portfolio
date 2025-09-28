package g61305.othello.controller;

import g61305.othello.model.Game;
import g61305.othello.view.sceneGame.GamePane;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Objects;


public class Controller {
    private final Game model;
    private final GamePane view;

    private final LinkedList<OthelloCommands> undoHistory;

    private final LinkedList<OthelloCommands> redoHistory;

    public Controller( Game model, GamePane view) {
        Objects.requireNonNull(model, "The model cannot be null.");
        Objects.requireNonNull(view, "The view cannot be null.");
        this.model = model;
        this.view = view;

        undoHistory = new LinkedList<>();
        redoHistory = new LinkedList<>();
    }

    public void initialize() {
        view.initialize(this);
        model.addObserver(view);
    }


    public void addFirstPiece() {
        OthelloCommands command = new OthelloCommands(model, view);
        command.addFirstPiece();
    }


    public void giveUp() {
        OthelloCommands command = new OthelloCommands(model, view);
        command.giveUp();
    }

    public void addWall(int newWall){
        try {
            OthelloCommands command = new OthelloCommands(model, view, newWall);
            command.addWall();
        }catch (IllegalArgumentException e){
            view.displayError(e.getMessage());
        }
    }

    public void addPiece(int position) {
        try {
            OthelloCommands command = new OthelloCommands(position, model, view);
            command.addPiece();
            undoHistory.add(command);
            redoHistory.clear();
        } catch (NullPointerException e) {
            view.displayErrorWrongCase(position);
        }
    }

    public void setMode(@NotNull String newMode) {
        OthelloCommands command = new OthelloCommands(newMode, model, view);
        command.setMode();
    }


    public void undo() {
        if (!undoHistory.isEmpty()) {
            OthelloCommands command = undoHistory.removeLast();
            command.undo();
            redoHistory.add(command);
        }else {
            view.displayError("That's as far as you can go.");
        }
    }


    public void redo() {
        if (!redoHistory.isEmpty()) {
            OthelloCommands command = redoHistory.removeLast();
            command.redo();
            undoHistory.add(command);
        }else {
            view.displayError("That's as far as you can go.");
        }
    }


}
