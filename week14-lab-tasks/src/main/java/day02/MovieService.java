package day02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {
	private List<Movie> movies = new ArrayList<>();

	public void addMovie(Movie movie) {
		movies.add(movie);
	}

// Add vissza azon filmek listáját amiben szerepel egy paraméterül átadott színész.
	public List<Movie> getMoviesWithActor(String actor) {
//		return movies.stream().filter(m -> m.getActors().stream()
//			.anyMatch(a -> a.equals(actor))).collect(Collectors.toList());
		return movies.stream().filter(m -> m.getActors().contains(actor))
			.collect(Collectors.toList());
	}

// Add vissza a leghosszabb film hosszát
	public int getLongestMovie() {
		return movies.stream().mapToInt(m->m.getLength()).max()
			.orElseThrow(()-> new IllegalStateException("List is empty"));
	}
}
