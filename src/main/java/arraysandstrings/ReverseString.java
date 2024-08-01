package arraysandstrings;

public class ReverseString {
    public static void main(String[] args) {
        String word = "abcdefg";
        StringBuilder reversedWord = new StringBuilder();
        int stringIndex = word.length() - 1;

        System.out.println("Original Word: "+word);

        for(int i = stringIndex; i >= 0 ; i--) {
            reversedWord.append(word.charAt(i));
        }
        System.out.println("Reversed Word: "+reversedWord);
    }
}
