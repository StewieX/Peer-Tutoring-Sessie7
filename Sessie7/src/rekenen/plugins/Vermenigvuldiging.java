package rekenen.plugins;
/**
 * PEER TUTORING
 * P2W3
 */
public class Vermenigvuldiging implements Plugin{
    //Opgave 1.2


    public Vermenigvuldiging() {
    }

    @Override
    public String getCommand() {
        return "*";
    }

    @Override
    public double bereken(double x, double y) {
        return x*y;
    }
}
