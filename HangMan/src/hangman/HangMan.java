package hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangMan {

	public static void main(String[] args) {
		int lives = 6;
		List<String> words = new ArrayList<String>();		
		List<Character> correct = new ArrayList<Character>();
		List<Character> incorrect = new ArrayList<Character>();
		words.addAll(Arrays.asList("GRAPES", "ORANGE", "HOUSE", "PAPERS", "HANGMAN", "PENCIL", "CHILDREN", "CRAYONS",
				"FOOTBALL", "OATMEAL", "COMPUTER", "SCHOOL", "AUTOMOBILE", "ZEBRA", "PURPLE", "STORIES", "TELEPHONE",
				"PARENTS", "VACATION", "HAWAII", "ELEPHANT", "WALKING", "BICYCLE", "RECREATION", "CHURCHES"));
		Random rand = new Random();
		int randIndex = rand.nextInt(26);
		String word = words.get(randIndex); 
		
		for (int i = 0; i < word.length(); i++) correct.add('_');
		
		System.out.println("Welcome to Hangman.");
		System.out.println();
		
		while (lives > 0 && correct.contains('_')){
			System.out.println("You have " + lives + " lives left.");
			for (Character e : correct) System.out.print(e + " ");
			System.out.println();
			System.out.println();
			boolean wrong = true;
			Character c = nextLetter();
			while(correct.contains(c) || incorrect.contains(c)) {
				System.out.println("You have already guessed "+ c + ".");
				c = nextLetter();
			}
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == c) {
					correct.set(i, c);
					wrong = false;
				}
			}
			if (wrong) {
				incorrect.add(c);
				lives--;
			}
				
		}
		
		if (lives == 0) System.out.println("Sorry, you died.");
		else System.out.println("Congratulations! You guessed " + word);
			
	}

	private static Character nextLetter() {
		Scanner in = new Scanner(System.in);
		boolean isChar = false;
		String s = "";
		System.out.println("Please enter a letter.");
		while(!isChar) {
			s = in.next();
			if (s.length() != 1) {
				System.out.println("Please enter a single letter.");
			}else isChar = true;
		}		
		return Character.toUpperCase(s.charAt(0));
		
	}	
}
