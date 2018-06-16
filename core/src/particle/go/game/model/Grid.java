package particle.go.game.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

public class Grid implements AppDrawable {
    private Array<Particle> mParticles;
    private Array<GamePiece> mPieces;
    public boolean[][] isPieceThere;

    private int mx;
    private int my;
    private int mWidth;
    private int mHeight;
    private int x_boxes = 10;
    private int y_boxes = 10;

    public Grid(int x, int y, int width, int height) {
        mParticles = new Array<Particle>();
        mPieces = new Array<GamePiece>();
        mx = x;
        my = y;
        mWidth = width;
        mHeight = height;
    }

    public int[] screen_to_grid(int x, int y){
        int[] grid_coords = new int[2];
        grid_coords[0] = (x-mx) * x_boxes / mWidth;
        grid_coords[1] = (y-my) * y_boxes / mHeight;
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
        renderer.rect(0, 0, 200, 300);
        renderer.end();
    }
}
