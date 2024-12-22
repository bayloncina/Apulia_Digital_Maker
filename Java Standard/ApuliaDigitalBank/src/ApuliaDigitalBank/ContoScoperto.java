package ApuliaDigitalBank;


public class ContoScoperto extends ContoCorrente {

	private double fido;
	private double saldo;
	
    
	public ContoScoperto(String iban, double saldo, double fido) {
        super(iban, saldo);
        this.fido = fido;
    }
	public double getFido() {
		return fido;
	}

	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public void setFido(double fido) {
		this.fido = fido;
	}


    @Override
    public void prelievo() {
        boolean controllo = true;
        
        do {
            controllo = true;
            try {
                System.out.println("Inserisci l'importo del prelievo");
                this.importo = (sc.nextDouble()); 
                if (importo <= 0) {
                    throw new EccezioniPrelievo("L'importo non può essere negativo");
                } if (this.importo > (this.getSaldo() + this.getFido())) {
                	throw new EccezioneFido("Hai finito tutto datti una calmata!!!");
                }
                else if((this.getSaldo() + this.getFido()) <= this.importo) {  
                    System.out.println("Prelievo effettuato! Hai a disposizione " + ((this.getSaldo()+this.getFido())- this.importo));
                    }
            } catch (EccezioniPrelievo eccezione) {
                System.out.println("Errore: " + eccezione.getMessage());
                controllo = false;
            }
            catch (EccezioneFido eccezione) {
                System.out.println("Errore: " + eccezione.getMessage());
            }catch (java.util.InputMismatchException e) {
                System.out.println("Errore: input non valido. Assicurati di inserire un valore numerico.");
                controllo = false;
                
            }
            sc.nextLine();

        } while (controllo == false);
    }
}
