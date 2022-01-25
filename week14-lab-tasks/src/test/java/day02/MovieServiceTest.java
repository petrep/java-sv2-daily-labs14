package day02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

	@Test
	void getMoviesWithActorTest() {
		Movie movie1 = new Movie("It", 122, Arrays.asList("actor1"));
		MovieService ms = new MovieService();
		ms.addMovie(movie1);

		assertEquals(movie1, ms.getMoviesWithActor("actor1").get(0));
	}

	@Test
	void getLongestMovieTest() {
		Movie movie1 = new Movie("It", 152, Arrays.asList("actor1"));
		Movie movie2 = new Movie("It2", 142, Arrays.asList("actor1"));
		MovieService ms = new MovieService();
		ms.addMovie(movie1);
		ms.addMovie(movie2);

		assertEquals(152, ms.getLongestMovie());
	}
}