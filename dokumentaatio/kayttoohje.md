# Käyttöohje

Lataa tiedosto [muistipeli.jar](https://github.com/Hanna432/ot_harjoitustyo/releases/tag/viikko7)

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla

`java -jar muistipeli.jar`

## Kirjautuminen

Sovellus käynnistyy kirjautumisnäkymään.

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/kirjautumisnakyma.png)

Kirjautuminen onnistuu kun syötetään olemassaoleva käyttäjätunnus ja siihen kuuluva salasana ja painetaan Log in. 
On myös mahdollista jatkaa kirjautumatta painamalla "Play as a guest".

## Rekisteröityminen

Kun kirjautumisnäkymässä painetaan Register-nappia niin siirretään toiseen näkymään missä on mahdollista luoda uusi käyttäjä.

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/rekisteroityminen.png)

Rekisteröityminen onnistuu kun syötetään käyttäjätunnus joka ei vielä ole olemassa.

## Kirjautumisen jälkeen

Kun painetaan nappia "Log in" niin siirretään toiseen näkymään missä on mahdollista käynnistää pelin tai kirjautua ulos. Kun kirjaudutaan ulos siirretään takaisin kirjautumisnäkymään.

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/kirjautumisenjalkeen.png)

Jos kirjautumisnäkymässä painetaan nappia "Play as a guest" "Log in"-napin sijaan niin siirretään samaan näkymään mutta nyt käyttäjätunnus, asetukset ja tietoa omasta parasta tuloksesta puuttuu.

## Pelin pelaaminen

Kun painetaan nappia Play siirretään pelinäkymään.

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/pelinakyma.png)

Peli pelataan niin että vastauskentän yläpuolella ilmestyy muutama lukua mutta vain yksi luku kerrallaan näkyy. Tämän jälkeen käyttäjän tehtävä on syötä luvut oikeassa järjestyksessä ilman välilyöntejä tai muuta sellaista vastauskenttään ja sitten painaa nappia Done. Jos numerot ovat oikein niin sama numerosarja esiintyy uudestaan mutta nyt sarja on vähän pitempi. Näin peli jatkuu kunnes käyttäjä syöttää väärää numeroa. Pelin jälkeen siirretään takaisin käyttäjän omalle sivulle.

## Asetukset

Jos kirjautumisen jälkeen painetaan nappia Settings niin siirretään näkymään missä on mahdollista vaihtaa salasanansa ja poistaa käyttäjäprofiilinsa.

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/asetusnakyma.png)

Kun painetaan nappia "Delete profile" käyttäjäprofiili poistetaan ja siirretään takaisin kirjautumisnäkymään. Kun painetaan nappia "Change password" sirretään näkymään missä voidaan syöttää uusi salasana.

![kuva](https://github.com/Hanna432/ot_harjoitustyo/blob/master/laskarit/kuvat/salasanavaihto.png)

Kun siellä painetaan "Change password"-nappia salasana vaihdetaan ja siirretään takaisin asetusnäkymään.
