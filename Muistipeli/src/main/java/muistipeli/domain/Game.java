/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.domain;

import java.util.Random;

/**
 *
 * @author hanna
 */
/**
* Luokka vastaa pelin toteuksesta.
*
*/
public class Game {
    private int[] numbers = new int[20];
    
    public Game() {
        Random r = new Random();
        
        for (int i = 0; i < 20; i++) {
            numbers[i] = r.nextInt(10);
        }
    }
    
    /**
    * Metodi hakee numerosarjasta numeron parametrina annetulta paikalta.
    *
    * @param   i   indeksi
    * 
    * @return löydetty numero
    */
    public int getNumber(int i) {
        return numbers[i];
    }        
    
    /**
    * Metodi tarkistaa ensin että onko vastaus tyhjä. Jos ei, niin käydään 
    * läpi kaikki numerot ja tarkistetaan että ovatko ne oikein.
    *
    * @param   n        tarkistettavien numeroiden lukumäärä
    * @param   answer   vastaus, tarkistettavat numerot
    * 
    * @return true jos kaikki numerot olivat oikein, muuten false
    */
    public boolean checkNumberSeries(int n, String answer) {
        if (answer.length() != n) {
            return false;
        }
        String[] pieces = answer.split("");
        for (int i = 0; i < n; i++) {
            if (Integer.valueOf(pieces[i]) != numbers[i]) {
                return false;
            }
        }
        
        return true;
    }
    
}
