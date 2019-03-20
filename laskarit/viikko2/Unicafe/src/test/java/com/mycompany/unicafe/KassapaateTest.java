package com.mycompany.unicafe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hanna
 */
public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa  = new Kassapaate();
        kortti = new Maksukortti(450);
    }
    
    @Test
    public void rahaaKassassaAlussa() {
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void alussaEiMyytyjaEdullisiaLounaita() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void alussaEiMyytyjaMaukkaitaLounaita() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiKasitteleeKateismaksunOikein() {
        assertEquals(260, kassa.syoEdullisesti(500));
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void syoEdullisestiKateisellaKasvaaLounaidenMaara() {
        kassa.syoEdullisesti(500);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiKateisellaEiTeeMitaanKunRahaEiRiita() {
        int takaisin = kassa.syoEdullisesti(200);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(200, takaisin);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiKasitteleeKateismaksunOikein() {
        assertEquals(100, kassa.syoMaukkaasti(500));
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void syoMaukkaastiKateisellaKasvaaLounaidenMaara() {
        kassa.syoMaukkaasti(500);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiKateisellaEiTeeMitaanKunRahaEiRiita() {
        int takaisin = kassa.syoMaukkaasti(200);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(200, takaisin);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiKasitteleeKorttimaksunOikein() {
        assertEquals(true, kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void syoEdullisestiKortillaKasvaaLounaidenMaara() {
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiKortillaEiTeeMitaanKunRahaEiRiita() {
        kassa.syoEdullisesti(kortti);
        assertEquals(false, kassa.syoEdullisesti(kortti));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiKortillaEiKasvaaKassanSaldoa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
        
    }
    
    @Test
    public void syoMaukkaastiKasitteleeKorttimaksunOikein() {
        assertEquals(true, kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void syoMaukkaastiKortillaKasvaaLounaidenMaara() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiKortillaEiTeeMitaanKunRahaEiRiita() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(false, kassa.syoMaukkaasti(kortti));
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiKortillaEiKasvaaKassanSaldoa() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
        
    }
    
    @Test
    public void kortinLataaminenToimiiOikein() {
        kassa.lataaRahaaKortille(kortti, 500);
        assertEquals(950, kortti.saldo());
        assertEquals(100500, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortilleEiVoiLataaNegatiivisiaArvoja() {
        kassa.lataaRahaaKortille(kortti, -10);
        assertEquals(450, kortti.saldo());
        assertEquals(100000, kassa.kassassaRahaa());
    }
}
