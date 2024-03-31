package week5;

    public class TimSort {

        public static <Data extends Comparable<Data>> void sort(Data[] elements, int threshold) {

            Data[] aux = (Data[]) new Comparable[elements.length];
            int runLength = calculateRunLength(elements.length, threshold);


            for (int i = 0; i < elements.length; i += runLength) {
                int remaining = Math.min(runLength, elements.length - i);
                insertionSort(elements, i, i + remaining - 1);
            }


            for (int size = runLength; size < elements.length; size *= 2) {
                for (int start = 0; start < elements.length; start += 2 * size) {
                    int mid = Math.min(start + size - 1, elements.length - 1);
                    int end = Math.min(start + 2 * size - 1, elements.length - 1);
                    merge(elements, aux, start, mid, end);
                }
            }


        }

        public static <Data extends Comparable<Data>> void insertionSort(Data[] elements, int low, int high) {

            for (int i = low + 1; i <= high; i++) {
                Data key = elements[i];
                int j = i - 1;

                while (j >= low && elements[j].compareTo(key) > 0) {
                    elements[j + 1] = elements[j];
                    j--;
                }

                elements[j + 1] = key;
            }
        }

        public static <Data extends Comparable<Data>> void merge(Data[] elements, Data[] aux, int low, int mid, int high) {

            for (int k = low; k <= high; k++) {             // 1
                aux[k] = elements[k];                       // 1
            }

            int i = low;                                    // 2
            int j = mid + 1;                                // 2
            for (int k = low; k <= high; k++) {             // 3
                if (i > mid) {                              // 4
                    elements[k] = aux[j++];                 // 4
                } else if (j > high) {                      // 5
                    elements[k] = aux[i++];                 // 5
                } else if (aux[j].compareTo(aux[i]) <= 0) {          // 6
                    elements[k] = aux[j++];                 // 6
                } else {                                    // 7
                    elements[k] = aux[i++];                 // 7
                }
            }

        }

        public static int calculateRunLength(int initialLength, int threshold) {


            if (initialLength <= threshold) {
                return initialLength;
            }

            int runLength = initialLength;
            int remainder = 0;

            while (runLength > threshold) {
                remainder |= (runLength & 1);
                runLength >>= 1;
            }

            return runLength + remainder;
        }


    }

