package rekenen.plugins;
/**
 * PEER TUTORING
 * P2W3
 */
public class Optelling implements Plugin{
    //Opgave 1.2

    public Optelling() {
    }

    @Override
    public String getCommand() {
        return "+";
    }

    @Override
    public double bereken(double x, double y) {
        return x + y;
    }
}
