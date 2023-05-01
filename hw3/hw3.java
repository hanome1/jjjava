import java.util.ArrayList;
import java.util.Arrays;

public class hw3 {
    
    public static int[] mergeSort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
        return result;
    }

    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++]
                    : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[11];
        for (int i = 0; i < 11; i++) {
            a[i] = (int) (Math.random() * 10);
        }

        //TASK1

        System.out.println("\ndefault array: " + Arrays.toString(a));
        System.out.println("sorted array: " + Arrays.toString(mergeSort(a)));

        //TASK2

        ArrayList<Integer> collection = new ArrayList<>(a.length);
        for (int i = 0; i < 11; i++) {
            collection.add(a[i]);
        }
        ArrayList<Integer> odd = new ArrayList<>(a.length);
        odd.addAll(collection);
        for (int i = 0; i < odd.size(); i++) {
            if (odd.get(i) % 2 == 0)
            odd.remove(i);
        }
        System.out.println("array of odds: "+odd);

        //TASK3

        collection.sort(null);
        System.out.printf("min element: %d\nmax element: %d\naverage element: %d", collection.get(0), collection.get(10), collection.get(6));
    }
}
