package test;

import decathlon.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestDecaInvalidLowInput {
    @Test
    public void testDeca100M() {
        Deca100M deca100M = new Deca100M();
        double runningTime = 4.0;
        try {
            deca100M.calculateResult(runningTime);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too low", e.getMessage());
        }

    }

    @Test
    public void testDeca110MHurdles() {
        Deca110MHurdles deca110MHurdles = new Deca110MHurdles();
        double runningTime = 9.0;
        try {
            deca110MHurdles.calculateResult(runningTime);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too low", e.getMessage());
        }
    }
    @Test
    public void testDeca400M()  {
        Deca400M deca400M = new Deca400M();
        double runningTime = 10.0;
        try {
            deca400M.calculateResult(runningTime);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too low", e.getMessage());
        }}
        @Test
        public void testDeca1500M() {
            Deca1500M deca1500M = new Deca1500M();
            double runningTime = 100;
            try {
                deca1500M.calculateResult(runningTime);
                fail("Expected InvalidResultException to be thrown");
            } catch (InvalidResultException e) {
                assertEquals("Value too low", e.getMessage());
            }}
    @Test
    public void testDecaLongJump()  {
        DecaLongJump decaLongJump = new DecaLongJump();
        double distance = -1;
        try {
            decaLongJump.calculateResult(distance);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too low", e.getMessage());
        }}
    @Test
    public void testDecaShotPut() {
        DecaShotPut decaShotPut = new DecaShotPut();
        double distance = -1;
        try {
            decaShotPut.calculateResult(distance);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too low", e.getMessage());
        }}
    @Test
    public void testDecaDiscusThrow() {
        DecaDiscusThrow decaDiscusThrow = new DecaDiscusThrow();
        double distance = -1;
        try {
            decaDiscusThrow.calculateResult(distance);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too low", e.getMessage());
        }}
    @Test
    public void testDecaPoleVault() {
        DecaPoleVault decaPoleVault = new DecaPoleVault();
        double height = -1;
        try {
            decaPoleVault.calculateResult(height);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too low", e.getMessage());
        }}
    @Test
    public void testDecaHighJump()  {
        DecaHighJump decaHighJump = new DecaHighJump();
        double height = -1;
        try {
            decaHighJump.calculateResult(height);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too low", e.getMessage());
        }}
    @Test
    public void testDecaJavelinThrow()  {
        DecaJavelinThrow decaJavelinThrow = new DecaJavelinThrow();
        double distance = -1;
        try {
            decaJavelinThrow.calculateResult(distance);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too low", e.getMessage());
        }}
}
