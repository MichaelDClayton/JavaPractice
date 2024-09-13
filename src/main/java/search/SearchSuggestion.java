package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchSuggestion {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        String[] products = {"mouse", "monitor", "movie", "mouthwash", "mountain", "mount"};

        for(int i =0;i<3;i++){
            //List<String> searchResults = suggestedProducts(products, "m");

            List<String> searchResultsNew = suggestedProductsNew(products, "mount");
         /*
             System.out.println("results: "+searchResultsNew);
        */
        }

        final long elapsedTimeMillis = System.currentTimeMillis() - startTime;
        System.out.println("elapsedTimeMillis: "+elapsedTimeMillis);
    }

    public static List<String> suggestedProducts(String[] products, String searchWord) {
        int maxResultsSize = 3;
        List<String> results = new ArrayList<>();

        //sort products
        Arrays.sort(products);
        for(String product : products) {
            if(product.startsWith(searchWord))
                results.add(product);
        }
        //sort results
        Collections.sort(results);
        if(results.size()>maxResultsSize)
            return results.subList(0, maxResultsSize);
        return results;
    }

    public static List<String> suggestedProductsNew(String[] products, String searchWord) {
        int maxResultsSize = 3;
        List<String> results = new ArrayList<>();

        //sort products
        Arrays.sort(products);
        for(String product : products) {
            if(checkProductMatch(product, searchWord))
                results.add(product);
        }
        //sort results
        Collections.sort(results);
        if(results.size()>maxResultsSize)
            return results.subList(0, maxResultsSize);
        return results;
    }

    public static boolean checkProductMatch(String product, String searchWord) {
        int searchWordLength = searchWord.length();
        int counter = 0;

        while(counter < searchWordLength) {
            if(searchWord.charAt(counter) != product.charAt(counter))
                return false;
            counter++;
        }

        return true;
    }
}
