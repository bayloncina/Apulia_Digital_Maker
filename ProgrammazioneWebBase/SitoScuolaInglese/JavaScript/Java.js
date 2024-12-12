document.addEventListener("DOMContentLoaded", function () {
    let contenitore = document.createElement('header');
    contenitore.style.scrollMarginBottom = '10px';
    contenitore.style.width = '100%';
    contenitore.style.height = '100%';
    contenitore.style.display = 'flex';
    contenitore.style.justifyContent = 'space-between';
    contenitore.style.alignItems = 'center';
    contenitore.style.marginLeft = 'auto';


    //creare immagine

    let immagine = document.createElement('img');
    immagine.src = 'Multimedia/Immagini/uagnun5050.jpg';
    testoImmagine = 'Logo Uagnon'
    immagine.title = testoImmagine;
    immagine.alt = testoImmagine;

    //inserire link nell'immagine

    let linkHome = document.createElement('a');
    linkHome.href = 'https:www.rockwaveitalia.it';


    linkHome.appendChild(immagine); //inserisce link all'immagine

    contenitore.appendChild(linkHome); //inserisce immagine e le inserisce il link alla home

    document.getElementById('intestazione').appendChild(contenitore);
    // document.body.insertBefore(contenitore, document.body.firstChild);


})