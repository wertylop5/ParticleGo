package particle.go.game.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public interface GamePiece {
    void drawInBox(int gridX, int gridY, float width, float height, ShapeRenderer renderer);
}
