package Day1;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static FileInputStream fis;

    public static void main(String[] args) {
        try {
            fis = new FileInputStream("data/1/lists.txt");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Input data file not found!");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        try {
            String line;
            while((line = br.readLine()) != null) {
                boolean leftFinished = false;
                int number = 0;
                for(char c : line.toCharArray()) {
                    if(c == ' ') {
                        if(!leftFinished) {
                            left.add(number);
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
                right.add(number);
            }

        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading lines!");
        }

        if(left.size() != right.size()) {
            String message = "Number of left: " + left.size() + "\nNumber of right: " + right.size();
            JOptionPane.showMessageDialog(null, message);
            throw new Error(message);
        }

        Collections.sort(left);
        Collections.sort(right);

        int distance = 0;

        for (int i = 0; i < left.size(); i++) {
            System.out.printf("left=%d, right=%d\n", left.get(i), right.get(i));
            distance += Math.abs(left.get(i) - right.get(i));
        }

        JOptionPane.showMessageDialog(null, "Distance: " + distance);
    }
}
