package particle.go.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import particle.go.game.model.Grid;
import particle.go.game.model.Magnet;

public class ParticleGo extends Game {
	//private SpriteBatch batch;
	//private Texture img;
	private ShapeRenderer mRenderer;
	private OrthographicCamera mCamera;

	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		mRenderer = new ShapeRenderer();
		mCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
		mCamera.setToOrtho(false);
		mCamera.position.set(mCamera.viewportWidth/2, mCamera.viewportHeight/2, 0);
		//mCamera.zoom = 2f;
		mCamera.update();
		mRenderer.setProjectionMatrix(mCamera.combined);


		Grid g = new Grid(200, 200, 100, 100);
		Magnet m = new Magnet(4, 5);
		g.draw(mRenderer);
		m.draw(mRenderer);
	}
	
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
	}

	public void turn () {

	}
}
