package sorter;

import java.util.Random;

public class TestSort
{
    public static void main(String[] args)
    {
        testSelection();
        testSelection2();
        testMergeSort();

    }
    public static void testSelection(){
        int[] naTest1 = {2, 9, 5, 4, 8, 1, 6};

        Sorter.recSelectionSort(naTest1);

        printArray(naTest1);
    }

    public static void testSelection2(){
        int [] naVals = new Random().ints(1000,1, 1000).toArray(); //Create un array con numeros random
        long nStart = System.nanoTime();
        Sorter.recSelectionSort(naVals);
        long nEnd = System.nanoTime();

        System.out.printf("It takes %d ns for sorting 10000 element using recursive selection sort \n", nEnd - nStart);
        //printArray(naVals);

    }

    public static void testMergeSort(){
        int [] naVals = new Random().ints(1000,1, 1000).toArray(); //Create un array con numeros random
        long nStart = System.nanoTime();
        Sorter.mergeSortH(naVals);
        long nEnd = System.nanoTime();
        System.out.printf("It takes %d ns for sorting 10000 element using recursive merge sort \n", nEnd - nStart);

    }

    public static void printArray(int [] naArr){
        System.out.print("[");

        for(int i = 0; i < naArr.length; i++){
            System.out.printf("%d ", naArr[i]); //%d for integer, print the integer follow by space
            if((i+1)% 40 == 0){
                System.out.print("\n"); //end of the line
            }
        }

        System.out.print("]\n");
    }
}
