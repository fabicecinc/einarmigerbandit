import java.util.Random;
import java.util.Scanner;

public class einarmigerbandit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random zufall = new Random();

        String[] symbols = {"Kirsche", "Zitrone", "Orange", "Sieben", "Glocke"};
        int guthaben = 123; //ändern, dass man selbst eingeben kann
        
        System.out.println("Ihr Startguthaben beträgt " + guthaben );
        
        while (true) { 
            System.out.println("Spielen?");
            String auswahl = scanner.nextLine();

            if (auswahl.equalsIgnoreCase("nein")) {
                System.out.println("Gegrüßt sei der Philip! Dein Guthaben beträgt: " + guthaben + " Jetons.");
                break;
            } 

            else if (!auswahl.equalsIgnoreCase("ja")) {
                System.out.println("Ungültige Eingabe");
                continue;
            }

            if (guthaben <= 0) {
                System.out.println("Du bist pleite");
                break;
            }

            System.out.println("Einsatz eingeben(maximal " + guthaben + "Jetons): ");
            int einsatz = scanner.nextInt();

            if(einsatz > guthaben || einsatz <= 0) {
                System.out.println("Dein Einsatz ist ungütlig. Nochmal versuchen.");
                continue;
            }

            String symbol1 = symbols[zufall.nextInt(symbols.length)];
            String symbol2 = symbols[zufall.nextInt(symbols.length)];
            String symbol3 = symbols[zufall.nextInt(symbols.length)];

            System.out.println("Die Slots zeigen: " + symbol1 + " | " + symbol2 + " | " + symbol3);

            if (symbol1.equals(symbol2) && symbol2.equals(symbol3)) {
                int gewinn = einsatz * 20;
                guthaben += gewinn;
                System.out.println("CinC Jackpot! Du hast " + gewinn + " Jetons gewonnen.");
            }
            
            else if (symbol1.equals(symbol2) || symbol2.equals(symbol3) || symbol1.equals(symbol3)) {
                int gewinn = einsatz * 2;
                guthaben += gewinn;
                System.out.println("Sie haben " + gewinn + " Jetons gewonnen.");
            }

            else {
                guthaben -= einsatz;
                System.out.println("Du hast verloren. Dein Guthaben beträgt jetzt: " + guthaben + " Jetons");
            }
        }
        scanner.close();
    }
}