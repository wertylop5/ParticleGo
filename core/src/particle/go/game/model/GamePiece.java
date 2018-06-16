package particle.go.game.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public interface GamePiece {
    void drawInBox(int gridX, int gridY, int boxX, int boxY, float width,
                   float height, ShapeRenderer renderer);
}
