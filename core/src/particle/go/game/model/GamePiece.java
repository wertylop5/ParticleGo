package particle.go.game.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public interface GamePiece {
    void drawInBox(int x, int y, float width, float height, ShapeRenderer renderer);
}
