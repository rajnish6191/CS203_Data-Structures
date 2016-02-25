package Assignment3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WordGuess1 extends JFrame implements ActionListener {
	JButton guessButton = new JButton("Guess");
	JTextField guessText = new JTextField(15);
	JTextArea messageArea = new JTextArea();
	String word = null;
	boolean continuePlay = true;
	StringBuffer dashes = null;
	final int MAXPARTS = 6;
	int bodyparts = MAXPARTS;
	boolean done;
	String guess;
	String guesses = "";
	String[] targetWords = {
		        "native", "country", "color", "example", "helper",
		        "favorite", "charcoal", "smoke", "interest", "video",
		        "language", "drink", "homework","shell", "sympathy",
		        "define", "specify", "drawing", "picture", "frame",
		        "nutshell", "polygon", "circle", "rectangle", "sphere",
		        "sherry", "lotion", "shoes", "trowsers", "belt",
		        "blouse", "nightgown", "cowboy", "engineer", "waiter",
		        "wheel", "engine", "pedal", "street", "navigate",
		        "sailing", "skiing", "outboard", "runner", "dancer",
		        "hero", "helpless", "pseudonym", "lioness", "integrity"
		        }; 
	int index = 0;
	public WordGuess1() throws HeadlessException {
		super("word guess game");
		setLayout(new BorderLayout());
		JPanel jPanel = new JPanel(new FlowLayout());
		jPanel.add(guessText);
		jPanel.add(guessButton);
		add(jPanel, BorderLayout.NORTH);
		messageArea.setEditable(false);
		add(messageArea, BorderLayout.CENTER);
		setVisible(true);
		setSize(400, 200);
		init();
		guessButton.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void init(){
		nextWord(false);
	}
	
	private void nextWord(boolean bSuccess){
		word = targetWords[index++];
		continuePlay = true;
		dashes = makeDashes(word);
		StringBuilder mesaage = new StringBuilder();
		mesaage.append("Here is your word: " + dashes+"\n");
		mesaage.append("Guesses so far: " + guesses+"\n");
		mesaage.append("enter a guess (letter or word):\n ");	
		messageArea.setText(mesaage.toString());
	}

	public static void main(String[] args) throws IOException {
		new WordGuess1();	
	} 

	public void matchLetter(String secret, StringBuffer dashes,
			char letter) {
		for (int index = 0; index < secret.length(); index++)
			if (secret.charAt(index) == letter)
				dashes.setCharAt(index, letter);
	}

	public StringBuffer makeDashes(String s) {
		StringBuffer dashes = new StringBuffer(s.length());
		for (int count = 0; count < s.length(); count++)
			dashes.append('-');
		return dashes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		char letter;
		StringBuilder mesaage = new StringBuilder();
		guess = guessText.getText();
		
		if (guess.length() > 1) 
		{
			if (guess.equals(word))
				mesaage.append("you win!\n");
			else
				mesaage.append("you lose\n");
			done = true;
		} else 
		{
			letter = guess.charAt(0);
			guesses += letter;
			if (word.indexOf(letter) < 0) 
			{
				--bodyparts;
				mesaage.append("bad guess - \n");
			} else 
			{
				matchLetter(word, dashes, letter);
				mesaage.append("good guess - \n");
			}
			mesaage.append(bodyparts + " bodyparts are left\n");
			if (bodyparts == 0) {
				mesaage.append("you lose\n");
				done = true;
			}
			if (word.equals(dashes.toString())) {
				mesaage.append("you win!\n");
				done = true;
			}
		} 
		if(done){
			guesses = "";
			done = false;
			bodyparts = MAXPARTS;
			JOptionPane.showMessageDialog(this,mesaage.toString());
			if (index  < targetWords.length) {
				int msgAlert = JOptionPane.showConfirmDialog(this, "Play Again?");
				if(msgAlert == JOptionPane.NO_OPTION){
					JOptionPane.showMessageDialog(this, "Good Bye");
					System.exit(0);
				}
			} else{
				JOptionPane.showMessageDialog(this,"thanks for playing (no more words)");
				System.exit(0);
			}
			nextWord(true);
		}else{
			mesaage.append("Here is your word: " + dashes+"\n");
			mesaage.append("Guesses so far: " + guesses+"\n");
			mesaage.append("enter a guess (letter or word):\n ");
		}
		messageArea.setText(mesaage.toString());
	}
}