package main.java.cp125.chat;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * The entry point into this week's chat program.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 */
	static public void main( String[] args ) throws FileNotFoundException {
		InputStream is = System.in;
		OutputStream os = System.out;
		
		ChatPeer main = new ChatPeer( is, os );
		
		/*
		  Build a User to represent the person running the program.
		  You need 3 attributes for that user.  Hint: derive the
		  user logged in and use that string for all three fields
		*/
		String userName = System.getProperty("user.name");
		User u = new User(userName,userName, userName);

		boolean save = true;
		try {
			main.chatWith( u, save );
		} catch( IOException ioe ) {
			System.err.println( ioe );
		}

		try {
			os.close();
			is.close();
		} catch( IOException ioe ) {
			
		}
	}
}

// eof
