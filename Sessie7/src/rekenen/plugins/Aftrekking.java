package rekenen.plugins;
/**
 * PEER TUTORING
 * P2W3
 */
public class Aftrekking implements Plugin{
    public Aftrekking() {
    }

    @Override
    public String getCommand() {
        return "-";
    }

    @Override
    public double bereken(double x, double y) {
        return x - y;
    }
    //Opgave 1.3
}
