package main.java.cp125.chat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * A Conversation is between two Users and has a known duration (end
 * time minus start time).
 */

public class Conversation {

	/**
	 * Instantiates a new conversation.
	 *
	 * @param u1 the u1
	 * @param u2 the u2
	 * @param startTime the start time
	 */
	public Conversation( User u1, User u2, Date startTime ) {
		this.u1 = u1;
		this.u2 = u2;
		this.startTime = startTime;
		addLineToConversation("Conversation with "+u1.getFirstName()+" and "+u2.getFirstName()+" started at "+startTime.toString()+"\n");
	}

	/**
	 * Sets the end time.
	 *
	 * @param endTime the new end time
	 */
	public void setEndTime( Date endTime ) {
		this.endTime = endTime;
	}
	
	/**
	 * Adds the line to conversation.
	 *
	 * @param s the s
	 */
	public void addLineToConversation(String s){
		conversationHistory = conversationHistory+s;
	}
	
	/**
	 * Gets the conversation history.
	 *
	 * @return the conversation history
	 */
	public String getConversationHistory(){
		return conversationHistory;
	}

	/**
	 * Save.
	 *
	 * @param f the f
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void save( File f ) throws IOException {
		addLineToConversation("Conversation ended at "+endTime.toString()+"\n");
		FileWriter fw = new FileWriter( f );
		PrintWriter pw = new PrintWriter( fw );
		pw.println( getConversationHistory() );
		pw.close();	
	}

	/**
	 * Load.
	 *
	 * @param f the f
	 * @return the conversation
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Conversation load( File f ) throws IOException {
		return null;
	}

	/** The u2. */
	private final User u1, u2;
	
	/** The start time. */
	private final Date startTime;
	
	/** The end time. */
	private Date endTime;
	
	/** The conversation history. */
	private String conversationHistory = "";

}

// eof
