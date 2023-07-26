import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;
import java.io.BufferedReader;

public class Main {
    // FIXME: Use mergeSort to combine the index and word arrays, sort them alphabetically
    public static void mergeSort(String[] wordsArray, int[] indexArray, int left, int right) {

    }
    public static void merge(String[] wordsArray, int[] indexArray, int left, int middle, int right) {

    }
    //FIXME: removeDuplicates will maintain alphabetical order, but remove duplicates, adding addition indices to
    //FIXME: each line
    public static void removeDuplicates() {

    }
    // FIXME: querySearch will allow the user to input a word and return its indices
    public static void querySearch() {

    }
    // FIXME: this will modify querySearch to print the surrounding words from the search word
    public static void printQueriedSentence() {

    }

    // Extracts filename from filepath for use in naming new files
    public static String extractFileName(String filepath) {
        // Find the index of the last occurence of \\
        int lastBackslashIndex = filepath.lastIndexOf("\\");
        // Extract the substring following this last backslash
        String filename = filepath.substring(lastBackslashIndex + 1);

        return filename;
    }

    // Removes non-alphanumeric characters from the beginning and end of a string
    public static String removeNonalpha(String input) {
        // Defines a pattern to match non-alphanumeric characters
        Pattern pattern = Pattern.compile("^[^a-zA-Z0-9]*|[^a-zA-Z0-9]*$");
        // Creates an object to find the matches in the string
        Matcher matcher = pattern.matcher(input);

        return matcher.replaceAll("");
    }
    // readFile opens the file and assigns each word to ArrayList
    public static void readFile(String filePath) throws IOException {
        // Declares and defines an arrayList that will later be converted to an array
        ArrayList<String> listOfWords = new ArrayList<>();

        try {
            // Creates a File object to be passed into the Scanner object
            File textToParse = new File(filePath);
            // File is then passed into the Scanner object
            Scanner scanner = new Scanner(textToParse);

            // Reads each word and adds it to the ArrayList "listOfWords
            while (scanner.hasNext()) {
                String word = scanner.next();
                listOfWords.add(word);
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return;
        }
        // Converts the ArrayList into a fixed Array
        String[] wordsArray = listOfWords.toArray(new String[0]);

        // Calling the writeFile method, passing in the newly created array and the filename, extracted from the filepath
        writeFile(wordsArray, extractFileName(filePath));
    }
    //  writeFile uses the passed Array and filename to create a new file that holds each word and their indices,
    //  preceded by the length of the array (number of words)
    public static void writeFile(String[] wordsArray, String filename) throws IOException{
        // Creating a string to hold the new filename
        String stringFileName = filename + "_words.txt";

        // Instantiating FileWriter object
        FileWriter fileWriter = new FileWriter(stringFileName, false);
        // This line simply writes at the top of the file how many words items are in the array (number of words)
        fileWriter.write(wordsArray.length + "\n");
        // This loop adds words and indices to the file provided the line is not blank
        // It also strips any word of any leading and trailing non-alphanumeric using the removeNonalpha method
        for (int i = 0; i < wordsArray.length; i++) {
            if (!wordsArray[i].isBlank()) {
                fileWriter.write(removeNonalpha(wordsArray[i].strip()) + " " + i + "\n");
            }
        }
        fileWriter.close();
        // Calling the writeAlphabetically method, passing in the filename as a String,
        // and the length of the given array
        writeAplabetically(stringFileName, wordsArray.length, filename);
    }
    // This method takes the newly created file and creates another, putting the words alphabetically
    // while maintaining the original indices as given by the original file
    // FIXME: Implement mergeSort
    public static void writeAplabetically(String fileName, int length, String extractedFileName) throws IOException {
        // Creating an array for each the word and the index
        String[] listOfWords = new String[length];
        int[] listOfIndices = new int[length];

        try {
            File textToParse = new File(fileName);
            Scanner scanner = new Scanner(textToParse);

            while (scanner.hasNext()) {
                for (int i = 0; i < length; i++) {
                    if (scanner.hasNext()) {
                        String wordAndIndex = scanner.nextLine();
                        String[] wordAndIndexArray = wordAndIndex.split(" ");
                        if (wordAndIndexArray.length == 2) {
                            listOfWords[i] = wordAndIndexArray[0];
                            listOfIndices[i] = Integer.parseInt(wordAndIndexArray[1]);
                        }
                    }
                }
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return;
        }
    }
    public static void main(String[] args) throws IOException {

        readFile("C:\\Users\\andyj\\IdeaProjects\\" +
                "Data_Structures_and_Algorithms_Project1\\src\\aliceInWonderland.txt");
    }
}