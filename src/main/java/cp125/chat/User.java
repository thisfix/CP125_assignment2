package main.java.cp125.chat;

/**
 * Each user has three attributes: first, last name and some unique
 * identifier, unique across all users in this chat program.
 */

public class User {

	/**
	 * Instantiates a new user.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param id the id
	 */
	public User( String firstName, String lastName, String id ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	String getLastName() {
		return lastName;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	String getId() {
		return id;
	}
		   
	/** The firstName, lastName and id. */
	private String firstName, lastName, id;
}

// eof
