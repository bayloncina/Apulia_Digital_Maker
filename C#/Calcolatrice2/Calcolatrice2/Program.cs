// See https://aka.ms/new-console-template for more information

using Calcolatrice2;

MostraOperazioniDisponibili();
RegistraOperazioneDaEffettuare();
RichiediOperandi();
EffettuaCalcolo();
StampaRisultato();


void MostraOperazioniDisponibili(TipoOperazione)
{
    TipoOperazione.Addizione();
    TipoOperazione.Sottrazione();
    TipoOperazione.Moltiplicazione();
    TipoOperazione.Divisione();
    TipoOperazione.RadiceQuadrata();
    TipoOperazione.Potenza();
}
void RegistraOperazioneDaEffettuare(TipoOperazione operazione)
{
    Console.ReadLine(@"
Inserisci:
1. Per addizione
2. Per sottrazione
3. Per moltiplicazione
4. Per divisione
5. Per Radice Quadrata
6. Per la Potenza ");
    return TipoOperazione;
}
void RichiediOperandi()
{
    decimal operando1 = Console.WriteLine("Inserisci numero");
    bool decideDiContinuare = Console.WriteLine("Inserisci Y per continuare N per fermarti e procedere all'operazione");
    if (decideDiContinuare == "Y")
    {
        Console.WriteLine("Inserisci di numero");
        decimal operando1 = Console.ReadLine();
    }
}
void EffettuaCalcolo()
{
    throw new NotImplementedException();
}


void StampaRisultato()
{
    throw new NotImplementedException();
}
