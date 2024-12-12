// See https://aka.ms/new-console-template for more information

using ConsoleProdotti;

List<Prodotto> prodotti = new List<Prodotto>();


new Prodotto()
{
    ID = 1,
    Name = "Computer",
    Category = "Informatica",
    Price = 800m,
    InStockNumber = 22

};
new Prodotto()
{
    ID = 2,
    Name = "Mouse",
    Category = "Informatica",
    Price = 15m,
    InStockNumber = 65

};
new Prodotto()
{
    ID = 3,
    Name = "Decespugliatore",
    Category = "FaiDaTe",
    Price = 500m,
    InStockNumber = 69

};
new Prodotto()
{
    ID = 4,
    Name = "Badile",
    Category = "FaiDaTe",
    Price = 50m,
    InStockNumber = 57

};
new Prodotto()
{
    ID = 5,
    Name = "Motozappa",
    Category = "FaiDaTe",
    Price = 800m,
    InStockNumber = 65

};
new Prodotto()
{
    ID = 6,
    Name = "CavoEthernet",
    Category = "Informatica",
    Price = 150m,
    InStockNumber = 52

};
new Prodotto()
{
    ID = 7,
    Name = "Stampante",
    Category = "Informatica",
    Price = 120m,
    InStockNumber = 10

};
 //cerca prodotti maggiori di 500
//LA FUNZIONE WHERE FILTRA
List<Prodotto> informaticaMaggioreDi500 = prodotti.Where(prod => prod.Category == "Informatica" && prod.Price > 500m)
    .ToList();


//calcola il numero dei prodotti in magazzino
//calcola totale del magazzino

    prodotti.Where(p => p.InStockNumber > 0).GroupBy(a => a.InStockNumber > 0)
    .Select(a => new {InStock = a.Sum(a => a.InStockNumber), TotalPrice = a.Sum(p => p.Price * p.InStockNumber) })
    .ToList()
    .ForEach(a => Console.WriteLine($"InStock: {a.InStock}, TotalPrice: {a.TotalPrice}"));

//ordina i prodotti per categoria
     prodotti.Where(p => p.InStockNumber > 0).GroupBy(a => a.Category)
    .Select(a => new {Category=a.Key, InStockNumber = a.Sum(a => a.InStockNumber), TotalPrice = a.Sum(p => p.Price * p.InStockNumber) })
    .ToList()
    .ForEach(a => Console.WriteLine($"Category: {a.Category} InStock: {a.InStockNumber}, TotalPrice: {a.TotalPrice}"));
    
    
    //ordinamento e seleziona i 5 più costosi

    prodotti.OrderByDescending(prod => prod.Price)
        .ToList()
        .Skip(1)
        .Take(1);
     //. (prod => Console.WriteLine(prod));
 
 //restituisci una lista di stringhe contenenti il testo DOMENICO SA COS'E' UNA SELECT
 
 prodotti.Select( a => "Domenico sa cosa è una select").Take(3).ToList().ForEach(a=> Console.WriteLine(a));
 
 //crea liste stringhe con scritto Daniele a partire dai prodotti
 
int counter = 1;
//la select in input vuole una lambda
prodotti.Select( a => $"Daniele {counter++}").ToList().ForEach(a => Console.WriteLine(a));


//ORDINARE IN ORDINE ALFABETICO I PRODOTTI CON PREZZO INFERIORE AI 600 EURO

prodotti.Where(prod => prod.Price < 600).OrderBy(prod => prod.Name)
    .ToList()
    .ForEach(c => Console.WriteLine(c));
 
 
 //trova i prodotti più costosi e meno costoso per categoria
 
 /*
  prodotti.GroupBy(a => a.Category).Select(p => new
     {
         categ = p.Key,
         prodottoCostoso = p.OrderByDescending(a => a.Price)
             .Select(nome=> nome.Name)
             .FirstOrDefault(),
         prodottoMenoCostoso = p.OrderBy(prodotto => prodotto.Price).Select(nome => nome.Name).FirstOrDefault()
     }).Select(c =>
     {
         if (c.prodottoMenoCostoso == c.prodottoCostoso)
             return new
             {
                 categ = c.categ,
                 ProdottoCostoso = c.prodottoCostoso,
                 ProdottoMenoCostoso = ""
             };
         return c;
             
     }).ToList()
     .ForEach(pf => Console.WriteLine($"Cat: {pf.categ} Nome Prodotto più Costoso: {pf.prodottoCostoso} Nome Prodotto nemo costoso {pf.prodottoMenoCostoso}"));
     */