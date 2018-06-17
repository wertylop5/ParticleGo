package particle.go.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import particle.go.game.model.Grid;
import particle.go.game.model.ScoreCounter;

public class ParticleGo extends ApplicationAdapter{
	//private SpriteBatch batch;
	//private Texture img;
	private ShapeRenderer mRenderer;
	private OrthographicCamera mCamera;
	private Grid grid;
	private int p_turn = 0;
	private int cur_turn = 1;
	private int max_turns = 10;
	private boolean ended = false;

	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		mRenderer = new ShapeRenderer();
		mCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		grid = new Grid(200, 200, 8, 8, 1, 20);

		InputMultiplexer multiInput = new InputMultiplexer() {
			@Override
			public boolean touchDown (int x, int y, int pointer, int button) {
				System.out.println("touch down");
				if (!ended)
					turn(grid, x, y);
				return true; // return true to indicate the event was handled
			}
		};
		/*multiInput.addProcessor(new GestureDetector(new GestureDetector.GestureAdapter(){
			@Override
			public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
								 Vector2 pointer1, Vector2 pointer2) {
				float dX = pointer1.x - initialPointer1.x +
						pointer2.x - initialPointer2.x;
				float dY = pointer1.y - pointer1.y +
						pointer2.y - initialPointer2.y;
				float mag = (float)Math.sqrt(dX*dX + dY*dY);

				System.out.println("Zoom: " + mCamera.zoom);
				mCamera.zoom *= mag;
				System.out.println("Zoom after: " + mCamera.zoom);
				mCamera.update();
				return true;
			}
		}));*/
        /*Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown (int x, int y, int pointer, int button) {
            	if (players[p_turn].turn(grid, x, y))
					switch_turn();
                return true; // return true to indicate the event was handled
            }
        });*/
		/*Gdx.input.setInputProcessor(new GestureDetector(new GestureDetector.GestureAdapter() {
			@Override
			public boolean zoom(float initialDistance, float distance) {
				float change = -(distance - initialDistance);
				*//*if (change < 0) {
					change = -(1/change);
				}*//*
				float percent = change / 300f;//max
				System.out.println("change: " + change);
				//System.out.println("change adjusted: " + (float)(10 - (10 - .05)*percent));
				System.out.println("change adjusted: " + change/3000);

				System.out.println("Zoom: " + mCamera.zoom);
				mCamera.zoom += change/3000;
				//mCamera.zoom = (float)(10 - (10 - .05)*percent);
				System.out.println("zoom before clamp: " + mCamera.zoom);
				mCamera.zoom = clamp(.5f, 10f, mCamera.zoom);
				System.out.println("Zoom after: " + mCamera.zoom);
				mCamera.update();
				return true;
			}
		}));*/
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
			}
		} else
			p_turn = 1;
	}

	private void end() {
		int[] scores = grid.count_scores();
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("Player %d: score %d%n", i, scores[i]);
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
		Stage stage = new Stage();
		(new ScoreCounter(4, 1)).update(stage);

	}
	
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
	}
}
