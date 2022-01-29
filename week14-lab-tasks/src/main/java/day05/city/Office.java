package day05.city;

public class Office extends Building {
	private String company;
	private int numberOfTablesPerLevel;

	public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
		super(area, levels, address);
		this.company = company;
		this.numberOfTablesPerLevel = numberOfTablesPerLevel;
		if (numberOfTablesPerLevel * 2 > area || numberOfTablesPerLevel * 5 < area) {
			throw new IllegalArgumentException("Error");
		}
	}

	public Office(int area, Address address, String company, int numberOfTablesPerLevel) {
		this(area, 1, address, company, numberOfTablesPerLevel);
	}

	public String getCompany() {
		return company;
	}

	public int getNumberOfTablesPerLevel() {
		return numberOfTablesPerLevel;
	}

	@Override
	int calculateNumberOfPeopleCanFit() {
		return (getLevels() - 1) * numberOfTablesPerLevel;
	}
}
