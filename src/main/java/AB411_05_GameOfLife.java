import java.util.Random;
import java.util.Scanner;

public class AB411_05_GameOfLife {

    // Global definierte Konstanten für die beiden Dimensionen
    private final static int DIM1 = 10;
    private final static int DIM2 = 10;

    // Liefert eine zufällig initialisierte Welt
    public boolean[][] initWelt() {
        boolean[][] welt = new boolean[DIM1][DIM2];
        Random random = new Random();
        for (int i = 0; i < 100; i++) { //Wie viele lebendige Zellen am Anfang gibt
            int x = random.nextInt(DIM1);
            int y = random.nextInt(DIM2);
            if (!welt[y][x]) {
                welt[y][x] = true;
            }
            else{
                i--;
            }
        }
        return welt;
    }

    // Gibt die aktuelle Welt aus
    public void zeigeWelt(boolean[][] welt) {
        System.out.println("------------------------------------------------------");
        for (boolean[] vector : welt
        ) {
            for (boolean value : vector
            ) {
                if (value) {
                    System.out.print("|X");
                } else {
                    System.out.print("| ");
                }
            }
            System.out.println("|");
        }
        System.out.println("------------------------------------------------------");
    }

    // Wendet die 4 Regeln an und gibt die Folgegeneration wieder zurück
    public boolean[][] wendeRegelnAn(boolean[][] welt) {
        int x = 0;
        int y = 0;
        boolean[][] neuwelt = new boolean[DIM1][DIM2];
        for (boolean[] vector : welt
        ) {
            for (boolean value : vector
            ) {
                int anzahlNachbarn = anzahlNachbarn(welt, x, y);
                if (value) {
                    if (anzahlNachbarn < 2) {
                        neuwelt[x][y] = false;
                    } else {
                        neuwelt[x][y] = anzahlNachbarn <= 3;
                    }
                } else {
                    if (anzahlNachbarn == 3) {
                        neuwelt[x][y] = true;
                    }
                    else{
                        neuwelt[x][y] = false;
                    }
                }
                y += 1;
            }
            x += 1;
            y = 0;
        }
        return neuwelt;
    }

    // Liefert Anzahl Nachbarn einer Zelle
    public int anzahlNachbarn(boolean[][] welt, int x, int y) {
        int returnValue = 0;
        for (int i = x - 1; i <= x + 1; ++i)
            for (int j = y - 1; j <= y + 1; ++j)
                if (i < 0 || j < 0) {
                } else if (i >= DIM1 || j >= DIM2) {
                } else if (welt[i][j]) {
                    returnValue += 1;
                }
        // einen Nachbarn zuviel mitgezählt?
        if (welt[x][y]) {
            returnValue -= 1;
        }
        return returnValue;
    }

    public static void main(String[] args) {

        AB411_05_GameOfLife game = new AB411_05_GameOfLife();

        // Welt initialisieren
        boolean[][] welt = game.initWelt();

        System.out.println("Startkonstellation");
        game.zeigeWelt(welt);

        for (int i = 1; i <= 100; i++) {
            welt = game.wendeRegelnAn(welt);
            System.out.println("Generation " + i);
            game.zeigeWelt(welt);
        }
    }
}