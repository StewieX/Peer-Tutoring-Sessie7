package rekenen.plugins;

/**
 * PEER TUTORING
 * P2W3
 */
public interface Plugin {
    //Opgave 1.1
    String getCommand();

    double bereken(double x, double y);

    default String getAuteur(){
        return "KdG";
    }
}