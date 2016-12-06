package rekenen.plugins;
/**
 * PEER TUTORING
 * P2W3
 */
public class Macht implements Plugin{
    public Macht() {
    }
    //Opgave 1.2

    @Override
    public String getCommand() {
        return "^";
    }

    @Override
    public double bereken(double x, double y) {
        return Math.pow(x,y);
    }
}
