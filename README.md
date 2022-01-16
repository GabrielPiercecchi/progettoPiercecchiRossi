# progettoPiercecchiRossi
##### INTRODUCTION
<div style="text-align: justify">

This file README.md aims to present and explain step by step the development of the exam project of *Object Oriented Programming* for the session of January 24, 2022.

The purpose of this project is to develop a Java application that makes a comparative analysis of statistical data (minimum, maximum, average and variance values of perceived and effective temperature values) concerning the weather information of two cities entered by the user.

// le informazioni inserite dall'utente tramite terminale

(come valore aggiunto si è scelto di permettere l'inserimento tramite richieste HTTP)

The implemented API is <span style="color: #0099FF">**OpenWeather**</span>. The application saves time data in a JSON file.
</div>

##### API

<div style="text-align: justify">
La chiamata all'API di questo progetto presenta la seguente struttura: 

https://api.openweathermap.org/data/2.5/weather?q={city%20name}&appid={API%20key}

* {city%20name} rappresenta il nome della città
* {API%20key} rappresenta il codice necessario ad accedere al servizio OpenWeather

*Esempio*

Richiamando attraverso il metodo *HTTP GET* l'API:

https://api.openweathermap.org/data/2.5/weather?q=roma&appid=1234

si ottengono i seguenti dati sotto formato json

`{
"coord": {
"lon": 12.4839,
"lat": 41.8947
},
"weather": [
{
"id": 800,
"main": "Clear",
"description": "clear sky",
"icon": "01d"
}
],
"base": "stations",
"main": {
"temp": 287,
"feels_like": 285.98,
"temp_min": 284.89,
"temp_max": 289.07,
"pressure": 1024,
"humidity": 59
},
"visibility": 10000,
"wind": {
"speed": 0.51,
"deg": 0
},
"clouds": {
"all": 0
},
"dt": 1642346153,
"sys": {
"type": 2,
"id": 2037790,
"country": "IT",
"sunrise": 1642314890,
"sunset": 1642349055
},
"timezone": 3600,
"id": 6539761,
"name": "Roma",
"cod": 200
}`

Grazie all'utilizzo di quest'api è stato possibile ottenere i dati live necessari per il nostro progetto:

* <code>name</code> nome della città richiesta
* <code>main</code>
    * <code>main.temp</code> temperatura corrente
    * <code>main.feels_like</code> temperatura percepita
    * <code>main.temp_min</code> temperatura minima
    * <code>main.temp_max</code> temperatura massima
</div>

##### RUNNING

<div style="text-align: justify">
Le tre funzionalità principali sono:

* fornire le statistiche singole e comparate delle città inserite dall'utente;
* salvare i dati ottenuti nell'apposito file formato <code>*.json*</code>;
* restituire i dati collezionati in un determinato periodo di tempo scelto dall'utente.

Il meccanismo di funzionamento del programma è il seguente:

1. la classe <code>**Menu**</code>, interfacciandosi con l'utente tramite terminale, raccoglie i dati da lui inseriti (i nomi delle città);

2. il metodo <code>**CityServiceImpl.inputCity(...)**</code>, definito dall'interfaccia <code>**CityService**</code>, utilizza i dati inseriti dall'utente per inviare delle richieste tramite delle chiamate URI, sfruttando l'API OpenWeather, e ricevere "in risposta" le statistiche delle città scelte in formato <code>*.json*</code>;

3. la classe <code>**ParseJSONDocument**</code> effettua il parsing del *JSONObject*, ricevuto dal metodo <code>**CityServiceImpl.inputCity(...)**</code>, e restituisce tramite terminale i dati "parsati".

4. la classe <code>**CreatingJSONDocument**</code> crea, o aggiona, il file <code>*.json*</code> inserendo i valori ottenuti dalla classe descritta al **punto 3**. Esso funge da database di tutte le città, con le corrispettive statistiche, richieste dall'utente;

5. le classi e l'interfaccia contenute nel package <code>**stats**</code> servono per salvare e confrontare i dati ottenuti.

6. infine le classi e l'interfaccia contenute nel package <code>**filters**</code>, tramite una richiesta fatta nell'interfaccia del menù (inserimento di due date), filtrano i dati collezionati.

**NOTE AGGIUNTIVE:** come implementazione aggiuntiva è stata fornita all'utente la possibilità di inserire le città e richiedere le relative statistiche tramite richieste HTTP

</div>

##### EXPLANATION STEP BY STEP

###### ROOT
<div style="text-align: justify">

</div>

##### POSSIBLE APPLICATIONS
I possibili clienti che possono usufruire di quest'applicazione sono tutti quei privati/aziende il cui lavoro è direttamente o indierettamente legato alle condizioni meteo, in particolare alla temperatura.

Alcuni esempi possono essere le imprese agricole, i settori legati al turismo (...impianti sciistici...), e infine settori legati ai cambiamenti climatici (...innalzamento del livello del mare...).

##### AUTHORS

* [Piercecchi Gabriel](https://github.com/GabrielPiercecchi)
* [Rossi Alan](https://github.com/AlanRossi01)



