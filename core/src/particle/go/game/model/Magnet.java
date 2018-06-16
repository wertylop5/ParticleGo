package particle.go.game.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Magnet implements GamePiece {
    int[] position;
    double charge = -1.0;

    public Magnet(int px, int py) {
        position = new int[2];
        position[0] = px;
        position[1] = py;
    }

    @Override
    public void drawInBox(int gridX, int gridY, int boxX, int boxY, float width, float height, ShapeRenderer renderer) {
        renderer.setColor(Color.SALMON);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.circle(gridX+boxX*width+(width/2), gridY+boxY*height+(height/2),
                width/2);
        renderer.end();
    }
}
