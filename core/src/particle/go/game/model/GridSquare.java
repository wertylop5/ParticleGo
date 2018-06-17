package particle.go.game.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class GridSquare {
    private int indexX;
    private int indexY;
    private Rectangle mRectangle;

    public GridSquare(Grid grid, int x, int y) {
        mRectangle = new Rectangle();
        mRectangle.x = x;
        mRectangle.y = y;
        mRectangle.width = grid.mSide;
        mRectangle.height = grid.mSide;
    }

    public void drawGamePiece(int gridX, int gridY, float width, float height,
                              ShapeRenderer renderer, GamePiece piece) {
        piece.drawInBox(gridX, gridY, width, height, renderer);
    }

    public boolean contains(int screenX, int screenY) {
        return mRectangle.contains(screenX, screenY);
    }
}
