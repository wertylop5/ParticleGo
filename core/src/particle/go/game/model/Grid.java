package particle.go.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class Grid implements AppDrawable {
    private Array<Particle> mParticles;
    private Array<GamePiece> mPieces;
    public boolean[][] isPieceThere;
    private Array<Rectangle> mSquares;

    private int mx;
    private int my;
    private int mWidth;
    private int mHeight;
    private int mXBoxes;
    private int mYBoxes;
    private int mScoring_cols;

    public Grid(int x, int y, int xBoxes, int yBoxes, int scoring_cols, int num_particles) {
        mParticles = new Array<Particle>();
        mPieces = new Array<GamePiece>();
        isPieceThere = new boolean[xBoxes][yBoxes];
        mSquares = new Array<Rectangle>();
        mx = x;
        my = y;
        mXBoxes = xBoxes;
        mYBoxes = yBoxes;
        mScoring_cols = scoring_cols;

        int tWidth = Gdx.graphics.getWidth() - mx;
        int tHeight = Gdx.graphics.getHeight() - my;
        mHeight = mWidth = tWidth < tHeight ? tWidth : tHeight;
        generate_particles(num_particles);
    }

    private void generate_particles(int num_particles) {
        float bw = getBoxWidth();
        for (int i = 0; i < (num_particles / 2); i++) {
            double randx = Math.random() * (mWidth - 2 * bw * mScoring_cols) + mx + bw * mScoring_cols;
            double randy = Math.random() * mHeight + my;
            mParticles.add(new Particle(randx, randy, 0, 0));
            double center = mx + mWidth / 2;
            mParticles.add(new Particle(2 * center - randx, randy, 0, 0));
        }
    }

    public int[] screen_to_grid(int x, int y){
        int[] grid_coords = new int[2];
        grid_coords[0] = (x-mx) / (int) getBoxWidth();
        grid_coords[1] = (y-my) / (int) getBoxHeight();
        return grid_coords;
    }

    public boolean addMagnet(int x, int y, int turn) {
        int[] grid_coords = screen_to_grid(x, y);
        int grid_x = grid_coords[0];
        int grid_y = grid_coords[1];
        if (0 <= grid_x && grid_x < mXBoxes &&
                0 <= grid_y && grid_y < mYBoxes &&
                !isPieceThere[grid_x][grid_y] &&
                ((turn == 0 && grid_x < mXBoxes - mScoring_cols) ||
                        (turn == 1 && mScoring_cols <= grid_x))) {
            Color color = Color.BLUE;
            if (turn == 0)
                color = color.RED;
            mPieces.add(new Magnet(grid_x, grid_y, x, y, color));
            isPieceThere[grid_x][grid_y] = true;
            return true;
        }
        return false;
    }

    public int[] count_scores() {
        int[] scores = new int[2];
        for (Particle particle : mParticles) {
            if (particle.position[0] < mx + getBoxWidth() * mScoring_cols)
                scores[0]++;
            else if (particle.position[0] > mx + mWidth - getBoxWidth() * mScoring_cols)
                scores[1]++;
        }
        return scores;
    }

    public void updateGrid() {
        for (Particle p : mParticles) {
            for (GamePiece m : mPieces) {
                p.updateParticle((Magnet)m);
            }
            p.move();
        }
    }

    @Override
    public void draw(ShapeRenderer renderer) {
        float boxWidth = getBoxWidth();
        float boxHeight = getBoxHeight();

        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.WHITE);
        for (int x = 0; x < mXBoxes; x++) {
            for (int y = 0; y < mYBoxes; y++) {
                Rectangle rect = new Rectangle();
                rect.height = boxHeight;
                rect.width = boxWidth;
                rect.x = mx+x*boxWidth;
                rect.y = my+y*boxHeight;

                mSquares.add(rect);
                renderer.rect(mx+x*boxWidth, my+y*boxHeight, boxWidth, boxHeight);
            }
        }
        renderer.end();

        for (GamePiece piece : mPieces) {
            piece.drawInBox(getLowerX(), getLowery(), getBoxWidth(), getBoxHeight(), renderer);
        }

        for (Particle particle : mParticles) {
            particle.draw(renderer);
        }
    }

    public float getBoxWidth() { return mWidth / mXBoxes; }
    public float getBoxHeight() { return mHeight / mYBoxes; }

    public int getLowerX() { return mx; }
    public int getLowery() { return my; }

    public float getMaxX() { return mx+mXBoxes*mWidth; }
    public float getMaxY() { return my+mYBoxes*mHeight; }

    public Rectangle getSquare(int x, int y) {
        return mSquares.get(y*mYBoxes+x);
    }
}
