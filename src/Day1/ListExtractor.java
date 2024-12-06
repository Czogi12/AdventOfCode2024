package Day1;

import javax.swing.*;
import java.io.*;

public class ListExtractor {
    private static FileInputStream fis;

    private static BufferedReader openFile() throws FileNotFoundException {
            fis = new FileInputStream("data/1/lists.txt");
            return new BufferedReader(new InputStreamReader(fis));
    }

    public static void fillOutLists(Lists lists) throws IOException {
        BufferedReader br = openFile();
        String line;
        while((line = br.readLine()) != null) {
            boolean leftFinished = false;
            int number = 0;
            for(char c : line.toCharArray()) {
                if(c == ' ') {
                    if(!leftFinished) {
                        lists.addToLeft(number);
                        number = 0;
                    }
                    leftFinished = true;
                    continue;
                }
                int digit = c - 48;

                if (digit < 0 || digit > 9) {
                    throw new NumberFormatException();
                }

                number *= 10;
                number += digit;
            }
            lists.addToRight(number);
        }
    }
}
