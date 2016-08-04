package javaapplication1;

import java.util.*;
import static java.lang.System.out;

class Person{

	public String firstName;
	public String lastName;
	public int age;

	private Person(String paramFirstName, String paramLastName, int paramAge){
		this.firstName = paramFirstName;
		this.lastName = paramLastName;
		this.age = paramAge;
	}

	public static int compareFirstNames(Person paramLeftSide, Person paramRightSide){
		return paramLeftSide.firstName.compareTo(paramRightSide.firstName);
	}

	public static void printPerson(Person p){
		String outString;
		outString = "********************************************************************\n"
			   + "First Name: " + p.firstName + "\n"
			   + "Last Name: " + p.lastName + "\n"
			   + "Age: " + p.age + "\n";
		out.println(outString);
	}

	public static void main(String[] args){
		Person[] people = new Person[]{
			new Person("Ted", "Neward", 41),
			new Person("Charlotte", "Neward", 41),
			new Person("Michael", "Neward", 19),
			new Person("Matthew", "Neward", 13)
		};
		// Sort by first name
		Arrays.sort(people, Person::compareFirstNames);
		for(Person p : people){
			printPerson(p);
		}
	}
}
