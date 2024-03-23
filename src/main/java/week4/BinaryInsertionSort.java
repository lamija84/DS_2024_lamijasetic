package week4;

public class BinaryInsertionSort {
    public static <Data extends Comparable<Data>> void sort(LinkedList<Data> ll) {
        // your code here
        int lengthLL=ll.count();
        for (int i = 0; i < lengthLL; i++) {

            Data key = ll.get(i);
            int j = findInsertionPoint(ll, i - 1, key);
            ll.remove(i);
            ll.add(j, key);

        }
    }

    public static <Data extends Comparable<Data>> int findInsertionPoint(LinkedList<Data> ll, int high, Data key) {
        // your code here (next line is a placeholder)

        int low = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Data midValue = ll.get(mid);
            int cmp = key.compareTo(midValue);
            if (cmp==0) {
                return mid;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                low=mid+1;
            }
        }
        return low;
    }
}