package particle.go.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

public class Grid implements AppDrawable {
    private Array<Particle> mParticles;
    private Array<GamePiece> mPieces;
    public boolean[][] isPieceThere;

    private int mx;
    private int my;
    private int mWidth = 500;
    private int mHeight = 500;
    private int mXBoxes;
    private int mYBoxes;
    private float fractOfScreen = .75f; //fraction of the screen for the grid to take up

    public Grid(int x, int y, int xBoxes, int yBoxes) {
        mParticles = new Array<Particle>();
        mPieces = new Array<GamePiece>();
        mx = x;
        my = y;
        mXBoxes = xBoxes;
        mYBoxes = yBoxes;
    }

    public int[] screen_to_grid(int x, int y){
        int[] grid_coords = new int[2];
        grid_coords[0] = (x-mx) * mXBoxes / mWidth;
        grid_coords[1] = (y-my) * mYBoxes / mHeight;
        return null;
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
        int boxWidth = mWidth/ mXBoxes;
        int boxHeight = mHeight/ mYBoxes;

        float xScale = Gdx.graphics.getWidth()/mWidth;
        float yScale = Gdx.graphics.getHeight()/mHeight;

        float smallScale = xScale < yScale ? xScale : yScale;
        float bigScale = xScale > yScale ? xScale*Gdx.graphics.getWidth() :
                yScale*Gdx.graphics.getHeight();

        boolean xBig = Gdx.graphics.getWidth() > Gdx.graphics.getHeight();

        renderer.begin(ShapeRenderer.ShapeType.Line);
        for (int x = 0; x < boxWidth; x++) {
            for (int y = 0; y < boxHeight; y++) {
                renderer.rect(x*boxWidth*smallScale, y*boxHeight*smallScale,
                        boxWidth*smallScale, boxHeight*smallScale);
            }
        }
        renderer.end();
    }
}
