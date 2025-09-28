package g61305.othello.controller;

public interface Command {
    void addFirstPiece();

    void addWall();

    void giveUp();

    void addPiece();

    void setMode();

    void undo();

    void redo();
}
