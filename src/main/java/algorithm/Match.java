package algorithm;
public class Match {
	public Person firstPerson;
	public Person secondPerson;

	public Match(){
	}

	public static Match create(Person firstPerson, Person secondPerson){

		if (firstPerson.isYoungerThan(secondPerson)) {
			return new Match(firstPerson, secondPerson);
		}
		return new Match(secondPerson, firstPerson);
	}

	private Match(Person firstPerson, Person secondPerson){
		this.firstPerson = firstPerson;
		this.secondPerson = secondPerson;
	}

	public boolean isCloserThan(Match candidate) {
		return this.diffBirthDate() < candidate.diffBirthDate();
	}

	public boolean isFurtherThan(Match candidate) {
		return this.diffBirthDate() > candidate.diffBirthDate();
	}

	public long diffBirthDate (){
		return this.secondPerson.birthDate.getTime() - this.firstPerson.birthDate.getTime();
	}
}
