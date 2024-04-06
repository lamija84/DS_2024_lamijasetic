package week6;
import java.util.Random;
public class DualPivotQuickSort {


    public static <Data extends Comparable<Data>> void sort(Data[] elements) {
        shuffle(elements);
        sort(elements, 0, elements.length - 1);
    }


    private static <Data extends Comparable<Data>> void shuffle(Data[] elements) {
        Random rand = new Random();
        for (int i = 0; i < elements.length; i++) {
            int r = i + rand.nextInt(elements.length - i);
            swap(elements, i, r);
        }
    }


    private static <Data extends Comparable<Data>> void sort(Data[] elements, int low, int high) {
        if (low < high) {
            int[] pivots = partition(elements, low, high);
            sort(elements, low, pivots[0] - 1);
            sort(elements, pivots[0] + 1, pivots[1] - 1);
            sort(elements, pivots[1] + 1, high);
        }
    }


    public static <Data extends Comparable<Data>> int[] partition(Data[] elements, int low, int high) {
        if (elements[low].compareTo(elements[high]) > 0) {
            swap(elements, low, high);
        }

        Data leftPivot = elements[low];
        Data rightPivot = elements[high];

        int i = low + 1;
        int j = high - 1;
        int k = low + 1;

        while (k <= j) {
            if (elements[k].compareTo(leftPivot) < 0) {
                swap(elements, k, i);
                i++;
            } else if (elements[k].compareTo(rightPivot) > 0) {
                swap(elements, k, j);
                j--;
                k--;
            }
            k++;
        }
        i--;
        j++;

        swap(elements, low, i);
        swap(elements, high, j);

        return new int[]{i, j};
    }

    private static <Data extends Comparable<Data>> void swap(Data[] elements, int i, int j) {
        Data tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;

    }
}

