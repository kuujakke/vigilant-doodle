#Tehtävienhallintajärjestelmä
Toteutetaan tehtävienhallintajärjestelmä, jonka avulla pystytään hallinnoimaan projekteihin liittyviä tehtäviä sekä määräämään tehtäville aikarajoja.

##Käyttäjät
Pääkäyttäjä ja Käyttäjä

###Kaikkien käyttäjien yhteisen toiminnot:
* Pystyy kirjautumaan järjestelmään
  * Vain jos tunnus ja salasana ovat oikein.

###Pääkäyttäjän toiminnot:
* Luo Projekteja
* Listaa Käyttäjät
* Lisää projektien johtajiksi käyttäjiä

###Käyttäjän toiminnot:
* Lukee Projektin tietoja
* Lukee Tehtävien tietoja

Jos käyttäjä kuuluu projektin johtajien listaan saa käyttäjä projektijohtajan statuksen. Tässä projektissa Käyttäjä saa käyttöönsä seuraavia toimintoja.

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
