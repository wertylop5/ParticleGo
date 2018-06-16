package particle.go.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import particle.go.game.model.Grid;
import particle.go.game.model.Magnet;
import particle.go.game.model.Player;

public class ParticleGo extends ApplicationAdapter{
	//private SpriteBatch batch;
	//private Texture img;
	private ShapeRenderer mRenderer;
	private OrthographicCamera mCamera;
	private Grid grid;
	private Player[] players;
	private int p_turn = 0;

	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		mRenderer = new ShapeRenderer();
		mCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		grid = new Grid(200, 200, 100, 100);
		players = new Player[2];
		for (int i = 0; i < 2; i++)
			players[i] = new Player();

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown (int x, int y, int pointer, int button) {
            	if (players[p_turn].turn(grid, x, y))
					switch_turn();
                return true; // return true to indicate the event was handled
            }
        });
	}

	private void switch_turn() {
		if (p_turn == 1)
			p_turn = 0;
		else
			p_turn = 1;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
		mCamera.setToOrtho(false, mCamera.viewportWidth, mCamera.viewportHeight);
		mCamera.position.set(mCamera.viewportWidth/2, mCamera.viewportHeight/2, 0);
		//mCamera.zoom = 2f;
		mCamera.update();
		mRenderer.setProjectionMatrix(mCamera.combined);


		Grid g = new Grid(200, 200, 10, 10);
		Magnet m = new Magnet(4, 5);
		g.draw(mRenderer);
		m.draw(mRenderer);
	}
	
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
	}
}
