import rekenen.Rekenmachine;
import rekenen.plugins.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * PEER TUTORING
 * P2W3
 */
public class TestRekenmachine {
    private static Rekenmachine mijnCalc = new Rekenmachine();

    public static void main(String[] args) {
        //Opgave 3.1

        mijnCalc.installeer(new Optelling());
        mijnCalc.installeer(new Aftrekking());
        mijnCalc.installeer(new Vermenigvuldiging());
        mijnCalc.installeer(new Deling());
        mijnCalc.installeer(new Macht());

        doeBerekeningEnDrukAf("+", 5, 2);
        doeBerekeningEnDrukAf("-", 5, 2);
        doeBerekeningEnDrukAf("*", 5, 2);
        doeBerekeningEnDrukAf("/", 5, 2);
        doeBerekeningEnDrukAf("^", 5, 2);
        doeBerekeningEnDrukAf("?", 5, 2);
        System.out.println(mijnCalc.toString());

        mijnCalc.installeer(new Plugin() {
            @Override
            public String getCommand() {
                return "MIN";
            }

            @Override
            public double bereken(double x, double y) {
                return Math.min(x,y);
            }

            @Override
            public String getAuteur() {
                return "Anoniem";
            }
        });

        mijnCalc.installeer(new Plugin() {
            @Override
            public String getCommand() {
                return "MAX";
            }

            @Override
            public double bereken(double x, double y) {
                return Math.max(x,y);
            }

            @Override
            public String getAuteur() {
                return "Anoniem";
            }
        });

        mijnCalc.getLog();

        //Opgave 3.2
        Scanner scanner = new Scanner(System.in);
        boolean finished = false;
        String command;
        String numbersInput;
        double[] numbers;

        System.out.println(String.format("\nWelkom bij de dynamische rekenmachine!\nGeïnstalleerde plugins: %s", mijnCalc.toString()));
        while (!finished) {
            System.out.print("\nWelke berekening wenst U uit te voeren (<ENTER> om te stoppen)? ");
            command = scanner.nextLine();
            if (command.isEmpty()) {
                finished = true;
                System.out.println(mijnCalc.getLog());
            } else {
                System.out.print("Geef twee getallen in (gescheiden door een spatie): ");
                numbersInput = scanner.nextLine();
                numbers = Arrays.stream(numbersInput.split(" ")).mapToDouble(Double::parseDouble).toArray();
                doeBerekeningEnDrukAf(command, numbers[0], numbers[1]);
            }
        }

    }

    //Opgave 3.1
    private static void doeBerekeningEnDrukAf(String commando, double getal1, double getal2) {
        System.out.printf("%.2f %s %.2f = %.2f\n"
                , getal1, commando, getal2
                , mijnCalc.bereken(commando, getal1, getal2));
    }
}
