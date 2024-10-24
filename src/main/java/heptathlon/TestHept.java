package heptathlon;

import decathlon.InvalidResultException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import heptathlon.Hep100MHurdles;
import heptathlon.Hep200M;
import heptathlon.Hep800M;
import heptathlon.HeptHighJump;
import heptathlon.HeptJavelinThrow;
import heptathlon.HeptLongJump;
import heptathlon.HeptShotPut;

public class TestHept {

    @Test
    public void testHep100MHurdles() throws InvalidResultException {
        Hep100MHurdles hep100MHurdles = new Hep100MHurdles();
        double runningTime = 15.0;
        int expectedScore = 842;
        int actualScore = hep100MHurdles.calculateResult(runningTime);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testHep200M() throws InvalidResultException {
        Hep200M hep200M = new Hep200M();
        double runningTime = 25.0;
        int expectedScore = 887;
        int actualScore = hep200M.calculateResult(runningTime);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testHep800M() throws InvalidResultException{
        Hep800M hep800M = new Hep800M();
        double runningTime = 140.0;
        int expectedScore = 824;
        int actualScore = hep800M.calculateResult(runningTime);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testHepHighJump()throws InvalidResultException {
        HeptHighJump hepHighJump = new HeptHighJump();
        double height = 185.0;
        int expectedScore = 1041;
        int actualScore = hepHighJump.calculateResult(height);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testHepLongJump() throws InvalidResultException {
        HeptLongJump hepLongJump = new HeptLongJump();
        double distance = 650;
        int expectedScore = 1007;
        int actualScore = hepLongJump.calculateResult(distance);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testHepShotPut()throws InvalidResultException {
        HeptShotPut hepShotPut = new HeptShotPut();
        double distance = 15.0;
        int expectedScore = 861;
        int actualScore = hepShotPut.calculateResult(distance);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testHepJavelinThrow() throws InvalidResultException {
        HeptJavelinThrow hepJavelinThrow = new HeptJavelinThrow();
        double distance = 55.0;
        int expectedScore = 957;
        int actualScore = hepJavelinThrow.calculateResult(distance);
        assertEquals(expectedScore, actualScore);
    }
}
