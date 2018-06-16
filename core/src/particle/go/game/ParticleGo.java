package particle.go.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import particle.go.game.model.Grid;
import particle.go.game.model.Magnet;

public class ParticleGo extends ApplicationAdapter {
	//private SpriteBatch batch;
	//private Texture img;
	private ShapeRenderer mRenderer;
	
	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		mRenderer = new ShapeRenderer();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();

		Grid g = new Grid(200, 200);
		Magnet m = new Magnet();
		g.draw(mRenderer);
		m.draw(mRenderer);
	}
	
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
	}
}
