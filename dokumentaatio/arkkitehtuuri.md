# Arkkitehtuurikuvaus

## Rakenne

Koodin pakkausrakenne on seuraava:

![kuva]

Pakkaus muistipeli.ui sisältää ohjelman graafisen toteutuksen, eli sekä käyttöliittymä UI että pelin graafinen toteutus GameScene. Pakkaus muistipeli.domain sisältää kaikki sovelluslogiikan luokat ja muistipeli.dao sisältää pysyväistallennukseen tarvittavan koodin.

## Käyttöliittymä

Käyttöliittymä koostuu neljästä eri näkymästä:

- kirjautuminen
- rekisteröityminen
- näkymä kirjautumisen jälkeen
- peli

Näkymät ovat toteutettuja scene-olioina. Pelin näkymä on toteutettu luokassa muistipeli.ui.GameScene ja muut näkymät ovat toteutettuja luokassa muistipeli.ui.UI.

## Sovelluslogiikka

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/luokkakaavio.jpg)

## Tietojen pysyväistallennus

## Päätoiminnallisuudet

### Kirjaantuminen

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/logIn.jpg)

### Rekisteröityminen

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/register.jpg)
