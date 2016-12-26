#Tehtävienhallintajärjestelmä
Toteutetaan tehtävienhallintajärjestelmä, jonka avulla pystytään hallinnoimaan projekteihin liittyviä tehtäviä sekä määräämään tehtäville aikarajoja.

##Käyttäjät

###Pääkäyttäjä ja Käyttäjä

* Pystyy kirjautumaan järjestelmään
  * Vain jos tunnus ja salasana ovat oikein.

##Toiminnot

###Kaikkien käyttäjien yhteisen toiminnot:

* Listaa kaikki projektit.
* Liity projektiin.
* Luo projekti.
* Tulosta projektin tiedot.

###Pääkäyttäjällä on lisäksi toiminnot:

* Listaa kaikki käyttäjät.
* Lisää käyttäjiä.
* Poista käyttäjiä.
* Poista projekteja.

##Käyttäjien roolit:

Jos käyttäjä lisätään projektin johtajien listaan saa käyttäjä projektijohtajan roolin. Tässä projektissa Käyttäjä saa käyttöönsä seuraavia toimintoja.

####Projektijohtajan toiminnot:
* Lisää tehtäviä projektiin.
* Asettaa Käyttäjiä vastuuseen tehtävistä.
* Asettaa Projektille deadlinen.
* Asettaa Projektin statuksen.
* Listaa Käyttäjät
* Lisää käyttäjiä projektiin.

Kun Käyttäjä on saanut vastuulleen tehtävän saa käyttäjä Tehtävänjohtajan statuksen ja saa ko. Tehtävän suhteen tiettyjä toimintoja:

####Tehtävänjohtajan toiminnot:
* Lisää vaiheita tehtävään.
* Asettaa tehtävän statuksen.
