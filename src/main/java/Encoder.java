import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Brotherdos
 * @date: 06.10.2016.
 */
public class Encoder {
    private static Map<String, Integer> dictionary;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text;
        try {
            text = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            text = "";
        }
        FileWorker.write("encoded.txt", encode(text));
    }

    private static String encode(String text) {
        StringBuilder encodedText = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        Map<String, Integer> dictionary = new HashMap<String, Integer>();

        int i = 0;
        while (i < text.length()) {
            buffer.append(String.valueOf(text.charAt(i)));
            int code = 0;
            for (Map.Entry<String, Integer> word : dictionary.entrySet()) {
                if (buffer.equals(word.getKey())) {
                    code = word.getValue();
                    i++;
                    buffer.append(String.valueOf(text.charAt(i)));
                }
            }
            if (code == 0) {
                dictionary.put(buffer.toString(), dictionary.size() + 1);
                
            }
        }
        return encodedText.toString();
    }
}
