package particle.go.game.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Magnet implements GamePiece, AppDrawable {
    double[] position;
    double charge = -1.0;

    @Override
    public void draw(ShapeRenderer renderer){
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.circle(500, 500, 100);
        renderer.end();
    }
}
