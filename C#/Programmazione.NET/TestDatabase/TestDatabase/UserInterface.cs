using System.Data.SqlClient;
using System.Diagnostics;
using Domain.Domain;
using Domain.Repositories;

namespace TestDatabase;

public class UserInterface
{
    private ContattiRepository repoContatti = new ContattiRepository();
    private DocumentoRepository repoDocumento;
    private CausaliRepository _repoCausali = new CausaliRepository();
    private ContestoDocumentoRepository _repoContesto = new ContestoDocumentoRepository();
    private RepositoryOperatore repoOperatore = new RepositoryOperatore();


    public UserInterface()
    {
        repoDocumento = new DocumentoRepository(_repoCausali, repoOperatore, _repoContesto, repoContatti);
    }
    
    
    public void Avvia()
    {
        while (true)
        {
            Console.WriteLine("Benvenuto nel programma di gestione del database!");
            Console.WriteLine("Seleziona un'operazione:");
            Console.WriteLine("1) Aggiungi entità");
            Console.WriteLine("2) Visualizza tutte le entità");
            Console.WriteLine("3) Modifica un'entità esistente");
            Console.WriteLine("4) Elimina un'entità");
            Console.WriteLine("5) Esci");

            int scelta = int.Parse(Console.ReadLine());

            switch (scelta)
            {
                case 1:
                    AggiungiEntita();
                    break;
                case 2:
                    VisualizzaEntita();
                    break;
                case 3:
                    ModificaEntita();
                    break;
                case 4:
                    EliminaEntita();
                    break;
                case 5:
                    Console.WriteLine("Arrivederci!");
                    return;
                default:
                    Console.WriteLine("Scelta non valida. Riprova.");
                    break;
            }
        }
    }


    private void AggiungiEntita()
    {
        Console.WriteLine("Seleziona il tipo di entità da aggiungere:");
        Console.WriteLine("1) Causale");
        Console.WriteLine("2) Contatto");
        Console.WriteLine("3) Contesto Documento");
        Console.WriteLine("4) Documento");
        Console.WriteLine("5) Operatore");

        int scelta = int.Parse(Console.ReadLine());

        switch (scelta)
        {
            case 1:
                AggiungiCausale();
                break;
            case 2:
                AggiungiContatto();
                break;
            case 3:
                AggiungiContestoDocumento();
                break;
            case 4:
                AggiungiDocumento();
                break;
            case 5:
                AggiungiOperatore();
                break;
            default:
                Console.WriteLine("Scelta non valida. Riprova.");
                break;
        }
        
        
        
    }

    private void AggiungiCausale()
    {
        Console.WriteLine("Inserisci descrizione:");
        string descrizione = Console.ReadLine();
        Console.WriteLine("Inserisci codice protocollo:");
        string codiceProtocollo = Console.ReadLine();

        Causale causale = new Causale
        {
            Descrizione = descrizione,
            CodiceProtocollo = codiceProtocollo
        };

        long nuovoId = _repoCausali.Insert(causale);
        Console.WriteLine($"È stata inserita la causale con ID {nuovoId}");
    }
    
    private void AggiungiContatto()
    {
        try
        {
            Console.WriteLine("Inserisci nome:");
            string nome = Console.ReadLine();
            Console.WriteLine("Inserisci cognome:");
            string cognome = Console.ReadLine();
            Console.WriteLine("Inserisci numero di telefono:");
            string numeroDiTelefono = Console.ReadLine();

            Contatto contatto = new Contatto
            {
                Nome = nome,
                Cognome = cognome,
                NumeroDiTelefono = numeroDiTelefono
            };

            long nuovoId = repoContatti.Insert(contatto);
            Console.WriteLine($"È stato inserito il contatto con ID {nuovoId}");
        }
        catch (SqlException sqlEx)
        {
            Console.WriteLine($"Errore SQL durante l'inserimento del contatto: {sqlEx.Message}");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Errore durante l'inserimento del contatto: {ex.Message}");
        }
    }

        private void AggiungiContestoDocumento()
        {
            Console.WriteLine("Inserisci descrizione:");
            string descrizione = Console.ReadLine();
            Console.WriteLine("Inserisci codice protocollo:");
            string codiceProtocollo = Console.ReadLine();
            Console.WriteLine("Inserisci responsabile:");
            string responsabile = Console.ReadLine();
            Console.WriteLine("Inserisci codice protocollo responsabile:");
            string codiceProtocolloResponsabile = Console.ReadLine();

            ContestoDocumento contestoDocumento = new ContestoDocumento
            {
                Descrizione = descrizione,
                CodiceProtocollo = codiceProtocollo,
                Responsabile = responsabile,
                CodiceProtocolloResponsabile = codiceProtocolloResponsabile
            };

            long nuovoId = _repoContesto.Insert(contestoDocumento);
            Console.WriteLine($"È stato inserito il contesto documento con ID {nuovoId}");
        }

        private void AggiungiDocumento()
        {
            Console.WriteLine("Inserisci oggetto:");
            string oggetto = Console.ReadLine();
            Console.WriteLine("Inserisci ID causale:");
            long idCausale = long.Parse(Console.ReadLine());
            Console.WriteLine("Inserisci ID operatore:");
            long idOperatore = long.Parse(Console.ReadLine());
            Console.WriteLine("Inserisci ID contesto documento:");
            long idContestoDocumento = long.Parse(Console.ReadLine());

            List<Contatto> contatti = new List<Contatto>();
            while (true)
            {
                Console.WriteLine("Inserisci ID contatto (0 per terminare):");
                long idContatto = long.Parse(Console.ReadLine());
                if (idContatto == 0) break;

                Contatto contatto = repoContatti.GetById(idContatto);
                contatti.Add(contatto);
            }

            Documento documento = new Documento
            {
                Oggetto = oggetto,
                Causale = _repoCausali.GetById(idCausale),
                Operatore = repoOperatore.GetById(idOperatore),
                ContestoDocumento = _repoContesto.GetById(idContestoDocumento),
                Contatti = contatti
            };

            long nuovoId = repoDocumento.Insert(documento);
            Console.WriteLine($"È stato inserito il documento con ID {nuovoId}");
        }

        private void AggiungiOperatore()
        {
            Console.WriteLine("Inserisci descrizione:");
            string descrizione = Console.ReadLine();
            Console.WriteLine("Inserisci codice protocollo:");
            string codiceProtocollo = Console.ReadLine();

            Operatore operatore = new Operatore
            {
                Descrizione = descrizione,
                CodiceProtocollo = codiceProtocollo
            };

            long nuovoId = repoOperatore.Insert(operatore);
            Console.WriteLine($"È stato inserito l'operatore con ID {nuovoId}");
        }

        private void VisualizzaEntita()
        {
            Console.WriteLine("Seleziona il tipo di entità da visualizzare:");
            Console.WriteLine("1) Causale");
            Console.WriteLine("2) Contatto");
            Console.WriteLine("3) Contesto Documento");
            Console.WriteLine("4) Documento");
            Console.WriteLine("5) Operatore");

            int scelta = int.Parse(Console.ReadLine());

            switch (scelta)
            {
                case 1:
                    VisualizzaCausali();
                    break;
                case 2:
                    VisualizzaContatti();
                    break;
                case 3:
                    VisualizzaContestiDocumento();
                    break;
                case 4:
                    VisualizzaDocumenti();
                    break;
                case 5:
                    VisualizzaOperatori();
                    break;
                default:
                    Console.WriteLine("Scelta non valida. Riprova.");
                    break;
            }
        }

        private void VisualizzaCausali()
        {
            List<Causale> causali = _repoCausali.FindAll();
            foreach (var causale in causali)
            {
                Console.WriteLine($"Causale: {causale.Descrizione}, Codice: {causale.CodiceProtocollo}, ID: {causale.Id}");
            }
        }

        private void VisualizzaContatti()
        {
            List<Contatto> contatti = repoContatti.FindAll();
            foreach (var contatto in contatti)
            {
                Console.WriteLine($"Contatto: {contatto.Nome} {contatto.Cognome}, Numero di Telefono: {contatto.NumeroDiTelefono}, ID: {contatto.Id}");
            }
        }

        private void VisualizzaContestiDocumento()
        {
            List<ContestoDocumento> contesti = _repoContesto.FindAll();
            foreach (var contesto in contesti)
            {
                Console.WriteLine($"Contesto Documento: {contesto.Descrizione}, Codice: {contesto.CodiceProtocollo}, ID: {contesto.Id}");
            }
        }

        private void VisualizzaDocumenti()
        {
            List<Documento> documenti = repoDocumento.FindAll();
            foreach (var documento in documenti)
            {
                Console.WriteLine($"Documento: {documento.Oggetto}, Causale ID: {documento.Causale.Id}, Operatore ID: {documento.Operatore.Id}, Contesto Documento ID: {documento.ContestoDocumento.Id}, ID: {documento.Id}");
            }
        }

        private void VisualizzaOperatori()
        {
            List<Operatore> operatori = repoOperatore.FindAll();
            foreach (var operatore in operatori)
            {
                Console.WriteLine($"Operatore: {operatore.Descrizione}, Codice: {operatore.CodiceProtocollo}, ID: {operatore.Id}");
            }
        }

        private void ModificaEntita()
        {
            Console.WriteLine("Seleziona il tipo di entità da modificare:");
            Console.WriteLine("1) Causale");
            Console.WriteLine("2) Contatto");
            Console.WriteLine("3) Contesto Documento");
            Console.WriteLine("4) Documento");
            Console.WriteLine("5) Operatore");

            int scelta = int.Parse(Console.ReadLine());

            switch (scelta)
            {
                case 1:
                    ModificaCausale();
                    break;
                case 2:
                    ModificaContatto();
                    break;
                case 3:
                    ModificaContestoDocumento();
                    break;
                case 4:
                    ModificaDocumento();
                    break;
                case 5:
                    ModificaOperatore();
                    break;
                default:
                    Console.WriteLine("Scelta non valida. Riprova.");
                    break;
            }
        }

        private void ModificaCausale()
        {
            Console.WriteLine("Inserisci ID della causale da modificare:");
            long id = long.Parse(Console.ReadLine());
            Causale causale = _repoCausali.GetById(id);

            if (causale == null)
            {
                Console.WriteLine("Causale non trovata.");
                return;
            }

            Console.WriteLine("Inserisci nuova descrizione (lascia vuoto per mantenere invariato):");
            string descrizione = Console.ReadLine();
            if (!string.IsNullOrEmpty(descrizione))
            {
                causale.Descrizione = descrizione;
            }

            Console.WriteLine("Inserisci nuovo codice protocollo (lascia vuoto per mantenere invariato):");
            string codiceProtocollo = Console.ReadLine();
            if (!string.IsNullOrEmpty(codiceProtocollo))
            {
                causale.CodiceProtocollo = codiceProtocollo;
            }

            _repoCausali.Update(causale);
            Console.WriteLine("Causale aggiornata.");
        }

        private void ModificaContatto()
        {
            Console.WriteLine("Inserisci ID del contatto da modificare:");
            long id = long.Parse(Console.ReadLine());
            Contatto contatto = repoContatti.GetById(id);

            if (contatto == null)
            {
                Console.WriteLine("Contatto non trovato.");
                return;
            }

            Console.WriteLine("Inserisci nuovo nome (lascia vuoto per mantenere invariato):");
            string nome = Console.ReadLine();
            if (!string.IsNullOrEmpty(nome))
            {
                contatto.Nome = nome;
            }

            Console.WriteLine("Inserisci nuovo cognome (lascia vuoto per mantenere invariato):");
            string cognome = Console.ReadLine();
            if (!string.IsNullOrEmpty(cognome))
            {
                contatto.Cognome = cognome;
            }

            Console.WriteLine("Inserisci nuovo numero di telefono (lascia vuoto per mantenere invariato):");
            string numeroDiTelefono = Console.ReadLine();
            if (!string.IsNullOrEmpty(numeroDiTelefono))
            {
                contatto.NumeroDiTelefono = numeroDiTelefono;
            }

            repoContatti.Update(contatto);
            Console.WriteLine("Contatto aggiornato.");
        }

        private void ModificaContestoDocumento()
        {
            Console.WriteLine("Inserisci ID del contesto documento da modificare:");
            long id = long.Parse(Console.ReadLine());
            ContestoDocumento contesto = _repoContesto.GetById(id);

            if (contesto == null)
            {
                Console.WriteLine("Contesto documento non trovato.");
                return;
            }

            Console.WriteLine("Inserisci nuova descrizione (lascia vuoto per mantenere invariato):");
            string descrizione = Console.ReadLine();
            if (!string.IsNullOrEmpty(descrizione))
            {
                contesto.Descrizione = descrizione;
            }

            Console.WriteLine("Inserisci nuovo codice protocollo (lascia vuoto per mantenere invariato):");
            string codiceProtocollo = Console.ReadLine();
            if (!string.IsNullOrEmpty(codiceProtocollo))
            {
                contesto.CodiceProtocollo = codiceProtocollo;
            }

            Console.WriteLine("Inserisci nuovo responsabile (lascia vuoto per mantenere invariato):");
            string responsabile = Console.ReadLine();
            if (!string.IsNullOrEmpty(responsabile))
            {
                contesto.Responsabile = responsabile;
            }

            Console.WriteLine("Inserisci nuovo codice protocollo responsabile (lascia vuoto per mantenere invariato):");
            string codiceProtocolloResponsabile = Console.ReadLine();
            if (!string.IsNullOrEmpty(codiceProtocolloResponsabile))
            {
                contesto.CodiceProtocolloResponsabile = codiceProtocolloResponsabile;
            }

            _repoContesto.Update(contesto);
            Console.WriteLine("Contesto documento aggiornato.");
        }

        private void ModificaDocumento()
        {
            Console.WriteLine("Inserisci ID del documento da modificare:");
            long id = long.Parse(Console.ReadLine());
            Documento documento = repoDocumento.GetById(id);

            if (documento == null)
            {
                Console.WriteLine("Documento non trovato.");
                return;
            }

            Console.WriteLine("Inserisci nuovo oggetto (lascia vuoto per mantenere invariato):");
            string oggetto = Console.ReadLine();
            if (!string.IsNullOrEmpty(oggetto))
            {
                documento.Oggetto = oggetto;
            }

            Console.WriteLine("Inserisci nuovo ID causale (0 per mantenere invariato):");
            long idCausale = long.Parse(Console.ReadLine());
            if (idCausale != 0)
            {
                documento.Causale = _repoCausali.GetById(idCausale);
            }

            Console.WriteLine("Inserisci nuovo ID operatore (0 per mantenere invariato):");
            long idOperatore = long.Parse(Console.ReadLine());
            if (idOperatore != 0)
            {
                documento.Operatore = repoOperatore.GetById(idOperatore);
            }

            Console.WriteLine("Inserisci nuovo ID contesto documento (0 per mantenere invariato):");
            long idContestoDocumento = long.Parse(Console.ReadLine());
            if (idContestoDocumento != 0)
            {
                documento.ContestoDocumento = _repoContesto.GetById(idContestoDocumento);
            }

            Console.WriteLine("Modifica contatti (lascia vuoto per mantenere invariato):");
            List<Contatto> nuoviContatti = new List<Contatto>();
            while (true)
            {
                Console.WriteLine("Inserisci ID contatto (0 per terminare):");
                long idContatto = long.Parse(Console.ReadLine());
                if (idContatto == 0) break;

                Contatto contatto = repoContatti.GetById(idContatto);
                nuoviContatti.Add(contatto);
            }

            if (nuoviContatti.Count > 0)
            {
                documento.Contatti = nuoviContatti;
            }

            repoDocumento.Update(documento);
            Console.WriteLine("Documento aggiornato.");
        }

        private void ModificaOperatore()
        {
            Console.WriteLine("Inserisci ID dell'operatore da modificare:");
            long id = long.Parse(Console.ReadLine());
            Operatore operatore = repoOperatore.GetById(id);

            if (operatore == null)
            {
                Console.WriteLine("Operatore non trovato.");
                return;
            }

            Console.WriteLine("Inserisci nuova descrizione (lascia vuoto per mantenere invariato):");
            string descrizione = Console.ReadLine();
            if (!string.IsNullOrEmpty(descrizione))
            {
                operatore.Descrizione = descrizione;
            }

            Console.WriteLine("Inserisci nuovo codice protocollo (lascia vuoto per mantenere invariato):");
            string codiceProtocollo = Console.ReadLine();
            if (!string.IsNullOrEmpty(codiceProtocollo))
            {
                operatore.CodiceProtocollo = codiceProtocollo;
            }

            repoOperatore.Update(operatore);
            Console.WriteLine("Operatore aggiornato.");
        }

        private void EliminaEntita()
        {
            Console.WriteLine("Seleziona il tipo di entità da eliminare:");
            Console.WriteLine("1) Causale");
            Console.WriteLine("2) Contatto");
            Console.WriteLine("3) Contesto Documento");
            Console.WriteLine("4) Documento");
            Console.WriteLine("5) Operatore");

            int scelta = int.Parse(Console.ReadLine());

            switch (scelta)
            {
                case 1:
                    EliminaCausale();
                    break;
                case 2:
                    EliminaContatto();
                    break;
                case 3:
                    EliminaContestoDocumento();
                    break;
                case 4:
                    EliminaDocumento();
                    break;
                case 5:
                    EliminaOperatore();
                    break;
                default:
                    Console.WriteLine("Scelta non valida. Riprova.");
                    break;
            }
        }

        private void EliminaCausale()
        {
            Console.WriteLine("Inserisci ID della causale da eliminare:");
            long id = long.Parse(Console.ReadLine());

            _repoCausali.Delete(id);
            Console.WriteLine("Causale eliminata.");
        }

        private void EliminaContatto()
        {
            Console.WriteLine("Inserisci ID del contatto da eliminare:");
            long id = long.Parse(Console.ReadLine());

            repoContatti.Delete(id);
            Console.WriteLine("Contatto eliminato.");
        }

        private void EliminaContestoDocumento()
        {
            Console.WriteLine("Inserisci ID del contesto documento da eliminare:");
            long id = long.Parse(Console.ReadLine());

            _repoContesto.Delete(id);
            Console.WriteLine("Contesto documento eliminato.");
        }

        private void EliminaDocumento()
        {
            Console.WriteLine("Inserisci ID del documento da eliminare:");
            long id = long.Parse(Console.ReadLine());

            repoDocumento.Delete(id);
            Console.WriteLine("Documento eliminato.");
        }

        private void EliminaOperatore()
        {
            Console.WriteLine("Inserisci ID dell'operatore da eliminare:");
            long id = long.Parse(Console.ReadLine());

            repoOperatore.Delete(id);
            Console.WriteLine("Operatore eliminato.");
        }
    }
