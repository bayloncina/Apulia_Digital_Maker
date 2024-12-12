
/*let nomeECognome = document.getElementById(`nomeEcognome`).value;
let telefono = document.getElementById(`telefono`).value;
let email = document.getElementById(`email`).value;
let button = document.getElementById(`btn-add`).value;

function controlloForm(nomeECognome, telefono, email) {
    if (nomeECognome.length < 1) {
        console.log("Inserisci almeno 1 carattere per Nome e Cognome");
        return
    }
    if (telefono.length < 8) {
        console.log("Il numero di telefono deve essere composto da 8 cifre");
        return
    }
    if (!email.includes("@")) {
        console.log("Inserisci un indirizzo email valido");
        return
    }
}


function generaCodiceSconto(nomeECognome) {
    document.getElementById("nomeEcognome").value.toUpperCase();
    let dataOdierna = new Date();
    let anno = dataOdierna.getFullYear().toString().substring(2);
    let mese = ("0" + (dataOdierna.getMonth() + 1)).slice(-2);
    let giorno = ("0" + dataOdierna.getDate()).slice(-2);
    let codiceSconto = anno + mese + giorno + nomeECognome + "10";
    console.log("Il tuo codice sconto è: " + codiceSconto);
}
document.addEventListener("DOMContentLoaded", () => {
    button.addEventListener(`click`, (event) => {
        controlloForm(nomeECognome, telefono, email);
        console.log(generaCodiceSconto(nomeECognome));
    })
})*/

document.addEventListener("DOMContentLoaded", () => {
    let button = document.getElementById(`btn-add`);

    button.addEventListener(`click`, (event) => {
        event.preventDefault(); // Prevent form submission

        let nome = document.getElementById(`nome`).value;
        let cognome = document.getElementById(`cognome`).value;
        let telefono = document.getElementById(`telefono`).value;
        let email = document.getElementById(`email`).value;

        controlloForm(nome, cognome, telefono, email);
        generaCodiceSconto(cognome);
    })
});

function controlloForm(nome, cognome, telefono, email) {
    if (nome.length < 1) {
        alert = console.log("Inserisci almeno 1 carattere per Nome");
    }
    if (cognome.length < 1) {
        alert = console.log("Inserisci almeno 1 carattere per Cognome");
    }
    if (telefono.length != 8) {
        alert = console.log("Il numero di telefono deve essere composto da 8 cifre");
    }
    if (!email.includes("@")) {
        alert = console.log("Inserisci un indirizzo email valido");
    }
}

function generaCodiceSconto(cognome) {
    let cognomeUpperCase = cognome.toUpperCase();
    let dataOdierna = new Date();
    let anno = dataOdierna.getFullYear().toString().substring(2);
    let mese = ("0" + (dataOdierna.getMonth() + 1)).slice(-2);
    let giorno = ("0" + dataOdierna.getDate()).slice(-2);
    let codiceSconto = anno + mese + giorno + cognomeUpperCase + "10";
    console.log("Grazie per aver inserito i tuoi dati. Ecco il tuo codice sconto: " + codiceSconto);
}