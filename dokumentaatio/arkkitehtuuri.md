# Arkkitehtuurikuvaus

## Rakenne

Koodin pakkausrakenne on seuraava:

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/pakkausrakenne.jpg)

Pakkaus muistipeli.ui sisältää ohjelman graafisen toteutuksen, eli sekä käyttöliittymä UI että pelin graafinen toteutus GameScene. Pakkaus muistipeli.domain sisältää kaikki sovelluslogiikan luokat ja muistipeli.dao sisältää pysyväistallennukseen tarvittavan koodin.

## Käyttöliittymä

Käyttöliittymä koostuu kuudesta eri näkymästä:

- kirjautuminen
- rekisteröityminen
- näkymä kirjautumisen jälkeen
- peli
- asetukset
- salasanan vaihtaminen

Näkymät ovat toteutettuja scene-olioina. Pelin näkymä on toteutettu luokassa muistipeli.ui.GameScene ja muut näkymät ovat toteutettuja luokassa muistipeli.ui.UI.

## Sovelluslogiikka

Luokka muistipeli.domain.Service tarjoaa erilaisia toiminnallisuuksia käyttöliittymälle liittyen sovelluksen käyttäjiä. Pelin toiminnallisuuksista vastaa luokka muistipeli.domain.Game joka kutsutaan suoraan graafisesta luokasta muistipeli.ui.GameScene.

Service-luokka pääsee käsiksi tietokannassa sijaitseviin käyttäjiin luokan muistipeli.dao.UserDao kautta.

Seuraava luokka/pakkauskaavio kuvaa ohjelman eri osien suhdetta:

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/luokkakaavio.jpg)

## Tietojen pysyväistallennus

Tieto käyttäjistä tallennetaan tietokantaan luokan UserDao avulla. Tieto tallennetaan seuraavaan 
tietokantatauluun:

User (username, password, highscore)

## Päätoiminnallisuudet

### Kirjaantuminen

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/kirjautuminen.jpg)

### Rekisteröityminen

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/rekisteroituminen.jpg)

## Ohjelman rakenteeseen jääneet heikkoudet

Melkein koko käyttöliittymä on toteutettu luokassa UI. Olisi ollut parempi jakaa UI-luokka eri luokkiin 
niin että jokaisella luokalla olisi selkeä vastuualue.
