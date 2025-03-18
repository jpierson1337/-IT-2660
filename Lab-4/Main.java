import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Unsorted Array ---------------------------------------------------");
        ArrayList<Integer> integerList = Lab4.getList();
        Lab4.outputList(integerList);

        System.out.println("\n\nBubble sort results ----------------------------------------------");
        ArrayList<Integer> bubbleSortedList = new ArrayList<>(integerList);
        long bubbleStart = System.nanoTime();
        Lab4.bubbleSort(bubbleSortedList);
        long bubbleEnd = System.nanoTime();
        Lab4.outputList(bubbleSortedList);
        System.out.println("\nBubble Sort Time: " + (bubbleEnd - bubbleStart) + " ns");

        System.out.println("\n\nInsertion sort results -------------------------------------------");
        ArrayList<Integer> insertionSortedList = new ArrayList<>(integerList);
        long insertionStart = System.nanoTime();
        Lab4.insertionSort(insertionSortedList);
        long insertionEnd = System.nanoTime();
        Lab4.outputList(insertionSortedList);
        System.out.println("\nInsertion Sort Time: " + (insertionEnd - insertionStart) + " ns");
    }
}

class Lab4 {
    public static void insertionSort(ArrayList<Integer> integerList) {
        int n = integerList.size();
        for (int i = 1; i < n; i++) {
            int key = integerList.get(i);
            int j = i - 1;
            while (j >= 0 && integerList.get(j) > key) {
                integerList.set(j + 1, integerList.get(j));
                j = j - 1;
            }
            integerList.set(j + 1, key);
        }
    }

    public static void bubbleSort(ArrayList<Integer> integerList) {
        int n = integerList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (integerList.get(j) > integerList.get(j + 1)) {
                    int temp = integerList.get(j);
                    integerList.set(j, integerList.get(j + 1));
                    integerList.set(j + 1, temp);
                }
            }
        }
    }

    public static ArrayList<Integer> getList() {
        ArrayList<Integer> integerList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
            while ((line = br.readLine()) != null) {
                integerList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integerList;
    }

    public static void outputList(ArrayList<Integer> integerList) {
        for (int num : integerList) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
