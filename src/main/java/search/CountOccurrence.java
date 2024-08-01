package search;

public class CountOccurrence {
    public static void main(String[] args) {
        String word = "abcda";

        char letterToCount = 'a';
        System.out.println("Letter To Count "+letterToCount+" in Word: "+word);
        int letterCount = 0;

        for(int i = 0; i<word.length(); i++){
            if(word.charAt(i) == letterToCount){
                letterCount++;
            }
        }

        System.out.println("The Letter Count is " + letterCount);
    }
}
