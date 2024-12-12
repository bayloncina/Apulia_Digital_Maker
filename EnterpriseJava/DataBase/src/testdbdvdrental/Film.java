package testdbdvdrental;

public class Film {
	
	private String title;
	
	private int filmId;
	
	private String releaseYear;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Override
	public String toString() {
		return "Film [title=" + title + ", filmId=" + filmId + ", releaseYear=" + releaseYear + "]";
	}

}