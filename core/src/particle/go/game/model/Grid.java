package particle.go.game.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

public class Grid implements AppDrawable{
    private Array<Particle> mParticles;
    private Array<GamePiece> mPieces;

    private float mWidth;
    private float mHeight;

    public Grid(float width, float height) {
        mParticles = new Array<Particle>();
        mPieces = new Array<GamePiece>();

        mWidth = width;
        mHeight = height;
    }

    public void updateGrid() {
        for (GamePiece m : mPieces) {
            for (Particle p : mParticles) {
                //p.updateParticle(m);
                //p.move();
            }
        }
    }

    public void draw(ShapeRenderer renderer) {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.rect(10, 20, 20, 30);
        renderer.end();
    }
}
