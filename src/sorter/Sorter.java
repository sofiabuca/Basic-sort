package sorter;

public class Sorter
{
    public static void bubbleSort(int [] naVals){
        for(int nTop = naVals.length - 1; nTop > 0; nTop--){
            boolean bSorted = true;
            for(int i = 0; i < nTop; i++){
                if(naVals[i] > naVals[i +1]){
                    swap(naVals,i,i+1);
                    bSorted = false;
                }
            }

            if(bSorted){
                return;
            }
        }
    }

    public static void insertionSort(int[] naVals)
    {
        //Outer Loop to walk through teach of the positions

        for (int i=1; i<naVals.length; i++)
        {
            int nCurVal = naVals[i];

            int k;
            for (k = i-1; k>= 0 && naVals[k] > nCurVal; k--)
            {
                naVals[k+1] = naVals[k];
            }

            //insert the current element into the correct postion (this may occur twice
            naVals[k+1] = nCurVal;
        }

    }

    public static void selectionSortInt(int [] myArray){
        for (int i = 0; i < myArray.length; i++) {
            int minimum = myArray[i];
            int minimumIndex = i;
            for (int j = i+1; j < myArray.length ; j++) {
                if (minimum > myArray[j]){
                    minimum = myArray[j];
                    minimumIndex = j;
                }
            }
            swap(myArray, i, minimumIndex);
        }
    }
    public static void recSelectionSort(int[] naVals){
        recSelectionSort(naVals, naVals.length - 1);
    }
    public static void recSelectionSort(int [] naVals, int nTop){
        //Base Case
        if(nTop < 1){
            return;
        }

        int nHighPos = 0;
        for(int i = 1; i <= nTop; i++ ){ //Comienza desde 1 porque el caso anterior es menor a 1

            if(naVals[i] > naVals[nHighPos])
            {
                nHighPos = i;
            }
        }

        swap(naVals, nHighPos, nTop);
        recSelectionSort(naVals, nTop - 1);
    }

    public static void mergeSort(int [] naVals){
        //Base case
        if(naVals.length <= 1){
            return;
        }

        //Split in the middle the array
        int nMid = naVals.length/2;
        int[] naFirstHalf = new int [nMid];
        int[] naSecondHalf = new int [naVals.length - nMid];

        //Copy the array
        System.arraycopy(naVals, 0, naFirstHalf,0, nMid);
        System.arraycopy(naVals,nMid,naSecondHalf,0,naVals.length - nMid);


        mergeSort(naFirstHalf);
        mergeSort(naSecondHalf);

        merge(naVals,naFirstHalf, naSecondHalf);

    }

    //Homework
    public static void merge(int[]naVals, int[]naFirstHalf, int[]naSecondHalf){



    }

    public static void swap(int [] nVals, int nPos1, int nPos2){
        int nTemp = nVals[nPos1];
        nVals[nPos1] = nVals[nPos2];
        nVals[nPos2] = nTemp;
    }

    //Merge Sort using Helper method
    public static void mergeSortH(int []arr){
        mergeSortH(arr, 0 , arr.length-1);
    }

    public static void mergeSortH(int []arr, int low, int high){
        if(high-low <= 0){
            return;
        }
        int mid = (low + high)/2;

        mergeSortH(arr, low, mid);
        mergeSortH(arr, mid+1,high);
        mergeE(arr, low, mid, high);
    }
    public static void mergeE(int []arr, int low, int mid, int high)
    {
        int wLen = mid-low+1;
        int hLen = high-mid;
        int []left = new int[wLen];
        int []right;
        if (hLen > 0)
            right= new int[hLen];
        else
            right=null;

        for(int i=0; i<wLen; i++)
        {
            left[i] = arr[low+i]; //Copy left array
        }

        for(int j=0; j<hLen; j++)
        {
            right[j] = arr[mid+1+j]; //Copy right array
        }

        int i=0, j=0, k=low;

        //Merge left and right arrays
        while(i<wLen && j<hLen)
        {
            if(left[i]<=right[j])
            {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }

            k++;
        }

        while(i<wLen) {
            arr[k++] = left[i++];
        }

        while(j<hLen)
        {
            arr[k++] = right[j++];
        }
    }


}
