import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class StringModification {

	/**
	 * @param args
	 */
		/*
	 * Each word in the input string is replaced with the following: the first
	 * letter of the word, the count of distinct letters between the first and
	 * last letter, and the last letter of the word. For example,“Automotive
	 * parts" would be replaced by "A6e p3s".
	 */
	public static void main(String[] args) {

		// String inputString ="Automo9tive parts$#";
		String inputString = "Automotive parts";
		String[] allwordsincludingDelimiters = null;
		allwordsincludingDelimiters = stringTokens(inputString);

		// String[] allwords= inputString.split("\\P{Alpha}+");
		String finalOutputString = "";
		for (String word : allwordsincludingDelimiters) {
			if (Character.isAlphabetic(word.charAt(0))) {
				finalOutputString = finalOutputString + modifiedString(word);

			} else {
				finalOutputString = finalOutputString + word;
			}
		}
		System.out.println(finalOutputString);

	}
	/*A "word" is defined as a sequence of alphabetic characters,
	 delimited by any non-alphabetic characters. */
   // returns all string tokens includs alphabetic words and non-alphabetic delimiters
	/**
	 * @param input String
	 * return   String[]
	 */
	private static String[] stringTokens(String input) {
		String inputString = input;
		ArrayList<String> wordsArrayList = new ArrayList<String>();
		StringBuffer alpha = new StringBuffer();
		StringBuffer special = new StringBuffer();

		for (int i = 0; i < inputString.length(); i++) {
			if (Character.isAlphabetic(inputString.charAt(i))) {
				if (special.length() > 0) {
					wordsArrayList.add(special.toString());
					special = new StringBuffer();

				}
				alpha.append(inputString.charAt(i));

			} else {
				special.append(inputString.charAt(i));
				inputString = inputString.substring(i);
				i = 0;
				if (alpha.length() > 0) {
					wordsArrayList.add(alpha.toString());
					alpha = new StringBuffer();

				}

			}

		}
		if (special.length() > 0)
			wordsArrayList.add(special.toString());
		if (alpha.length() > 0)
			wordsArrayList.add(alpha.toString());
		String[] returnStringarray = (String[]) wordsArrayList
				.toArray(new String[wordsArrayList.size()]);
		return returnStringarray;
	}
	/* Each word in the input string is returned with the following requirement: 
	  the first letter of the word, the count of distinct letters 
	  between the first and last letter, and the last letter of the word.
	  For example,“Automotive " would be returned by "A6e". */	
	/**
	 * @param input String
	 * @return  String
	 */
	private static String modifiedString(String input) {

		String outputString = "";
		String inputString = input;
		char firstletter = inputString.charAt(0);
		char lastLetter = '\0';
		int distinctLetterCount = 0;

		if (inputString.length() > 1)
			lastLetter = inputString.charAt(inputString.length() - 1);
		String subString = inputString.substring(1, inputString.length() - 1);
		char[] charArray = subString.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for (char c : charArray) {
			set.add(c);
		}
		distinctLetterCount = set.size();

		outputString = firstletter + String.valueOf(distinctLetterCount)
				+ lastLetter;

		return outputString;
	}

}
