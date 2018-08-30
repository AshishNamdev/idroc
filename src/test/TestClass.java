
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/

class TestClass {
    public static int[] sortArray(int arr[])
    {
        //int l = arr.length;
        //int newarr [] = new int [l];
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                int tmp = 0;
                if (arr[i] > arr[j])
                {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());
        Boolean isCorrect = false;
        int n ;
        int arr [] ;

        for (int i = 0; i < testCaseCount; i++) {
           n = Integer.parseInt(br.readLine());
           arr  = new int[n];
           for ( int  j = 0 ; j <n ; j++)
               arr[j] = Integer.parseInt(br.readLine());
           int[] sortArray = TestClass.sortArray(arr);
           for( int k = 0 ; k< sortArray.length; k++)
           {
               if(sortArray[k]+1 == sortArray[k+1])
                   isCorrect = true;
               else
                   break;
           }
           if (isCorrect)
                System.out.println("Correct");
           else
               System.out.println("Wrong");
               
        }     
    }
}