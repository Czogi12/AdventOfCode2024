package Day1;

import java.util.ArrayList;

public class Lists {
    private ArrayList<Integer> left;
    private ArrayList<Integer> right;

    public Lists() {
        left = new ArrayList<>();
        right = new ArrayList<>();
    }

    public void addToLeft(int number) {
        left.add(number);
    }

    public void addToRight(int number) {
        right.add(number);
    }
}
