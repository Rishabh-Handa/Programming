import java.util.*;

public class RedundantVowels {

    public static void main(String[] args) {
	Set<Character> vowles = new HashSet<>();

	vowles.add('a');
	vowles.add('e');
	vowles.add('i');
	vowles.add('o');
	vowles.add('u');

	System.out.println(vowles.contains('r'));


	String x = "aabccdaaaaiiaaaaaaoofeeeeee";

	char[] charArray = x.toCharArray();


	Map<Character, Integer> countVowels = new HashMap<>();

	for(int i=0; i<charArray.length; i++){
	    if(vowles.contains(charArray[i])){
	        char vowel = charArray[i];

	        int j=i+1;
	        int count = 1;
	        while(j<charArray.length && vowel == charArray[j]){
	            count++;
	            j++;
		}
		i=j-1;
		if(countVowels.containsKey(vowel)){
		    int existingCount = countVowels.get(vowel);
		    if(existingCount < count)
			countVowels.put(vowel, count);
		}else{
		    countVowels.put(vowel, count);
		}
	    }

	}

	Map.Entry h = countVowels.entrySet().stream().max(Comparator.comparing(a -> a.getValue())).get();
	System.out.println(countVowels);
	System.out.println(h);

    }
}
