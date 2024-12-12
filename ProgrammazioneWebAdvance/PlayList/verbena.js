//const deepCopy = JSON.parse(JSON.stringify(playlist));

/*
creare una funzione che realizzi la riproduzione casuale: a ogni chiamata restituisce titolo e autore una canzone della playlist a caso,
con la frase
now playing: {titolo} by {artista}
*/

/*function riproduzioneCasuale() {
  // Genera un numero casuale tra 0 e la lunghezza della playlist
  const index = Math.floor(Math.random() * playlist.length);

  // Ottieni la canzone corrispondente all'indice generato casualmente
  const canzoneCasuale = playlist[index];

  // Restituisci la frase con il titolo e l'artista della canzone casuale
  return Now playing: ${canzoneCasuale.titolo} by ${canzoneCasuale.artista};
}

console.log(riproduzioneCasuale());
console.log(playlist);*/

/*2) migliorare la funzione di riproduzione casuale,
facendo in modo che la canzone appena ascoltata non possa più essere selezionata.

in console: rimossa la canzone {titolo} by {artista} dalla playlist.


3) Costruire un form con due campi (titolo e artista) e un bottone "aggiungi alla playlist".
associare al bottone una funzione che aggiunga il nuovo brano alla playlist e stampi la playlist in console.
creare un bottone che avvii la precedente funzione di riproduzione casuale.
*/


console.log(playlist);
const deepCopy = JSON.parse(JSON.stringify(playlist));
let canzoniRimosse = []; // Memorizza le canzoni già riprodotte
let canzoneCasuale;
const btn1 = document.querySelector('.btn1');
const btn2 = document.querySelector('.btn2');
btn1.style.display = "block";
btn2.style.display = "none";

function riproduzioneCasuale() {
  const index = Math.floor(Math.random() * (playlist.length - canzoniRimosse.length));


  // Rimuovi la canzone riprodotta dalla playlist
  canzoneCasuale = playlist.splice(index, 1)[0];

  if (playlist.length > canzoniRimosse.length){
    btn1.style.display = "block";
    btn2.style.display = "none";

  console.log(`Now playing: ${canzoneCasuale.titolo} by ${canzoneCasuale.artista}`);
  console.log(`Rimossa la canzone ${canzoneCasuale.titolo} by ${canzoneCasuale.artista} dalla playlist.`);
  document.querySelector('.canzoniInRiproduzione').innerHTML = "in riproduzione:  " + canzoneCasuale.titolo + " by " + canzoneCasuale.artista;


  }
  else if (canzoneCasuale === undefined) {
    canzoniRimosse = [];
    console.log("Tutte le canzoni sono state riprodotte.");
    btn1.style.display = "none";
    btn2.style.display = "block";
  }
  console.log(playlist);

  }

function ripristinaPlaylist() {
  playlist = deepCopy.slice(); // Ripristina la playlist alla sua copia profonda
  console.log("Playlist ripristinata.");
  btn1.style.display = "block";
  btn2.style.display = "none";
}

document.querySelector('.btn1').addEventListener('click', riproduzioneCasuale);
document.querySelector('.btn2').addEventListener('click', ripristinaPlaylist);

// Funzione per gestire l'aggiunta di un brano alla playlist
function aggiungiBrano() {
  const title = document.querySelector('#title').value;
  const artist = document.querySelector('#artist').value;

  const song = {
    title: title,
    artist: artist
  };

  playlist.push(song);
  console.log("Brano aggiunto alla playlist:");
  console.log(song);
  console.log("Playlist aggiornata:");
  console.log(playlist);
}

// Associa la funzione all'evento di click del bottone "Aggiungi alla playlist"
document.querySelector('#addToPlaylist').addEventListener('click', aggiungiBrano);