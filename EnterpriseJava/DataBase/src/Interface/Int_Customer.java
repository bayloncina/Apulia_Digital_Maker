package Interface;

public interface Int_Customer {
	//Select
		final String clienti="Select * from customer";
		final String clienti_input="Select * from customer where (first_name like ? or last_name like ?)";
		final String top_5_clienti="select c.last_name, c.first_name,count(rental_id) as conto from customer c,rental r where c.customer_id=r.customer_id "
							+ "group by c.last_name,c.first_name order by conto desc limit 5" ;
		final String flop_5_clienti="select c.last_name, c.first_name,count(rental_id) as conto from customer c,rental r where c.customer_id=r.customer_id "
									+ "group by c.last_name,c.first_name order by conto limit 5" ;
								
		final String MaxSpesa_5_clienti="select c.first_name ,c.last_name,Count(*)as conto,sum (amount) as amount from customer c,payment p where"
									+ " c.customer_id=p.customer_id  group by c.customer_id order by conto desc limit 5";

		//Insert
		final String inserisci_cliente="insert into customer(store_id,first_name,last_name,email,address_id,activebool,create_date,active) "
										+ "values(?,?,?,?,?,?,?,?);";
		
		//Delete
		final String elimina_cliente_rental=" delete from rental where customer_id=?";
		final String elimina_cliente_payment=" delete from payment where customer_id=?";
		final String elimina_cliente=" delete from customer where customer_id=?";

}
