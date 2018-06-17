package particle.go.game.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Particle implements AppDrawable {
    private static final float RADIUS = 10f;

    public double[] position;
    private double[] velocity;
    private double mass = 1.0;
    private double charge = 1.0;
    private double delta = 0.1;

    Particle(double px, double py, double vx, double vy){
        position = new double[2];
        velocity = new double[2];
        position[0] = px;
        position[1] = py;
        velocity[0] = vx;
        velocity[1] = vy;
    }

    private void normalize(double array[]){
        double mag = magnitude(array);
        for (int i = 0; i < array.length; i++){
            array[i] /= mag;
        }
    }

    private double magnitude(double array[]){
        double sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += Math.pow(array[i], 2);
        }
        return Math.sqrt(sum);
    }

    public void updateParticle(Magnet magnet){
        double[] displacement = new double[2];
        for (int i = 0; i < 2; i++){
            displacement[i] = position[i] - magnet.position[i];
        }
        double accel = (charge * magnet.charge / Math.pow(magnitude(displacement), 2)) / mass;
        normalize(displacement);
        for (int j = 0; j < 2; j++){
            velocity[j] += accel * delta * displacement[j];
        }
    }

    public void move(){
        position[0] += velocity[0] * delta;
        position[1] += velocity[1] * delta;
    }

    @Override
    public void draw(ShapeRenderer renderer){
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.circle((float)position[0], (float)position[1], RADIUS);
        renderer.end();
    }
}
