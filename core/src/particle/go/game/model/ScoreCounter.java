package particle.go.game.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class ScoreCounter {
    private int mPlayerOneScore;
    private int mPlayerTwoScore;
    private BitmapFont mFont;
    private Batch mBatch;

    public ScoreCounter(int scoreOne, int scoreTwo) {
        mPlayerOneScore = scoreOne;
        mPlayerTwoScore = scoreTwo;
        mFont = new BitmapFont();
        mBatch = new SpriteBatch();
    }

//    public void update() {
//        mBatch.begin();
//        mFont.setColor(0, 1, 0, 1);
//        mFont.draw(mBatch, "score " + mPlayerOneScore, 400, 400);
//        mBatch.end();
//    }

    public void incrementPlayerOne() { mPlayerOneScore++;}
    public void incrementPlayerTwo() { mPlayerTwoScore++;}

    public void addPlayerOneScore(int score) {mPlayerOneScore += score;}
    public void addPlayerTwoScore(int score) {mPlayerTwoScore += score;}

    public void update(Stage stage) {
        System.out.println("updating display");
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = new BitmapFont();

        Label playerOneLabel = new Label("Score: " + mPlayerOneScore, style);
        Label playerTwoLabel = new Label("Score: " + mPlayerTwoScore, style);
        playerOneLabel.setFontScale(3);
        playerOneLabel.setPosition(300, 1000);
        playerTwoLabel.setFontScale(3);
        playerTwoLabel.setPosition(1200, 1000);

        stage.addActor(playerOneLabel);
        stage.addActor(playerTwoLabel);
        stage.act();
        stage.draw();
    }
}
