package test;
import java.util.HashMap;
import java.util.Map;

public class FrequenciesOfToken {
    public static void main(String[] args) {
        Map<String, Integer> tokenFrequencies = new HashMap<>();

        // Iterate over the command-line parameters
        for (String token : args) {
            // Check if the token already exists in the map
            if (tokenFrequencies.containsKey(token)) {
                // Increment the frequency count
                tokenFrequencies.put(token, tokenFrequencies.get(token) + 1);
            } else {
                // Add the token to the map with a frequency of 1
                tokenFrequencies.put(token, 1);
            }
        }

        // Display the token frequencies
        for (Map.Entry<String, Integer> entry : tokenFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}