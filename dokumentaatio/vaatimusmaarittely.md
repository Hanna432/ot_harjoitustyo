# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla käyttäjä voi testata lähimuistinsa yrittämällä muistaa 
niin pitkiä numerosarjoja kuin mahdollista. Sovellukseen täytyy 
rekisteröityä niin että tulokset voidaan tallentaa.

## Käyttöliittymäluonnos

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/sovelluskuva.jpg)

## Perusversion toiminnallisuus

### Ennen kirjautumista

* käyttäjä voi rekisteröityä järjestelmään
  * siihen tarvitaan käyttäjätunnus
* käyttäjä voi kirjautua sisään

### Kirjautumisen jälkeen

* käyttäjä voi pelata pelin
  * peli pelataan niin että näytössä näkee yksi luku kerrallaan lyhyistä 
numerosarjasta ja pelaajan tehtävä on sitten toistaa numerosarjan. Sen 
jälkeen sama numerosarja esintyy taas näytössa luku kerrallaan mutta nyt
sarjan loppuun on ilmestynyt uusi luku. Näin sarja tulee koko ajan pitempi. 
Peli loppuu kun pelaaja painaa väärä numeroa.
* käyttäjä voi nähdä tilastoja
  * oma paras tulos
  * paras tulos kaikkien käyttäjien joukossa
* käyttäjä voi kirjautua ulos

## Jatkokehitysideoita

Kun perusversio on toteutettu se voidaan täydentää seuraavalla 
toiminnallisuuksilla:

* kirjautumiseen tarvitaan myös salasana
* mahdollisuus pelata myös kirjautumatta
* erilaisia muistipelejä
* mahdollisuus vaihtaa käyttöliittymän kieltä
* enemmän tilastoja
  * lista parhaista käyttäjistä ja heidän tuloksista
  * tietoa siitä kuinka hyvin käyttäjä pärjää verrattuna kaikkien käyttäjien 
keskiarvoa
* käyttäjätunnuksen poisto
