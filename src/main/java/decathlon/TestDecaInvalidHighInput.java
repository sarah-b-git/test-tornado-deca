package decathlon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestDecaInvalidHighInput {
    @Test
    public void testDeca100M() {
        Deca100M deca100M = new Deca100M();
        double runningTime = 25.0;
        try {
            deca100M.calculateResult(runningTime);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too high", e.getMessage());
        }

    }

    @Test
    public void testDeca110MHurdles() {
        Deca110MHurdles deca110MHurdles = new Deca110MHurdles();
        double runningTime = 35.0;
        try {
            deca110MHurdles.calculateResult(runningTime);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too high", e.getMessage());
        }
    }
    @Test
    public void testDeca400M()  {
        Deca400M deca400M = new Deca400M();
        double runningTime = 150.0;
        try {
            deca400M.calculateResult(runningTime);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too high", e.getMessage());
        }}
        @Test
        public void testDeca1500M() {
            Deca1500M deca1500M = new Deca1500M();
            double runningTime = 450;
            try {
                deca1500M.calculateResult(runningTime);
                fail("Expected InvalidResultException to be thrown");
            } catch (InvalidResultException e) {
                assertEquals("Value too high", e.getMessage());
            }}
    @Test
    public void testDecaLongJump()  {
        DecaLongJump decaLongJump = new DecaLongJump();
        double distance = 1100;
        try {
            decaLongJump.calculateResult(distance);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too high", e.getMessage());
        }}
    @Test
    public void testDecaShotPut() {
        DecaShotPut decaShotPut = new DecaShotPut();
        double distance = 35;
        try {
            decaShotPut.calculateResult(distance);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too high", e.getMessage());
        }}
    @Test
    public void testDecaDiscusThrow() {
        DecaDiscusThrow decaDiscusThrow = new DecaDiscusThrow();
        double distance = 90;
        try {
            decaDiscusThrow.calculateResult(distance);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too high", e.getMessage());
        }}
    @Test
    public void testDecaPoleVault() {
        DecaPoleVault decaPoleVault = new DecaPoleVault();
        double height = 1500;
        try {
            decaPoleVault.calculateResult(height);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too high", e.getMessage());
        }}
    @Test
    public void testDecaHighJump()  {
        DecaHighJump decaHighJump = new DecaHighJump();
        double height = 350;
        try {
            decaHighJump.calculateResult(height);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too high", e.getMessage());
        }}
    @Test
    public void testDecaJavelinThrow()  {
        DecaJavelinThrow decaJavelinThrow = new DecaJavelinThrow();
        double distance = 150;
        try {
            decaJavelinThrow.calculateResult(distance);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too high", e.getMessage());
        }}
}
