Progetto Giugno 2017 - Sistemi Informativi su Web

<a href= "https://github.com/TizianoRefice/ProgettoSIW2017-Funzionante/blob/master/progetto-siw/Casi%20d'uso.txt"> Casi d'uso </a>

<a href= "https://github.com/TizianoRefice/ProgettoSIW2017-Funzionante/blob/master/progetto-siw/Class%20Diagram.jpeg"> Class Diagram </a>

Schema base di dati(in <strong>grassetto</strong> la chiave):

<ul>
  <li> Autore(<strong>id</strong>, nome, cognome, nazionalita, dataNascita, dataMorte) </li>
  <li> Opera(<strong>id</strong>, titolo, anno, tecnica, lunghezza, larghezza, sito, autore_id) </li>
</ul>
con vincolo di integrità referenziale tra <i>id</i>(di Autore) e <i>autore_id</i>

