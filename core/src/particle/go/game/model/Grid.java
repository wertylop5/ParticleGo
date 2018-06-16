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
    private int mWidth;
    private int mHeight;
    private int mXBoxes;
    private int mYBoxes;

    public Grid(int x, int y, int xBoxes, int yBoxes) {
        mParticles = new Array<Particle>();
        mPieces = new Array<GamePiece>();
        mx = x;
        my = y;
        mXBoxes = xBoxes;
        mYBoxes = yBoxes;

        int tWidth = Gdx.graphics.getWidth();
        int tHeight = Gdx.graphics.getHeight();
        mHeight = mWidth = tWidth < tHeight ? tWidth : tHeight;
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
        float boxWidth = getBoxWidth();
        float boxHeight = getBoxHeight();

        float xScale = Gdx.graphics.getWidth()/mWidth;
        float yScale = Gdx.graphics.getHeight()/mHeight;

//        float smallScale = xScale < yScale ? xScale : yScale;
//        float bigScale = xScale > yScale ? xScale*Gdx.graphics.getWidth() :
//                yScale*Gdx.graphics.getHeight();
//
//        boolean xBig = Gdx.graphics.getWidth() > Gdx.graphics.getHeight();

        renderer.begin(ShapeRenderer.ShapeType.Line);
        for (int x = 0; x < mXBoxes; x++) {
            for (int y = 0; y < mYBoxes; y++) {
                renderer.rect(x*boxWidth, y*boxHeight, boxWidth, boxHeight);
            }
        }
        renderer.end();
    }

    public float getBoxWidth() {
        return mWidth/ mXBoxes;
    }

    public float getBoxHeight() {
        return mHeight/ mYBoxes;
    }
}
