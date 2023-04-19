import java.util.ArrayList;
import java.util.HashMap;

public class WordCounter{
	public static void main(String[] args){
		// call each method
		ArrayList<String> words = createWordList();
		HashMap<String, Integer> wordCount = countOccurrences(words);
		printWordCount(wordCount);

	}

	public static ArrayList<String> createWordList(){
		ArrayList <String> words = new ArrayList<>();
		words.add("Hello");
		words.add("goodbye");
		words.add("Thanks");
		words.add("Cool");
		words.add("Thanks");
		words.add("Hello");

		return words;
	}

	public static HashMap<String, Integer>  countOccurrences(ArrayList<String> words){
		HashMap<String, Integer> wordCount = new HashMap<>();


		// how to add the unique words and their counts?
		for (String word : words){
			if(wordCount.containsKey(word)){
				int count = wordCount.get(word);
				wordCount.put(word,count+1);

			} else{
				wordCount.put(word,1);
			}
		}
		return wordCount;
		
	}

	public static void printWordCount(HashMap<String, Integer> wordCount){
		// code for printing word count
		for (String word: wordCount.keySet()){
			System.out.println(word + " Count is : " + wordCount.get(word));
		}
	}


}