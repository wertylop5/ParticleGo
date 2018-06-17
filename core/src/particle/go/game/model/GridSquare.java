package particle.go.game.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class GridSquare {
    private int indexX;
    private int indexY;
    private Rectangle mRectangle;
    private Actor mActor;

    public GridSquare(Grid grid, int x, int y) {
        mRectangle = new Rectangle();
        mRectangle.x = x;
        mRectangle.y = y;
        mRectangle.width = grid.mSide;
        mRectangle.height = grid.mSide;

        mActor = new Actor();
        mActor.setBounds(x, y, mRectangle.width, mRectangle.height);
        mActor.setX(x);
        mActor.setY(y);
//        mActor.addListener(new InputListener() {
//
//        });
    }

    public void drawGamePiece(int gridX, int gridY, float width, float height,
                              ShapeRenderer renderer, GamePiece piece) {
        piece.drawInBox(gridX, gridY, width, height, renderer);
    }

    public boolean contains(int screenX, int screenY) {
        return mRectangle.contains(screenX, screenY);
    }
}
