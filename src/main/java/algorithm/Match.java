package algorithm;
public class Match {
	public Person firstPerson;
	public Person secondPerson;
	public long diffBirthDate;

	public boolean isCloserThan(Match candidate) {
		return this.diffBirthDate < candidate.diffBirthDate;
	}

	public boolean isFurtherThan(Match candidate) {
		return this.diffBirthDate > candidate.diffBirthDate;
	}
}
