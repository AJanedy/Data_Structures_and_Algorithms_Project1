import java.io.*;


public class Main {

    // FIXME: allow recursion?
    private static String text;
    private static String[] arrayOfWords;

    // readFile opens the file and assigns each word to an array
    public static void readFile(String filePath) throws IOException {
        File textToParse = new File
                (filePath);
        BufferedReader reader = new BufferedReader(new FileReader(textToParse));

        while ((text = reader.readLine()) != null) {
            arrayOfWords = text.split(" ");
            for (int i = 0; i < arrayOfWords.length; i++) {
                System.out.println(arrayOfWords[i]);
            }
        }
    }
    public static void writeFile(String[] wordsArray) throws IOException{
        // Instantiating FileWriter object
        FileWriter fileWriter = new FileWriter("projectPrompt.txt_words.txt", true);
        // Instantiating PrintWriter object
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println(wordsArray.length);
        for (int i = 0; i < wordsArray.length; i++) {
            printWriter.println(wordsArray[i] + " " + i);
        }
        printWriter.close();
    }

    public static void main(String[] args) throws IOException {
        readFile("/Users/andrewjanedy/IdeaProjects/" +
        "Data_Structures_and_Algorithms_Project1/src/projectPrompt.txt");
        writeFile(arrayOfWords);
    }
}