package arrays;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequences {
    static int counter = 0;
    public static void printSubsequences(int[] arr) {
        List<Integer> current = new ArrayList<>();
        generate(0, arr, current);
    }

    private static void generate(int index, int[] arr, List<Integer> current) {
        if (index == arr.length) {
            counter++;
            System.out.println(current);
            return;
        }

        // Include the current element
        current.add(arr[index]);
        generate(index + 1, arr, current);

        // Exclude the current element
        current.remove(current.size() - 1);
        generate(index + 1, arr, current);
    }

    public static void main(String[] args) {
        printSubsequences(new int[]{1,2,4,8});
        System.out.println(counter);
    }
}
