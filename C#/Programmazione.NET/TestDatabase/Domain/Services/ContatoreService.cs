using Domain.Domain;
using Domain.Repositories;

namespace Domain.Services;

public class ContatoreService
{
    private object _locker = new object();


    public ContatoreService()
    {
        
    }
   
    public int CalcolaProgressivoSuccessivo(ContatoreRepository contatoreRepository)
    {

        lock (_locker)
        {
             Contatore c = contatoreRepository.GetById(1);
            if (c == null)
            {
                c = new Contatore();
                contatoreRepository.Insert(c);
            }
            
            c.Valore++;
            contatoreRepository.Update(c);
            
            return c.Valore;
        }
       
    }
}