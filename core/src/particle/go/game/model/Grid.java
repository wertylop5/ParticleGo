package particle.go.game.model;

import com.badlogic.gdx.utils.Array;

public class Grid implements AppDrawable{
    private Array<Particle> mParticles;
    private Array<Magnet> mMagnets;

    public Grid() {
        mParticles = new Array<Particle>();
        mMagnets = new Array<Magnet>();
    }

    public void updateGrid() {

    }

    public void draw() {

    }
}
