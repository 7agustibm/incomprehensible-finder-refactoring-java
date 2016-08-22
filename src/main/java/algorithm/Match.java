package algorithm;
public class Match {
	public Person firstPerson;
	public Person secondPerson;

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
