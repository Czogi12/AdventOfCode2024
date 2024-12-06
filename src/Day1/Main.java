package Day1;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {


    public static void main(String[] args) {


        ;

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        try {


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
