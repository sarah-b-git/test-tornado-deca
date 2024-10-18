package decathlon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import decathlon.Deca100M;
import decathlon.DecaDiscusThrow;
import decathlon.DecaJavelinThrow;
import decathlon.DecaLongJump;
import decathlon.DecaPoleVault;
import decathlon.Deca110MHurdles;
import decathlon.Deca400M;
import decathlon.Deca1500M;
import decathlon.DecaHighJump;
import decathlon.DecaShotPut;

public class TestDeca {

    @Test
    public void testDeca100M() {
        Deca100M deca100M = new Deca100M();
        double runningTime = 10.0;
        int expectedScore = 1096;
        int actualScore = deca100M.calculateResult(runningTime);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testDeca110MHurdles() {
        Deca110MHurdles deca110MHurdles = new Deca110MHurdles();
        double runningTime = 15.0;
        int expectedScore = 850;
        int actualScore = deca110MHurdles.calculateResult(runningTime);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testDeca400M() {
        Deca400M deca400M = new Deca400M();
        double runningTime = 50.0;
        int expectedScore = 815;
        int actualScore = deca400M.calculateResult(runningTime);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testDeca1500M() {
        Deca1500M deca1500M = new Deca1500M();
        double runningTime = 240;
        int expectedScore = 953;
        int actualScore = deca1500M.calculateResult(runningTime);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testDecaLongJump() {
        DecaLongJump decaLongJump = new DecaLongJump();
        double distance = 700;
        int expectedScore = 814;
        int actualScore = decaLongJump.calculateResult(distance);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testDecaShotPut() {
        DecaShotPut decaShotPut = new DecaShotPut();
        double distance = 15.0;
        int expectedScore = 790;
        int actualScore = decaShotPut.calculateResult(distance);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testDecaDiscusThrow() {
        DecaDiscusThrow decaDiscusThrow = new DecaDiscusThrow();
        double distance = 45.0;
        int expectedScore = 767;
        int actualScore = decaDiscusThrow.calculateResult(distance);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testDecaPoleVault() {
        DecaPoleVault decaPoleVault = new DecaPoleVault();
        double height = 500;
        int expectedScore = 910;
        int actualScore = decaPoleVault.calculateResult(height);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testDecaHighJump() {
        DecaHighJump decaHighJump = new DecaHighJump();
        double height = 200;
        int expectedScore = 803;
        int actualScore = decaHighJump.calculateResult(height);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testDecaJavelinThrow() {
        DecaJavelinThrow decaJavelinThrow = new DecaJavelinThrow();
        double distance = 65.0;
        int expectedScore = 813;
        int actualScore = decaJavelinThrow.calculateResult(distance);
        assertEquals(expectedScore, actualScore);
    }
}
