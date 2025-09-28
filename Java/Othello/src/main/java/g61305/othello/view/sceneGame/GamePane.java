package g61305.othello.view.sceneGame;

import g61305.othello.controller.Controller;
import g61305.othello.model.Colors;
import g61305.othello.model.State;
import g61305.othello.view.MainPane;
import g61305.othello.view.sceneGame.center.centerBoard.BoardPane;
import g61305.othello.view.sceneGame.center.centerEnd.EndPane;
import g61305.othello.view.sceneGame.center.centerPause.CenterPausePane;
import g61305.othello.view.sceneGame.playerPane.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class GamePane extends BorderPane implements PropertyChangeListener {

    private final BoardPane boardPane;
    private final PlayerPane playerOneInfo;
    private final PlayerPane playerTwoInfo;
    private final ButtonBox buttonBox;
    private CenterPausePane centerPausePane;
    private final Stage stage;


    public GamePane(Stage stage, int size, String mode) {
        this.stage = stage;

        buttonBox = new ButtonBox();

        boardPane = new BoardPane(size, stage);
        centerPausePane = new CenterPausePane(boardPane, stage);

        if ("human vs human".equals(mode)) {
            playerOneInfo = new HumanPane();
            playerTwoInfo = new HumanPane();
        } else {
            playerOneInfo = new HumanPane();
            playerTwoInfo = new BotPane(mode);
        }
        filterWaitForPlay();

        //Custom
        setCenter(boardPane);
        setLeft(playerOneInfo);
        setRight(playerTwoInfo);
        setBottom(buttonBox);

        playerOneInfo.minWidthProperty().bind(boardPane.widthProperty().divide(3));
        playerTwoInfo.minWidthProperty().bind(boardPane.widthProperty().divide(3));
        buttonBox.minHeightProperty().bind(boardPane.heightProperty().divide(8));

        setButtonAction();

        getStyleClass().add("gamePane-style");
        setPadding(new Insets(20));
    }


    private void setButtonAction() {
        setPauseButton();
        setContinueButton();
        setMenuButton();
    }


    private void setMenuButton() {
        buttonBox.getMenuButton().setOnAction(actionEvent -> {
            MainPane mainPane = new MainPane(stage);
            Scene scene = new Scene(mainPane, stage.getWidth(), stage.getHeight());
            scene.getStylesheets().add("style.css");

            stage.setScene(scene);
        });
    }

    private void setPauseButton() {
        buttonBox.getPauseButton().setOnAction(actionEvent -> {
            centerPausePane = new CenterPausePane(boardPane, stage);
            setCenter(centerPausePane);
            buttonBox.setButton("continue");
        });
    }

    private void setContinueButton() {
        buttonBox.getContinueButton().setOnAction(actionEvent -> {
            setCenter(boardPane);
            buttonBox.setButton("pause");
        });
    }


    public void initialize(Controller controller) {
        stage.getScene().windowProperty().isNotNull().addListener(observable -> controller.addFirstPiece());
        boardPane.initialize(controller);
        buttonBox.initialize(controller);

        playersInitialize(controller);
    }


    private void playersInitialize(Controller controller) {
        playerOneInfo.initialize(controller);
        playerTwoInfo.initialize(controller);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        State state = (State) evt.getNewValue();
        int newPiece = state.getLastPiece();
        if ("giveUp".equals(evt.getPropertyName())) {
            displayGiveUpEndGame(state);
        } else {
            boardUpDate(state, newPiece);
            playersUpDate(state);
            priseUpdate(state);
            if (!state.getStatusGameOn()) {
                displayEndGame();
            }
        }
    }


    private void priseUpdate(State state) {
        int prise = state.getPrise();
        switch (state.getCurrentPlayer()){
            case BLACK -> playerTwoInfo.setPriseNumberLabel(prise);
            case WHITE -> playerOneInfo.setPriseNumberLabel(prise);
        }
    }

    private void displayGiveUpEndGame(State state) {
        String winnerName = "";
        switch (state.getCurrentPlayer()) {
            case BLACK-> winnerName = playerTwoInfo.getNamePlayer();
            case WHITE -> winnerName = playerOneInfo.getNamePlayer();
        }
        EndPane endPane = new EndPane(boardPane);
        endPane.setWinnerNameLabel(winnerName);
        setCenter(endPane);
        buttonBox.setButton("menu");
    }

    private void playersUpDate(State state) {
        int scorePlayer1 = state.getBlackPieces().size();
        int scorePlayer2 = state.getWhitePieces().size();

        playerOneInfo.setScoreLabel(String.valueOf(scorePlayer1));
        playerTwoInfo.setScoreLabel(String.valueOf(scorePlayer2));


        setNamesPlayers(state);
        if (state.getStatusGameOn()) {
            setCurrentPlayer(state.getCurrentPlayer());
        }
    }

    private void setNamesPlayers(State state) {
        String nameBot;
        switch (state.getNameMode()) {
            case "human vs easy bot" -> nameBot = "easy bot";
            case "human vs hard bot" -> nameBot = "hard bot";
            default -> nameBot = "Player 2";
        }
        playerTwoInfo.setNamePlayer(nameBot);
    }

    private void setCurrentPlayer(Colors currentPlayer) {
        switch (currentPlayer) {
            case BLACK -> {
                playerOneInfo.setCurrentPlayer(true);
                playerTwoInfo.setCurrentPlayer(false);
            }
            case WHITE -> {
                playerOneInfo.setCurrentPlayer(false);
                playerTwoInfo.setCurrentPlayer(true);
            }
        }
    }

    private void filterWaitForPlay() {
        addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (!playerOneInfo.getIsCurrentPlayer()
                    && !playerTwoInfo.getNamePlayer().equals("Player 2")) {
                mouseEvent.consume();
            }
        });
    }


    private void boardUpDate(State state, int newPiece) {
        boardPane.update(state, newPiece);
    }

    public void displayEndGame() {
        String winnerName = findWinner();

        EndPane endPane = new EndPane(boardPane);
        endPane.setWinnerNameLabel(winnerName);
        setCenter(endPane);
        buttonBox.setButton("menu");
    }

    private String findWinner() {
        String player1 = playerOneInfo.getNamePlayer();
        String player2 = playerTwoInfo.getNamePlayer();

        int score1 = playerOneInfo.getScoreLabel();
        int score2 = playerTwoInfo.getScoreLabel();

        return score1 > score2 ? player1 : score1 < score2 ? player2 : "both";
    }

    public void displayError(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information !");
        alert.setContentText(message);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add("style.css");

        ImageView imageView = new ImageView("cross-red-alert.png");
        imageView.setRotate(-45);
        imageView.setFitHeight(70);
        imageView.setFitWidth(70);
        alert.setGraphic(imageView);

        alert.initStyle(StageStyle.TRANSPARENT);

        alert.showAndWait();
    }

    public void displayErrorWrongCase(int position) {
        boardPane.wrongCaseBox(position);
    }
}
