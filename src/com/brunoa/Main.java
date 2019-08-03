package com.brunoa;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        String[] stringRadixArray = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};


//        quickSort(intArray, 0 , intArray.length);
//        for (int i = 0; i < intArray.length; i++)
//            System.out.println(intArray[i]);
//
//        int[] countingArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
//        countingSort(countingArray, 1, 10);
//
//        for (int i = 0; i < countingArray.length; i++)
//            System.out.println(countingArray[i]);

//        int[] radixArray = {4725, 4586, 1330, 8792, 1594, 5729};
//        radixSort(radixArray, 10, 4);
//        for (int i = 0; i < radixArray.length; i++)
//            System.out.println(radixArray[i]);

//        Arrays.parallelSort(intArray);
//        for (int i = 0; i < intArray.length; i++)
//            System.out.println(intArray[i]);

//        mergesort(intArray, 0 , intArray.length, false);
//        for (int i = 0; i < intArray.length; i++)
//            System.out.println(intArray[i]);

        radixSort(stringRadixArray, 26, 5);
        for (int i = 0; i < stringRadixArray.length; i++)
            System.out.println(stringRadixArray[i]);
//        insertionsort(intArray, 7);
//        for (int i = 0; i < intArray.length; i++)
//            System.out.println(intArray[i]);

    }


    private static void swap(int[]array, int a, int b) {
        if (array[a] == array[b])
                return;
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static void bubblesort (int[] array) {
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++)
                if (array[i] > array[i + 1])
                    swap(array, i, i+1);
        }

    }

    private static void selectionsort(int[] array) {

        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (array[i] > array[largest]) {
                    largest = i;
                }
            }
            swap(array, largest, lastUnsortedIndex);
        }
    }

    private static void insertionsort(int[] array) {
        for (int firstUnsortedIndex = 0; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            int newElement = array[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 &&  array[i - 1] > newElement; i--) {
                array[i] = array[i - 1];
            }
            array[i] = newElement;
        }
    }

    private static void  insertionsort(int[] array, int numItems) {
        if (numItems < 2) return;

        insertionsort(array, numItems - 1);

        int newElement = array[numItems - 1];
        int i;

        for (i = numItems - 1; i > 0 &&  array[i - 1] > newElement; i--) {
            array[i] = array[i - 1];
        }
        array[i] = newElement;

    }

    private static void shellsort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int newElement = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = newElement;
            }
        }
    }

    private static int iterativeFactorial(int num) {
        if (num == 0) {
            return 1;
        }
        int factorial = 1;
        for (int i = 1; i <=  num; i++) {
            factorial  *=  i;
        }
        return factorial;
    }

    private static int factorial(int num) {
        if (num < 2) {
            return 1;
        }
        return num * (factorial(num - 1));
    }

    private static int nfactorial(int n) {
        System.out.println(n);
        if (n < 2) return 1;
        return n * nfactorial(n-1);
    }

    private static void mergesort(int[] input, int start, int end) {
        mergesort(input, start, end, true);
    }

    private static void mergesort(int[] input, int start, int end, boolean asc) {
        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;
        mergesort(input, start, mid, asc);
        mergesort(input, mid, end, asc);
        merge(input, start, mid, end, asc);
    }

    private static void merge(int[] input, int start, int mid, int end, boolean asc) {

        if (input[mid-1] <= input[mid] && asc) {
            return;
        }
        if (input[mid-1] >= input[mid] && !asc) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            if (asc) {
                temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
            } else {
                temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
            }

        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

    private static void quickSort(int[] input, int start, int end) {
        if (end - start < 2) return;

        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);
    }

    private static int partition(int[] input, int start, int end) {
        int pivot = input[start];
        int i = start;
        int j = end;
        while(i < j) {
            while (i < j && input[--j] >= pivot) ;
            if (i < j) {
                input[i] = input[j];
            }
            while (i < j && input[++i] <= pivot) ;
            if (i < j) {
                input[j] = input[i];
            }
        }
        input[j] = pivot;

        return j;
    }

    private static void countingSort(int[] input, int min, int max) {
        int[] countArray = new int[max - min + 1];
        for (int i = 0; i < input.length; i++) {
            countArray[input[i]- min ] ++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while(countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i - min]--;
            }
        }
    }

    private static void radixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    private static void radixSort(String[] input, int radix, int width) {
        for (int i = width - 1; i >= 0; i--) {
            radixSingleSort(input, i, radix);
        }
    }

    private static void  radixSingleSort(int[] input, int position, int radix) {
        int len = input.length;
        int[] countArray = new int[radix];
        int[] temp = new int[len];

        for (int value: input) {
            countArray[getDigit(position, value, radix)] ++;
        }

        for(int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        for (int k = len - 1; k >= 0; k--) {
            temp[--countArray[getDigit(position, input[k], radix)]] = input[k];
        }

        for (int tempIndex = 0; tempIndex < len; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    private static void  radixSingleSort(String[] input, int position, int radix) {
        int len = input.length;
        int[] countArray = new int[radix];
        String[] temp = new String[len];

        for (String value: input) {
            countArray[getIndex(position, value)] ++;
        }

        for(int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        for (int k = len - 1; k >= 0; k--) {
            temp[--countArray[getIndex(position, input[k])]] = input[k];
        }

        for (int tempIndex = 0; tempIndex < len; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(10, position)  % radix;
    }

    private static int getIndex(int position, String value) {
        return value.charAt(position) - 'a';
    }

}
