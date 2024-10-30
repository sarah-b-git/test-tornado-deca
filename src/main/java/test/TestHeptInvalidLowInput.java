package test;

import decathlon.InvalidResultException;
import heptathlon.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestHeptInvalidLowInput {

    @Test
    public void testHep100MHurdles() {
        Hep100MHurdles hep100MHurdles = new Hep100MHurdles();
        double runningTime = 5.0;
        try {
            hep100MHurdles.calculateResult(runningTime);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too low", e.getMessage());
        }}

    @Test
    public void testHep200M()  {
        Hep200M hep200M = new Hep200M();
        double runningTime = 15.0;
        try {
            hep200M.calculateResult(runningTime);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too low", e.getMessage());
        }}

    @Test
    public void testHep800M() {
        Hep800M hep800M = new Hep800M();
        double runningTime = 65.0;
        try {
            hep800M.calculateResult(runningTime);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too low", e.getMessage());
        }}

    @Test
    public void testHepHighJump() {
        HeptHighJump hepHighJump = new HeptHighJump();
        double height = -1.0;
        try {
            hepHighJump.calculateResult(height);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too low", e.getMessage());
        }}

    @Test
    public void testHepLongJump() {
        HeptLongJump hepLongJump = new HeptLongJump();
        double distance = -1;
        try {
            hepLongJump.calculateResult(distance);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too low", e.getMessage());
        }}

    @Test
    public void testHepShotPut(){
        HeptShotPut hepShotPut = new HeptShotPut();
        double distance = -1;
        try {
            hepShotPut.calculateResult(distance);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too low", e.getMessage());
        }}

    @Test
    public void testHepJavelinThrow()  {
        HeptJavelinThrow hepJavelinThrow = new HeptJavelinThrow();
        double distance = -1.0;
        try {
            hepJavelinThrow.calculateResult(distance);
            fail("Expected InvalidResultException to be thrown");
        } catch (InvalidResultException e) {
            assertEquals("Value too low", e.getMessage());
        }}}
