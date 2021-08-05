package project;
import java.io.*;
import java.util.*;

public class ScrabbleSolver {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter the pool of letters : ");
		String letters = sc.nextLine().toUpperCase();
		
		
		Map<Character , Integer> lettersCount = getCharacterCountMap(letters);
		
		System.out.println("\nPossible Words that can be made out of this word is : ");
		
		BufferedReader reader = new BufferedReader(new FileReader("C:/Users/18056/Downloads/dictionary.txt"));
		for(String currentWord = reader.readLine() ; currentWord != null ; currentWord = reader.readLine()) {
			Map<Character , Integer> currentWordCount = getCharacterCountMap(currentWord);
			boolean canMake = true;
			for(Character character : currentWordCount.keySet()) {
				int currentWordCharacterCount = currentWordCount.get(character);
				int lettersCharCount = lettersCount.containsKey(character) ? lettersCount.get(character) : 0;
				if(currentWordCharacterCount > lettersCharCount) {
					canMake = false;
					break;
				}
			}
			if(canMake) {
				System.out.println(currentWord);
			}
		}
		reader.close();
		sc.close();
	}

	private static Map<Character , Integer> getCharacterCountMap(String letters) {
		Map<Character , Integer> lettersCount = new HashMap<>();
		for(char ch : letters.toCharArray()) {
			lettersCount.put(ch, lettersCount.getOrDefault(ch, 0) + 1);
		}
		return lettersCount;
	}

}
