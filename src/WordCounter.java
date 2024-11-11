import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static void main(String[] args) {
        // Change these file paths as needed
        String inputFilePath = "src/input.txt";
        String outputFilePath = "output.txt";

        try {
           
            Map<String, Integer> wordCounts = readAndCountWords(inputFilePath);

            
            writeWordCounts(outputFilePath, wordCounts);

            System.out.println("Word counting completed successfully.");

        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }

    private static Map<String, Integer> readAndCountWords(String inputFilePath) throws IOException {
        Map<String, Integer> wordCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.trim().toLowerCase(); // Convert to lowercase
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }

        return wordCounts;
    }

    private static void writeWordCounts(String outputFilePath, Map<String, Integer> wordCounts) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
        }
    }
}
