package Interface;

public interface Int_Rental {
	//Select
		final String film_top_noleggi = "select f.title,Count(r.rental_id)as conto from film f,inventory i,rental r "
				+ "where f.film_id=i.film_id and i.inventory_id=r.inventory_id "
				+ "  group by title order by conto desc limit 5";
		
		final String tempo_medio_noleggi = "select  title,Avg(return_date-rental_date)as giorni from rental r,inventory i,film f"
				+ " where r.inventory_id=i.inventory_id and i.film_id=f.film_id group by title order by title";
		
		final String tempo_medio_noleggi_film = "select  title,AVG(return_date-rental_date)as giorni from rental r,inventory i,film f"
				+ "	where r.inventory_id=i.inventory_id and i.film_id=f.film_id" + " and title like ? group by title ";

		final String film_noleggiato = "select title from rental r, film f, inventory i "
				+ "where r.rental_id=? and i.inventory_id=r.inventory_id and f.film_id=i.film_id";

		
		final String film_disponibili="select count(*)-(select count(*) from rental,inventory where inventory.inventory_id=rental.inventory_id and film_id=? and store_id=?  "
				+ " and return_date is  null) from inventory where film_id=? and store_id=?";
		
		
		final String inventory_disp="select inventory_id from inventory where film_id=?  and store_id=? and  inventory_id not in" + 
				"(select rental.inventory_id from rental,inventory where inventory.inventory_id=rental.inventory_id and film_id=?  and return_date is  null  group by rental.inventory_id)";
		
		
		final String noleggi_attivi="Select title,film.film_id,inventory.inventory_id,rental.rental_id,rental.rental_date from film ,inventory ,rental " + 
				"where rental.inventory_id=inventory.inventory_id and inventory.film_id=film.film_id and return_date is null order by rental.rental_id";

		final String login="select * from staff where username=? and password=?";
		
		final String costo_noleggio="select title,(return_date-rental_date)as Durata_Effetiva,rental_rate,rental_duration,replacement_cost from film ,inventory , rental  where film.film_id=inventory.film_id and inventory.inventory_id=rental.inventory_id and rental_id=? ";
		
		final String costo_n="select (return_date-rental_date) from rental where rental_id=?";
		
		final String res_customer="select customer_id from rental where rental_id=?";
		
		final String noleggi_cliente="select first_name,last_name,title,r.rental_id from rental r, customer c ,inventory i ,film f where c.customer_id=r.customer_id and return_date is null and r.inventory_id=i.inventory_id "
				+ "and i.film_id=f.film_id and (first_name like ? or last_name like ?);";
		
		// Insert
		final String noleggia = "insert into rental (rental_date,inventory_id,customer_id,staff_id) values (?,?,?,?)";

		final String inserisci_pagamento="insert into payment (customer_id,staff_id,rental_id,amount,payment_date) values (?,?,?,?,?);" ;
				// Update
		final String restituisci_dvd = "update rental set return_date=? where rental_id=?";

}
