package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlsussaOikein() {
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void lataaRahaaToimiiOikein() {
        kortti.lataaRahaa(100);
        assertEquals("saldo: 1.10", kortti.toString());
    }
    
    @Test
    public void rahanOttaminenToimiiJosRahaaRiita() {
        kortti.otaRahaa(9);
        assertEquals("saldo: 0.1", kortti.toString());
    }
    
    @Test
    public void otaRahaaEiOnnistuJosRahaaEiRiita() {
        kortti.otaRahaa(100);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void otaRahaaPalauttaaTrueKunPitaisi() {
        assertEquals(true, kortti.otaRahaa(5));
    }
    
    @Test
    public void otaRahaaPalauttaaFalseKunPitaisi() {
        assertEquals(false, kortti.otaRahaa(20));
    }
}
