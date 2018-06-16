package particle.go.game.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

public class Grid implements AppDrawable {
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
        for (Particle p : mParticles) {
            for (GamePiece m : mPieces) {
                //p.updateParticle(m);
            }
            //p.move();
        }
    }

    @Override
    public void draw(ShapeRenderer renderer) {
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.rect(10, 20, 200, 300);
        renderer.end();
    }
}
