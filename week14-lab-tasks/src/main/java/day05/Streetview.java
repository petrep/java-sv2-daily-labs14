package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Streetview {
	private Map<String, List<Integer>> streets = new LinkedHashMap<>();

	public void readFromFile(Path path) {
		try(BufferedReader br = Files.newBufferedReader(path)){
			String line;
			while((line=br.readLine())!=null){
				String[] temp = line.split(" ");
				if(!setUpStreet(temp[0], Integer.parseInt(temp[1]))) {
					addNewNumber(temp[0], Integer.parseInt(temp[1]));
				}

			}


		} catch (IOException e) {
			throw new IllegalStateException("Something went wrong!");
		}




	}

	public Map<String, List<Integer>> getStreets() {
		return streets;
	}


	private void addNewNumber(String street, int number) {
		int maxNumber = streets.get(street).stream().mapToInt(i->i).filter(i -> i%2==number).max().orElse(-number);
		streets.get(street).add(maxNumber+2);
	}

	private boolean setUpStreet(String street, int number) {
		if(!streets.containsKey(street)){
			streets.put(street, new ArrayList<>());
			if(number==0){
				streets.get(street).add(2);
			} else {
				streets.get(street).add(1);
			}
			return true;
		}
		return false;
	}

// Szorgalmi feladat:  utcanév alapján kérdezzük le a páros házszámok darabszámát stream-mel,
// olyan metódussal, aminek paramétere az utcanév


	public static void main(String[] args) {
		Streetview sv = new Streetview();
		Path path = Path.of("src/main/resources/streets.txt");
		sv.readFromFile(path);
		sv.streets.entrySet().stream().forEach(e-> System.out.println(e.getKey()+" " + e.getValue()));
	}
}
