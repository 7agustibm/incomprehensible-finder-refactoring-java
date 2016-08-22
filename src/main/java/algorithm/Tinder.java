package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Tinder {
	private final List<Person> people;

	public Tinder(List<Person> people) {
		this.people = people;
	}

	public Match Find(MatchingPreference matchingPreference) {
		List<Match> matchList = getPairPeoplesList();

		if (matchList.size() < 1) {
			return new Match();
		}

		return findBestMatch(matchingPreference, matchList);
	}

	private Match findBestMatch(MatchingPreference matchingPreference, List<Match> matchList) {
		Match bestCandidate = matchList.get(0);
		for (Match candidatePair : matchList) {
			switch (matchingPreference) {
				case closestPairPeople:
					if (candidatePair.isCloserThan(bestCandidate)) {
						bestCandidate = candidatePair;
					}
					break;

				case furthestPairPeople:
					if (candidatePair.isFurtherThan(bestCandidate)) {
						bestCandidate = candidatePair;
					}
					break;
			}
		}
		return bestCandidate;
	}

	private List<Match> getPairPeoplesList() {
		List<Match> matchList = new ArrayList<Match>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				Match match = new Match();
				if (people.get(i).birthDate.getTime() < people.get(j).birthDate.getTime()) {
					match.firstPerson = people.get(i);
					match.secondPerson = people.get(j);
				} else {
					match.firstPerson = people.get(j);
					match.secondPerson = people.get(i);
				}
				match.diffBirthDate = match.secondPerson.birthDate.getTime() - match.firstPerson.birthDate.getTime();
				matchList.add(match);
			}
		}
		return matchList;
	}
}
