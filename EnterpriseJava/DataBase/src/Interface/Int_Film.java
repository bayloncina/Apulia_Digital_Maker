package Interface;

public interface Int_Film {
	// select
		final String titoli = "SELECT *  FROM film order by film_id;";

		final String titoli_per_attore = "select title,last_name,first_name from actor a,film f,film_actor fa where f.film_id=fa.film_id and"
				+ "	fa.actor_id=a.actor_id and ( last_name like ? or first_name like ?) order by title";

		final String titoli_con_input = "Select * from film where title like ? order by film_id";

		final String film_top_noleggi = "select f.title,Count(r.rental_id)as conto from film f,inventory i,rental r "
				+ "where f.film_id=i.film_id and i.inventory_id=r.inventory_id   group by title order by conto desc limit 5";

		final String selezione_categoria = "select * from category where name=?";

		final String filmId = "Select * from film where film_id=?";

		final String res_store = "select store_id from inventory where inventory_id=?";

		final String res_film_id = "select store_id from inventory where inventory_id=?";

		// Insert
		
		final String inserisciLingua = " insert into Language (name)" + " values (?)";

		final String inserisciFilm = "insert into Film (title,description,release_year,language_id,rental_duration,rental_rate,length,replacement_cost,rating)"
				+ "values(?,?,?,?,?,?,?,?,?::mpaa_rating);";

		final String film_category = " insert into film_category  values (?,?)";

		final String film_inventory = "insert into inventory(film_id,store_id)values(?,?)";

		final String film_actory = "insert into film_actor(actor_id,film_id)values(?,?)";

		// delete
		final String elimina_film_category = " delete from film_category where film_id=?";

		final String elimina_film = " delete from film where film_id=?";

		final String elimina_film_actor = " delete from film_actor where film_id=?";

		final String elimina_film_inventory = " delete from inventory where film_id=?";

		final String elimina_rental = "delete from rental where rental_id in "
				+ "(select r.rental_id from inventory i,rental r where "
				+ "i.inventory_id=r.inventory_id and film_id=? and r.return_date is not null)";

		final String elimina_payment = "delete from payment where rental_id in (select r.rental_id from inventory i,rental r"
				+ "	 where i.inventory_id=r.inventory_id and film_id=? and r.return_date is not null)";
		
		// update

		final String aggiorna_titoli = "update film set title=?,description=?,release_year=?,language_id=?,"
				+ "rental_duration=?,rental_rate=?,length=?,replacement_cost=?,rating=?::mpaa_rating where film_id=?";

}
