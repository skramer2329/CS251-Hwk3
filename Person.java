/*
 * A class that represents a person in a amusement park.
 * It maintains its age, height, and number of tickets.
 * A person can ride rides, share tickets, and grow over time.
 */

public class Person extends Ride {

	private int age;
	private double height;
	private int tickets;

	// this is a constructor because it has public and the constructor name
	// if you want to use default and specifying constructors, you must define both
	public Person(double height, int age, int tickets) {
		// TODO write this specifying constructor for this class
		// If any negative value is passed, make it positive instead
		if (height < 0 || age < 0 || tickets < 0) {
			height = Math.abs(height);
			age = Math.abs(age);
			tickets = Math.abs(tickets);
		}
		this.height = height;
		this.age = age;
		this.tickets = tickets;

	}

	public Person(double height, int age) {
		// TODO call the other constructor with these values
		this(height, age, 0);
	}

	/**
	 * getter for age
	 * 
	 * @return the age of this person
	 */
	public int getAge() {
		// TODO return the correct value
		return age;
	}

	/**
	 * getter for height
	 * 
	 * @return the height of this person
	 */
	public double getHeight() {
		// TODO return the correct value
		return height;
	}

	/**
	 * getter for tickets
	 * 
	 * @return the number of tickets of this person
	 */
	public int getTickets() {
		// TODO return the correct value
		return tickets;
	}

	/**
	 * A method that adds the given number of tickets to the number the person
	 * already has. If it's negative return without changing.
	 * 
	 * @param num of tickets to buy: must not be negative.
	 * @return true if they were able to buy tickets, false otherwise.
	 */
	public boolean buyTickets(int num) {
		// TODO finish this method
		if (num < 0) {
			return false;
		} else {
			this.tickets += num;
			return true;
		}

	}

	/**
	 * A method that adds the given years and height in cm to this person. If either
	 * parameter is negative, return without changing either.
	 * 
	 * @param years: must not be negative.
	 * @param height: must not be negative.
	 * @return true if the inputs are valid and growth happens, false otherwise.
	 */
	public boolean growth(double height, int years) {
		// TODO finish this method
		// (remember the "this" keyword)
		if (height < 0 || years < 0) {
			return false;
		} else {
			this.height += height;
			this.age += years;
			return true;
		}
	}

	/**
	 * takes in a ride, and checks all of its requirements against this person. If
	 * they are old enough, tall enough, and have enough tickets, subtract that
	 * amount of tickets and return true
	 * 
	 * @param ride to be ridden
	 * @return true if they were able to ride, false otherwise. return false if ride
	 *         is null
	 */
	public boolean attemptToRide(Ride ride) {
		// TODO finish this method
		if (ride == null) {
			return false;
		} else if (this.height >= ride.getHeightReq() && this.age >= ride.getAgeReq()
				&& this.tickets >= ride.getTicketReq()) {
			this.tickets -= ride.getTicketReq();
			return true;
		} else {

			return false;
		}
	}

	/**
	 * takes in a person, and attempts to give away a number of this persons tickets
	 * to that one. if the number is negative, call the other person's giveTickets
	 * method to give to this one
	 * 
	 * @param friend: the person to give the tickets to.
	 * @param amount: the amount of tickets to give. cannot be negative.
	 * @return false if this person does not have enough to give, or if friend is
	 *         null. true otherwise.
	 */
	public boolean giveTickets(Person friend, int number) {
		if (friend == null || this.tickets < number) {
			return false;
		} else if (number < 0) {
			if (friend.tickets + number >= 0) {
				return friend.giveTickets(this, Math.abs(number));

			} else {
				return false;
			}
		}
		friend.tickets += number;
		this.tickets -= number;
		return true;

	}

}
