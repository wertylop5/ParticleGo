package particle.go.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

import particle.go.game.model.Grid;
import particle.go.game.model.ScoreCounter;

public class ParticleGo extends ApplicationAdapter{
	//private SpriteBatch batch;
	//private Texture img;
	private ShapeRenderer mRenderer;
	private OrthographicCamera mCamera;
	private Grid grid;
	private ScoreCounter mCounter;
	private Stage mStage;
	//private TextButton mTextButton;
	private int p_turn = 0;
	private int cur_turn = 1;
	private int max_turns = 20;
	private boolean ended = false;

	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		mRenderer = new ShapeRenderer();
		mCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		grid = new Grid(10, 100, 100,
				15, 8, 1, 20);
		mCounter = new ScoreCounter(0, 0);
		mStage = new Stage();

//		TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
//		style.font = new BitmapFont();
//		mTextButton = new TextButton("Toggle repel", style);
//		mTextButton.setPosition(20, 20);
		//mTextButton.scaleBy(100);
		//mTextButton.setSize(100, 100);
		//mStage.addActor(mTextButton);

		InputMultiplexer multiInput = new InputMultiplexer() {
			@Override
			public boolean touchDown (int x, int y, int pointer, int button) {
				System.out.println("touch down");
				if (!ended)
					turn(grid, x, y);
				return true; // return true to indicate the event was handled
			}
		};

		Gdx.input.setInputProcessor(multiInput);
	}

	private float clamp(float min, float max, float val) {
		val = val < min ? min : val;
		val = val > max ? max : val;
		return val;
	}

	private void turn(Grid grid, int x, int y) {
		if (grid.addMagnet(x, y, p_turn))
			next_turn();
	}

	private void next_turn() {
		if (p_turn == 1) {
			p_turn = 0;
			grid.updateGrid();
			cur_turn++;
			if (cur_turn > max_turns) {
				end();
				//mCounter.update(mStage);
			}
		} else
			p_turn = 1;
	}

	private void end() {
		int[] scores = grid.count_scores();
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("Player %d: score %d%n", i, scores[i]);
			if (i == 0) mCounter.addPlayerOneScore(scores[0]);
			else mCounter.addPlayerTwoScore(scores[1]);
		}
		ended = true;
	}


	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
		mCamera.setToOrtho(true, mCamera.viewportWidth, mCamera.viewportHeight);
		mCamera.position.set(mCamera.viewportWidth/2, mCamera.viewportHeight/2, 0);
		//mCamera.zoom = 2f;
		mCamera.update();
		mRenderer.setProjectionMatrix(mCamera.combined);

		grid.draw(mRenderer);

		//(new ScoreCounter(4, 1)).update(stage);
		if (ended) mCounter.update(mStage);
		//mStage.act();
		//mStage.draw();
	}
	
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
	}
}
