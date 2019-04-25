# Arkkitehtuurikuvaus

## Rakenne

Koodin pakkausrakenne on seuraava:

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/pakkausrakenne.jpg)

Pakkaus muistipeli.ui sisältää ohjelman graafisen toteutuksen, eli sekä käyttöliittymä UI että pelin graafinen toteutus GameScene. Pakkaus muistipeli.domain sisältää kaikki sovelluslogiikan luokat ja muistipeli.dao sisältää pysyväistallennukseen tarvittavan koodin.

## Käyttöliittymä

Käyttöliittymä koostuu neljästä eri näkymästä:

- kirjautuminen
- rekisteröityminen
- näkymä kirjautumisen jälkeen
- peli

Näkymät ovat toteutettuja scene-olioina. Pelin näkymä on toteutettu luokassa muistipeli.ui.GameScene ja muut näkymät ovat toteutettuja luokassa muistipeli.ui.UI.

## Sovelluslogiikka

Luokka muistipeli.domain.Service tarjoaa erilaisia toiminnallisuuksia käyttöliittymälle liittyen sovelluksen käyttäjiä. Pelin toiminnallisuuksista vastaa luokka muistipeli.domain.Game joka kutsutaan suoraan graafisesta luokasta muistipeli.ui.GameScene.

Service-luokka pääsee käsiksi tietokannassa sijaitseviin käyttäjiin luokan muistipeli.dao.UserDao kautta.

Seuraava luokka/pakkauskaavio kuvaa ohjelman eri osien suhdetta:

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/luokkakaavio.jpg)

## Tietojen pysyväistallennus

## Päätoiminnallisuudet

### Kirjaantuminen

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/kirjautuminen.jpg)

### Rekisteröityminen

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/rekisteroituminen.jpg)
