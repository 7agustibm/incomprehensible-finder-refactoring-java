package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public PairPeople Find(PersonOption personOption) {
		List<PairPeople> pairPeopleList = new ArrayList<PairPeople>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				PairPeople pairPeople = new PairPeople();
				if (people.get(i).birthDate.getTime() < people.get(j).birthDate.getTime()) {
					pairPeople.firstPerson = people.get(i);
					pairPeople.secondPerson = people.get(j);
				} else {
					pairPeople.firstPerson = people.get(j);
					pairPeople.secondPerson = people.get(i);
				}
				pairPeople.DiffDate = pairPeople.secondPerson.birthDate.getTime() - pairPeople.firstPerson.birthDate.getTime();
				pairPeopleList.add(pairPeople);
			}
		}

		if (pairPeopleList.size() < 1) {
			return new PairPeople();
		}

		PairPeople response = pairPeopleList.get(0);
		for (PairPeople pairPeople : pairPeopleList) {
			switch (personOption) {
				case One :
					if (pairPeople.DiffDate < response.DiffDate) {
						response = pairPeople;
					}
					break;

				case Two :
					if (pairPeople.DiffDate > response.DiffDate) {
						response = pairPeople;
					}
					break;
			}
		}

		return response;
	}
}
