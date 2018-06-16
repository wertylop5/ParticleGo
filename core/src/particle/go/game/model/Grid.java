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
        isPieceThere = new boolean[mXBoxes][mYBoxes];
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
        return grid_coords;
    }

    public boolean addMagnet(int x, int y) {
        int[] grid_coords = screen_to_grid(x, y);
        int grid_x = grid_coords[0];
        int grid_y = grid_coords[1];
        if (0 <= grid_x && grid_x < mXBoxes &&
                0 <= grid_y && grid_y <= mYBoxes &&
                !isPieceThere[grid_x][grid_y]) {
            mPieces.add(new Magnet(x, y));
            isPieceThere[grid_x][grid_y] = true;
            return true;
        }
        return false;
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

        renderer.begin(ShapeRenderer.ShapeType.Line);
        for (int x = 0; x < mXBoxes; x++) {
            for (int y = 0; y < mYBoxes; y++) {
                renderer.rect(mx+x*boxWidth, my+y*boxHeight, boxWidth, boxHeight);
            }
        }
        renderer.end();
    }

    public float getBoxWidth() { return (mWidth-mx)/ mXBoxes; }
    public float getBoxHeight() { return (mHeight-my)/ mYBoxes; }

    public int getLowerX() { return mx; }
    public int getLowery() { return my; }

    public float getMaxX() { return mx+mXBoxes*mWidth; }
    public float getMaxY() { return my+mYBoxes*mHeight; }
}
