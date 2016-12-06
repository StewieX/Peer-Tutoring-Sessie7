package rekenen.plugins;
/**
 * PEER TUTORING
 * P2W3
 */
public class Deling implements Plugin{
    public Deling() {
    }
    //Opgave 1.2

    @Override
    public String getCommand() {
        return "/";
    }

    @Override
    public double bereken(double x, double y) {
        return x/y;
    }
}
