package particle.go.game.model;

public class Magnet implements GamePiece {
    double[] position;
    double charge = -1.0;
    
    Magnet(double px, double py){
        position = new double[2];
        position[0] = px;
        position[1] = py;
    }
    public void draw(){}
}
