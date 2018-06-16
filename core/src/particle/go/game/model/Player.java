package particle.go.game.model;

import com.badlogic.gdx.InputAdapter;

public class Player extends InputAdapter {

    public boolean turn (Grid grid, int x, int y) {
        return grid.addMagnet(x, y);
    }

}
