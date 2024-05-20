package week10;
public class HeapSort {

    /* Heapify function to build max heap */
    private static <Data extends Comparable<Data>> void heapify(Data[] elements, int n, int i) {
        int largest = i;    // Initialize largest as root
        int left = 2 * i + 1;  // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && elements[left].compareTo(elements[largest]) > 0)
            largest = left;

        // If right child is larger than largest so far
        if (right < n && elements[right].compareTo(elements[largest]) > 0)
            largest = right;

        // If largest is not root
        if (largest != i) {
            // Swap elements[i] and elements[largest]
            Data temp = elements[i];
            elements[i] = elements[largest];
            elements[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(elements, n, largest);
        }
    }

    /* Heap sort algorithm for generic-type data */
    public static <Data extends Comparable<Data>> void sort(Data[] elements) {
        int n = elements.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(elements, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            Data temp = elements[0];
            elements[0] = elements[i];
            elements[i] = temp;

            // Call max heapify on the reduced heap
            heapify(elements, i, 0);
        }
    }
}

