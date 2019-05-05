# Muistipeli

Sovelluksen avulla käyttäjä voi testata lähimuistinsa yrittämällä muistaa niin pitkiä numerosarjoja kuin mahdollista. Sovellukseen täytyy rekisteröityä niin että tulokset voidaan tallentaa.

## Dokumentaatio

[Käyttöohje](https://github.com/Hanna432/ot_harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/Hanna432/ot_harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/Hanna432/ot_harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/Hanna432/ot_harjoitustyo/blob/master/dokumentaatio/testausdokumentti.md)

[Työaikakirjanpito](https://github.com/Hanna432/ot_harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

## Releaset

[Viikko 5](https://github.com/Hanna432/ot_harjoitustyo/releases)

[Viikko 6](https://github.com/Hanna432/ot_harjoitustyo/releases/tag/viikko6)

[Loppupalautus](https://github.com/Hanna432/ot_harjoitustyo/releases/tag/viikko7)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

`mvn test`

Testikattavuusraportti luodaan komennolla

`mvn jacoco:report`

### Jarin generointi

Jar-tiedosto generoidaan komennolla

`mvn package`

Suoritettava jar-tiedosto löytyy hakemistista target nimellä Muistipeli-1.0-SNAPSHOT.jar

### JavaDoc

JavaDoc generoidaan komennolla

`mvn javadoc:javadoc`

ja sitä voidaan tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html

### Checkstyle

Checkstyleraportti luodaan komennolla

`mvn jxr:jxr checkstyle:checkstyle`

ja sen voi tarkastella avaamalla selaimella tiedosto target/site/checkstyle.html
