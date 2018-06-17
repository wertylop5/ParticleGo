package particle.go.game.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Magnet implements GamePiece {
    int[] positionBox;
    int[] positionScreen;
    Color color;
    double charge = -1.0;

    public Magnet(int xbox, int ybox, int new_x, int new_y, Color new_color) {
        positionBox = new int[2];
        positionBox[0] = xbox;
        positionBox[1] = ybox;
        positionScreen = new int[2];
        positionScreen[0] = new_x;
        positionScreen[1] = new_y;

        color = new_color;
    }

    @Override
    public void drawInBox(int gridX, int gridY, float width, float height, ShapeRenderer renderer) {
        renderer.setColor(color);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.circle(gridX + positionBox[0] * width + (width / 2), gridY + positionBox[1] * height + (height / 2),
                width / 2);
        renderer.end();
    }
}
