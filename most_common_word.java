import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * most_common_word
 */
public class most_common_word {

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[\\!?',;.]", " ").replace("  ", " ").toLowerCase();
	    String[] split = paragraph.split(" ");
	    HashMap<String, Integer> map = new HashMap<>();
	    HashSet<String> ban = new HashSet<>(Arrays.asList(banned));
	    int max = Integer.MIN_VALUE;
	    String mostW = "";
	    for (String word : split) {
		    if (!ban.contains(word)) {
			    map.put(word, map.getOrDefault(word, 0) + 1);
			    if (map.get(word) > max) {
				    max = map.get(word);
				    mostW = word;
			    }
		    }
	    }
	    return mostW;
    }
}