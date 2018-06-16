package particle.go.game.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Magnet implements GamePiece, AppDrawable {
    double[] position;
    double charge = -1.0;

    Magnet(double px, double py){
        position = new double[2];
        position[0] = px;
        position[1] = py;
    }

    @Override
    public void draw(ShapeRenderer renderer){
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.circle(500, 500, 100);
        renderer.end();
    }
}
