package main.java.cp125.chat;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Random;

/**
 * The ChatPeer is one 'user' in a 2-user conversation.  It is
 * actually a program (class) which mimics a real user, by 'saying'
 * things back to another User.
 */
 
public class ChatPeer {


	/** The input stream readerfilter. */
	private InputStreamReader inputStreamReaderfilter = null;
	
	/** The buffered readerfilter. */
	private BufferedReader bufferedReaderfilter = null;
	
	/** The conversation. */
	private Conversation conversation = null;
	
	/** The conversation file. */
	private File conversationFile = null;
	
	/**
	 * Instantiates a new chat peer.
	 *
	 * @param input the input
	 * @param output the output
	 */
	public ChatPeer( InputStream input, OutputStream output ) {
		this.input = input;
		this.output = output;

		// reading from the keyboard
		
		inputStreamReaderfilter = new InputStreamReader(this.input);
		bufferedReaderfilter = new BufferedReader(inputStreamReaderfilter);

		
	}

	/**
	 * Chat with.
	 *
	 * @param u the u
	 * @param save the save
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void chatWith( User u, boolean save ) throws IOException {
		
		Date startConvDate = new Date(System.currentTimeMillis());
		if (save){
			conversationFile = new File("conversation "+startConvDate+".txt");
		}
		conversation = new Conversation(u, u, startConvDate);
		print("Thanks for joining the chat "+u.getFirstName()+"\n");
		String line = "";
		while ((line = bufferedReaderfilter.readLine()) != null){
			if (conversation!=null){
				conversation.addLineToConversation(line+"\n");
			}
			String lowercaseline = line.toLowerCase();
			if ((lowercaseline.equals("exit")) || (lowercaseline.equals("quit")) || (lowercaseline.equals("ctrl-d")) || (lowercaseline.equals("ctrl-z"))){
				bufferedReaderfilter.close();
				break;
			}
			print(getReply(line));
		}
		print("Thank you for using the chat program, please come again!\n");
		Date endConvDate = new Date(System.currentTimeMillis());
		conversation.setEndTime(endConvDate);
		if (save){
			conversation.save(conversationFile);
		}

		
	}

	/*
	  Feel free to change this method, perhaps so it can reply with some
	  random replies??  Perhaps define an array of canned replies and
	  use a random number to sample from that array??
	*/
	/**
	 * Gets the reply.
	 *
	 * @param userSaid the user said
	 * @return the reply
	 */
	private String getReply( String userSaid ) {
		String replyArray[] = {"Really? You think " + userSaid, 
								"Please go on...", 
								"Tell me what you really think", 
								"I'm sorry"};
		Random rand = new Random();
		int randomNum = rand.nextInt(replyArray.length);
		return (replyArray[randomNum]+"\n");
	}
	
	/**
	 * Prints the.
	 *
	 * @param s the s
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void print(String s) throws IOException{
		s = "COM > "+s;
		if (conversation!=null){
			conversation.addLineToConversation(s);
		}
		output.write(s.getBytes());
	}
	
	/** The input. */
	private final InputStream input;
	
	/** The output. */
	private final OutputStream output;

}

// eof
