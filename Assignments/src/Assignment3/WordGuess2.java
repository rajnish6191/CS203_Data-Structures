package Assignment3;

import java.util.*;
public class WordGuess2 {
    public static String word = null;
    public static void main(String[] args) 
    {
        wordOne();
    }
   
    public static void wordOne() 
    {
    	Scanner input = new Scanner(System.in);
        System.out.println("<===== Ready to Play Guessing Word Game =====>");
        System.out.println("Type the word to use: ");
        word = input.nextLine();
       
        int tries = 0;
        boolean gotIt = false;
        String inputWord;
        char letter;
        Scanner input1 = new Scanner(System.in);
        System.out.println("You have 7 tries remaining!!!!!!!!!");
        String missedLetters="";
        StringBuffer X;
        X=makeX(word);
        while (tries <= 7) 
        {
        	 if(word.equals(X.toString()))
    		 {
    			 System.out.println("you win");
    			 gameOver();
    			
    		 }
            System.out.println("Enter a letter you think that will contain: ");
            System.out.println("");
            inputWord = input1.nextLine();
            letter=inputWord.charAt(0);
            	if(tries >= 6)
            	{
            		System.out.println("You have reached the maximum number of tries.");
            		System.out.println("GAME OVER");
            		gameOver();
            		break;
            	}
               
            	if(word.contains(inputWord))
				{
                stringMatch(word, X,letter);
				}
            	
            	else
            	{
            	missedLetters=missedLetters+inputWord;
                System.out.println("Oops! Wrong Guessing.Your missed Letters:"+missedLetters);
                tries++;
            	}
        }
    }

    public static void stringMatch(String word, StringBuffer X, char letter)
    {
       for (int index = 0; index < word.length(); index++)
          if (word.charAt(index) == letter)
          {
             X.setCharAt(index, letter);
          }
       System.out.println("good guess - "+X);
       
       
    }
     public static StringBuffer makeX(String word)
    {
       StringBuffer X = new StringBuffer(word.length());
       for (int count=0; count < word.length(); count++)
          X.append('x');
       return X;
    }
 	
    public static void gameOver() 
    {
        
        System.out.println("Do you want to play again?:");
        String statement=null;
        String info="yes";
        Scanner s1 = new Scanner(System.in);
		statement = s1.nextLine();
		if(info.equals(statement))
		{
			wordOne();
		}
		else
		{
			System.out.println("Thanks for playing with us");
		}  
    } 
}