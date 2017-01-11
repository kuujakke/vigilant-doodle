#Schemes
Abstrakti luokka jonka jokainen projekti, tehtävä ja työtehtävä perii. Sisältää perustoiminnallisuuden ja ylläpitää tilaa.
 
* ##Project
Projekti luokka, joka ylläpitää yhden projektin tehtäviä ja jäseniä.

* ##Task
Tehtävä luokka, jonka tarkoituksena on hallinnoida työntekijöitä ja jakaa työtehtäviä tekijöille.
Tehtävällä on yksi valvoja, jolla on oikeus määrätä työtehtäviä.

* ##Job
Työtehtävä luokka, sisältää tilan ja työtehtävälle määrätyn työntekijän.

#Roles
Abstrakti luokka, jonka jokainen jäsen ja työntekijä perii. Sisältää roolin perustoiminnallisuudet.

* ##ProjectRoles

.. * ###Member
Projektiin kuuluva jäsen, jolla perustoiminnallisuus projektissa.

.. * ###Leader
Projektiin kuuluva johtaja, joka perii jäsenen perustoiminnallisuuden ja pystyy hallinnoimaan projektia ja sen käyttäjiä.

* ##TaskRoles

.. * ###Worker
Tehtävään kuuluva työntekijä, jolla on perustoiminnallisuus tehtävässä.

.. * ###Supervisor
Tehtävän valvoja, joka perii työntekijän perustoiminnallisuuden ja pystyy hallinnoimaan tehtävään liittyviä työtehtäviä.
 
#Status
Skeeman tila. Ylläpitää aikaleimoja, joilla voidaan laskea esim. jäljellä oleva aika ennen deadlinea.
