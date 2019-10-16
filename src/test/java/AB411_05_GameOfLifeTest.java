import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AB411_05_GameOfLifeTest {

    private AB411_05_GameOfLife game;
    private boolean[][] welt;

    @BeforeEach
    public void setUp() {
        game = new AB411_05_GameOfLife();
        welt = game.initWelt();
    }


    @Test
    void initWelt() {
        int counter = 0; //Wie viele lebendige Zellen am Anfang geben soll. Die Zahl befindet sich in der for loop.
        for (boolean[] vector : welt
        ) {
            for (boolean value : vector
            ) {
                if (value) {
                    counter += 1;
                }
            }
        }
        assertEquals(30, counter);
    }

    //Ich habe die Anzahl von lebendigen Zellen zu null gewechselt vor diesem Test damit es funktioniert, aber es funktioniert
    //sowieso nicht wegen die Formatierung
    @Test
    void zeigeWelt() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        game.zeigeWelt(welt);
        assertEquals("------------------------------------------------------\r" +
                "|X|X|X|X|X|X|X|X|X|X|\r" +
                "|X|X|X|X|X|X|X|X|X|X|\r" +
                "|X|X|X|X|X|X|X|X|X|X|\r" +
                "|X|X|X|X|X|X|X|X|X|X|\r" +
                "|X|X|X|X|X|X|X|X|X|X|\r" +
                "|X|X|X|X|X|X|X|X|X|X|\r" +
                "|X|X|X|X|X|X|X|X|X|X|\r" +
                "|X|X|X|X|X|X|X|X|X|X|\r" +
                "|X|X|X|X|X|X|X|X|X|X|\r" +
                "|X|X|X|X|X|X|X|X|X|X|\r" +
                "------------------------------------------------------\r", outContent.toString());
    }

    @Test
    void wendeRegelnAn() {
        welt = new boolean[10][10];
        welt[0][0] = true;
        welt[0][2] = true;
        welt[1][0] = true;
        boolean[][] result = new boolean[10][10];
        result[0][1] = true;
        result[1][1] = true;
        welt = game.wendeRegelnAn(welt);
        assertArrayEquals(result, welt);
    }

    @Test
    void anzahlNachbarn() {
        welt = new boolean[10][10];
        welt[0][0] = true;
        welt[0][2] = true;
        welt[1][0] = true;
        assertEquals(1, game.anzahlNachbarn(welt, 0, 0));
        assertEquals(3, game.anzahlNachbarn(welt, 0, 1));
        assertEquals(0, game.anzahlNachbarn(welt, 2, 2));
    }
}