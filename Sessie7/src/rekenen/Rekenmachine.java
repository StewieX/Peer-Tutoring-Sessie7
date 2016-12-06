package rekenen;

import rekenen.plugins.Plugin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * PEER TUTORING
 * P2W3
 */
public class Rekenmachine {
    private final int MAX_AANTAL_PLUGINS = 10;
    private Plugin[] ingeladenPlugins;
    private int aantalPlugins;
    private StringBuilder log;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy hh:mm:ss.SSSS");

    public Rekenmachine() {
        this.ingeladenPlugins = new Plugin[MAX_AANTAL_PLUGINS];
        aantalPlugins = 0;
        initLog();
    }

    public void installeer(Plugin teInstallerenPlugin) {
        //Opgave 2.1.a

        // Simpele oplossing:
        boolean isInstalled = false;
        for (int i = 0; i < aantalPlugins; i++) {
            if (ingeladenPlugins[i].getCommand().equals(teInstallerenPlugin.getCommand())) {
                isInstalled = true;
                break;
            }
        }
        if (!isInstalled)
            ingeladenPlugins[aantalPlugins++] = teInstallerenPlugin;

        // Java 8 Streams oplossing:
        /*
        Arrays.stream(ingeladenPlugins) -> maakt van de array een Stream
        .filter(p -> p != null && p.getCommand().equals(teInstallerenPlugin.getCommand())) -> gooi de elementen die null zijn en waarvan het commando niet hetzelfde is weg
        findAny() -> geef mij eender welk element dat de stream overleeft heeft, geencapsuleerd in een Optional (we zijn namelijk niet zeker dat er een is)
        .isPresent() -> is er een element dat de filter overleefd heeft?
        */
//        if (!Arrays.stream(ingeladenPlugins).filter(p -> p != null && p.getCommand().equals(teInstallerenPlugin.getCommand())).findAny().isPresent() && aantalPlugins < MAX_AANTAL_PLUGINS) {
//            ingeladenPlugins[aantalPlugins++] = teInstallerenPlugin;
//        }
    }

    public double bereken(String command, double x, double y) {
        //Opgave 2.1.b
        // Simpele oplossing:
        Plugin plugin = null;
        for (int i = 0; i < aantalPlugins; i++) {
            if(ingeladenPlugins[i].getCommand().equals(command.trim())){
                plugin = ingeladenPlugins[i];
                break;
            }
        }
        if(plugin!= null){
            double result = plugin.bereken(x,y);
            log.append(String.format("\n[%s] %.2f %s %.2f = %.2f (by %s)", dateTimeFormatter.format(LocalDateTime.now()), x, command, y, result, plugin.getAuteur()));
            return result;
        } else {
            System.out.println(String.format("Plugin %s is niet geïnstalleerd.", command));
            return Double.POSITIVE_INFINITY;
        }


        // Java 8 Streams:
//        Optional<Plugin> plugin = Arrays.stream(ingeladenPlugins).filter(p -> p != null && p.getCommand().equals(command.trim())).findAny();
//        if (plugin.isPresent()) {
//            double result = plugin.get().bereken(x, y);
//            log.append(String.format("\n[%s] %.2f %s %.2f = %.2f (by %s)", dateTimeFormatter.format(LocalDateTime.now()), x, command, y, result, plugin.get().getAuteur()));
//            return result;
//        } else {
//            System.out.println(String.format("Plugin %s is niet geïnstalleerd.", command));
//            return Double.POSITIVE_INFINITY;
//        }
    }

    @Override
    public String toString() {
        //Opgave 2.1c
        // Simpele oplossing:
        String result = "Geïnstalleerde Plugins:";
        for (int i = 0; i < aantalPlugins; i++) {
            result += " " + ingeladenPlugins[i].getCommand();
        }
        return result;

        // Java 8 Streams:
        /*
        .map(p -> " " + p.getCommand()) -> maak van elk object in de stream (dus van elke plugin) een nieuw object. Dit object is " " + het commando van de plugin.
        .collect(Collectors.joining("")) -> .collect haalt alle elementen in de stream bij elkaar. Collectors.joining("") plakt al de elementen aan elkaar.
         */
//        return "Geïnstalleerde Plugins:" + Arrays.stream(ingeladenPlugins).filter(p -> p != null).map(p -> " " + p.getCommand()).collect(Collectors.joining(""));
    }

    public String getLog() {
        String result = log.toString();
        initLog();
        return result;
    }

    private void initLog() {
        this.log = new StringBuilder();
        this.log.append("==== LOG ====");
    }
}
