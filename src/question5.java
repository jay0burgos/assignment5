import java.util.Arrays;

public class question5 {
    public static int[] findMinMax(int[]arr){
        //recursively find min and max num of a list
        //base case will be when there's only one var left and it will return that var
         //will return an array
        if(arr.length == 0) //
            return arr;
        if(arr.length == 1)
            return arr;


        int[] left = findMinMax(Arrays.copyOfRange(arr, 0, arr.length/2 ));//findMinMax(subarray)
        int[] right = findMinMax(Arrays.copyOfRange(arr, arr.length/2, arr.length));//findMinMax(subarray)
        
//        int[] num = new int[2];
//        if(left.length == 1 && right.length == 1)
//        {    //second entry in the call stack
//            if(left[0] > right[0])
//            {
//                num[0] = right[0];
//                num[1] = left[0];
//            }
//            else
//            {
//                num[0] = left[0];
//                num[1] = right[0];
//            }
//        }
//        //user when there are an odd number of entries in the initial array
//        else if(left.length ==1 || right.length ==1){
//            if(left.length ==1){
//                if(left[0] < right[0]){
//                     num[0] = left[0];
//                     num[1] = right[1];
//
//                }
//                else{
//                     if(left[0]> right[1]){
//                         num[1] = left[0];
//                         num[0] = right[0];
//                     }
//                     else  //base case if array with one entry isnt smaller or bigger
//                        num = right;
//
//                }
//            }
//            else //right is the obvious length 1 array
//            {
//                if(right[0] < left[0]){
//                    num[0] = right[0];
//                    num[1]= left[1];
//
//                }
//                else{
//                    if(right[0] > left[1]){
//                       num[1] = right[0];
//                       num[0] = left[1];
//                    }
//                    else
//                        num = left;
//                }
//            }
//        }
//        else
//            {
//                if(left[0] > right[0])  //check which min is the least
//                {
//                    num[0] = right[0];
//
//                }
//                else
//                {
//                    num[0] = left[0];
//                }
//
//                if(left[1] < right[1])  //check which max is the largest
//                {
//                    num[1] = right[1];
//
//                }
//                else
//                {
//                    num[1] = left[1];
//                }
//            }
        return check(left, right);

        //get min and max

    }

    public static int[] findMinMaxModified(int[]arr){
        if(arr.length == 0) //
            return arr;
        else if(arr.length == 1)
            return arr;
        else if(arr.length ==2){   //to prevent an infinate loop with arrays of lenght 2
            int[] left = new int[1];
            int[] right = new int[1];
            left[0] = arr[0];
            right[0] = arr[1];

            return check(left, right);
        }



        int[] left;
        int[] right;

        if(arr.length%4 ==0){
            left = findMinMax(Arrays.copyOfRange(arr, 0, arr.length/2 ));//findMinMax(subarray)
            right = findMinMax(Arrays.copyOfRange(arr, arr.length/2, arr.length));//findMinMax(subarray)
        }
        else if(arr.length%2==0){
            left = findMinMax(Arrays.copyOfRange(arr, 0, arr.length/2 -1 ));//findMinMax(subarray)
            right = findMinMax(Arrays.copyOfRange(arr, arr.length/2-1, arr.length));//findMinMax(subarray)
        }
        else{ //done for odd ones
            left = findMinMax(Arrays.copyOfRange(arr, 0, arr.length/2 ));//findMinMax(subarray)
            right = findMinMax(Arrays.copyOfRange(arr, arr.length/2, arr.length));//findMinMax(subarray)
        }

        return check(left, right);

    }

    
    //since I will have to modify code, I made this a seperate class, to prevent
    // rewriting code
    public static int[] check(int[]left, int[]right){
        int[] num = new int[2];
        if(left.length == 1 && right.length == 1)
        {    //second entry in the call stack
            if(left[0] > right[0])
            {
                num[0] = right[0];
                num[1] = left[0];
            }
            else
            {
                num[0] = left[0];
                num[1] = right[0];
            }
        }
        //user when there are an odd number of entries in the initial array
        else if(left.length ==1 || right.length ==1){
            if(left.length ==1){
                if(left[0] < right[0]){
                    num[0] = left[0];
                    num[1] = right[1];

                }
                else{
                    if(left[0]> right[1]){
                        num[1] = left[0];
                        num[0] = right[0];
                    }
                    else  //base case if array with one entry isnt smaller or bigger
                        num = right;

                }
            }
            else //right is the obvious length 1 array
            {
                if(right[0] < left[0]){
                    num[0] = right[0];
                    num[1]= left[1];

                }
                else{
                    if(right[0] > left[1]){
                        num[1] = right[0];
                        num[0] = left[1];
                    }
                    else
                        num = left;
                }
            }
        }
        else
        {
            if(left[0] > right[0])  //check which min is the least
            {
                num[0] = right[0];

            }
            else
            {
                num[0] = left[0];
            }

            if(left[1] < right[1])  //check which max is the largest
            {
                num[1] = right[1];

            }
            else
            {
                num[1] = left[1];
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] myArray = {8,3,4, 5,9, 12, 2, 65, 1, 7};
        int[] newArray = question5.findMinMaxModified(myArray);
        for(int i: newArray)
            System.out.println(i);
    }
}


   //answer for q5a - 12*(2^N)
   //answer for q5b -  12*(2^(3*2^k))
   //answer for q5c - 12*(2^N)+5 due to the fact that i have to check if its divisible by 4 or even

