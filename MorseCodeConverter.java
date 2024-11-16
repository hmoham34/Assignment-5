import java.io.*;
import java.util.ArrayList;

/**
 * The MorseCodeConverter class contains methods to convert Morse code to English. 
 * It uses a static instance of MorseCodeTree to perform the translations.
 * 
 * @author Hussain
 */
public class MorseCodeConverter {

    private static final MorseCodeTree MORSE_TREE = new MorseCodeTree();

    /**
     * Converts a Morse code string into English.
     * Each letter is delimited by a space (' '), and each word is delimited by a '/'.
     * Example:
     * Input: ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
     * Output: "Hello World"
     *
     * @param morseCode the Morse code string to convert
     * @return the English translation
     */
    public static String convertToEnglish(String morseCode) {
        StringBuilder englishTranslation = new StringBuilder();

        // Split into words by "/"
        String[] words = morseCode.split(" / ");

        for (String word : words) {
            // Split each word into letters by " "
            String[] letters = word.split(" ");
            for (String letter : letters) {
                // Fetch corresponding letter from the tree
                englishTranslation.append(MORSE_TREE.fetch(letter));
            }
            // Add a space after each word
            englishTranslation.append(" ");
        }
        // Trim trailing space and return
        return englishTranslation.toString().trim();
    }

    /**
     * Converts Morse code in a file into English.
     * Each letter is delimited by a space (' '), and each word is delimited by a '/'.
     *
     * @param codeFile the file containing Morse code
     * @return the English translation of the file content
     * @throws FileNotFoundException if the file does not exist
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        StringBuilder englishTranslation = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(codeFile)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Convert each line of Morse code to English and append
                englishTranslation.append(convertToEnglish(line)).append("\n");
            }
        } catch (IOException e) {
        }

        // Trim trailing newline and return
        return englishTranslation.toString().trim();
    }

    /**
     * Prints the contents of the Morse code tree in LNR (Inorder) order with spaces between items.
     * This is used for testing the structure of the tree.
     * Example output: "h s v i f u e l r a p w j b d x n c k y t z g q m o"
     *
     * @return a string representing the tree's contents in LNR order
     */
    public static String printTree() {
        ArrayList<String> treeContents = MORSE_TREE.toArrayList();
        return String.join(" ", treeContents);
    }

    public static MorseCodeTree getMORSE_TREE() {
        return MORSE_TREE;
    }
}
