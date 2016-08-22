package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import algorithm.Tinder;
import org.junit.Before;
import org.junit.Test;

import algorithm.Match;
import algorithm.MatchingPreference;
import algorithm.Person;

public class FinderTests {

	Person sue = new Person();
	Person greg = new Person();
	Person sarah = new Person();
	Person mike = new Person();

	@Before
	public void setup() {
		sue.name = "Sue";
		sue.birthDate = new Date(50, 0, 1);
		greg.name = "Greg";
		greg.birthDate = new Date(52, 5, 1);
		sarah.name = "Sarah";
		sarah.birthDate = new Date(82, 0, 1);
		mike.name = "Mike";
		mike.birthDate = new Date(79, 0, 1);
	}

	@Test
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> list = new ArrayList<Person>();
		Tinder tinder = new Tinder(list);

		Match result = tinder.Find(MatchingPreference.closestPairPeople);
		assertEquals(null, result.firstPerson);

		assertEquals(null, result.secondPerson);
	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);

		Tinder tinder = new Tinder(list);

		Match result = tinder.Find(MatchingPreference.closestPairPeople);

		assertEquals(null, result.firstPerson);
		assertEquals(null, result.secondPerson);
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(greg);
		Tinder tinder = new Tinder(list);

		Match result = tinder.Find(MatchingPreference.closestPairPeople);

		assertEquals(sue, result.firstPerson);
		assertEquals(greg, result.secondPerson);
	}

	@Test
	public void Returns_Furthest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(mike);
		list.add(greg);

		Tinder tinder = new Tinder(list);

		Match result = tinder.Find(MatchingPreference.furthestPairPeople);

		assertEquals(greg, result.firstPerson);
		assertEquals(mike, result.secondPerson);
	}

	@Test
	public void Returns_Furthest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);
		Tinder tinder = new Tinder(list);

		Match result = tinder.Find(MatchingPreference.furthestPairPeople);

		assertEquals(sue, result.firstPerson);
		assertEquals(sarah, result.secondPerson);
	}

	@Test
	public void Returns_Closest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);

		Tinder tinder = new Tinder(list);

		Match result = tinder.Find(MatchingPreference.closestPairPeople);

		assertEquals(sue, result.firstPerson);
		assertEquals(greg, result.secondPerson);
	}

}
