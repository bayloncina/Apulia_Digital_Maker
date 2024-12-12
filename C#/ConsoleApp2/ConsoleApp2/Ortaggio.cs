using System.Diagnostics;
using System.Security.Principal;

namespace ConsoleApp2;

public class Ortaggio
{
   public string Nome {get; set; }
   
   //ctor per creare costruttore

   public Ortaggio()
   {
       throw new NotImplementedException();
   }


   //Calcola data di maturazione
   
   public DateOnly CalcolaDataDiMaturazione(TipoOrtaggio tipo, DateOnly dataSemina){
       int meseSemina = dataSemina.Month;
           bool primiDiNovembre = dataSemina.Month == 11 && 
       switch (tipo)
       {
           case TipoOrtaggio.OrtaggiAFruttoEstivo:
           if (meseSemina == 3 || meseSemina == 4 || meseSemina == 5)
           {
               return dataSemina.AddMonths(3);
           }
               break;
           case TipoOrtaggio.OrtaggiAFruttoInvernale:
           if (meseSemina == 3 || meseSemina == 4 || meseSemina == 5)
           {
               return dataSemina.AddMonths(3);
           }
               break;
           case TipoOrtaggio.OrtaggiATuberoEstivo:
               break;
           case TipoOrtaggio.OrtaggiATuberoInvernale:
               break;
           case TipoOrtaggio.OratggiAFoglia:
               break;
           default:
               throw new ArgumentOutOfRangeException(nameof(tipo), tipo, null);
       }

