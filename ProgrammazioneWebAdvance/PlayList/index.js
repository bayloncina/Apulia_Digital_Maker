const playlist = [
    {
        titolo: "Disorder",
        artista: "Joy Division"
    },
    {
        titolo: "Vivere",
        artista: "Vasco Rossi"
    },
    {
        titolo: "Play with fire",
        artista: "Rolling Stones"
    },
    {
        titolo: "Never Surrender",
        artista: "Combichrist"
    },
    {
        titolo: "A Little Piece of Heaven",
        artista: "Avenged Sevenfold"
    },
    {
        titolo: "Before I Forget",
        artista: "Slipknot"
    },
    {
        titolo: "Thriller",
        artista: "Michael Jackson"
    },
    {
        titolo: "Nothing Else Matters",
        artista: "Metallica"
    },
    {
        titolo: "Guerriero",
        artista: "Marco Mengoni"
    },
    {
        titolo: "Grissin Bon",
        artista: "Gerry Scotti"
    },
    {
        titolo: "Disco Dildo",
        artista: "Immanuel Casto"
    },
    {
        titolo: "Crawling",
        artista: "Linkin Park"
    },
    {
        titolo: "Otherside",
        artista: "RHCP"
    },
    {
        titolo: "Hymn for the weekend",
        artista: "Coldplay"
    },
    {
        titolo: "Plug in baby",
        artista: "Muse"
    },
    {
        titolo: "Today",
        artista: "Vegas Jones"
    },
    {
        titolo: "World Hold On",
        artista: "Bob Sinclair"
    },
    {
        titolo: "Clock",
        artista: "Coldplay"
    },
    {
        titolo: "Trapanarella",
        artista: "Franco Staco"
    },
    {
        titolo: "Boulevard Of Broken Dreams",
        artista: "Green Day"
    },
    {
        titolo: "Quelli che non hanno età",
        artista: "Eiffel 65"
    },
    {
        titolo: "Quann Ierm Criatur",
        artista: "Mino Fanelli"
    },
    {
        titolo: "Il triangolo no",
        artista: "Renato Zero"
    },
    {
        titolo: "Campione dei 90",
        artista: "Caparezza"
    },
];

/*
1) Creare un file che realizzi la riproduzione casuale:
a ogni chiamata restituisce titolo e autore una canzone della playlist a caso con la frase
Now playing: {titolo} by {autore}

2) Migliorare la funzione di riproduzione casuale, facendo in modo che la canzone appena ascoltata
non possa più essere selezionata in console.
Rimossa la canzone {titolo} by {autore}
*/

bottone = document.querySelector("#btn");
bottone.addEventListener('click', (event) => {
    event.preventDefault();
    ripoduzioneCasuale(playlist);
})


function ripoduzioneCasuale(playlist) {
    var indiceBranoCasuale = Math.floor(Math.random() * (playlist.length));
    if (playlist[indiceBranoCasuale] !== undefined) {
        let risultato = `stai ascoltando ` + playlist[indiceBranoCasuale].titolo + ` ` + playlist[indiceBranoCasuale].artista;
        playlist.splice(indiceBranoCasuale, 1);
        console.log(risultato);
    } else {
        console.log("brani terminati");
    }
}


/*
 3) Costruire un form con due campi (titolo e artista) e
    un bottone "Aggiungi alla playlist".
    Associare al bottone una funzione che aggiunga il nuovo
    brano alla playlist e stampi la playlist in console.

    Creare un bottone che avvii la precedente funzione
    di riproduzione casuale.
*/

document.addEventListener("DOMContentLoaded", () => {

    let buttonA = document.getElementById(`btn-add`);
    let titolo = document.getElementById(`titolo`);
    let artista = document.getElementById(`artista`);

    buttonA.addEventListener('click', (event) => {
        event.preventDefault();

        playlist.push({ titolo: titolo.value, artista: artista.value })

    })
})