package tdd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void lengthOfLongestSubstringTest_1() {
        //Given
        String input = "abcabcbb";
        int expected = 3;

        //When
        int actualValue = new Solution().lengthOfLongestSubstring(input);

        //Then
        assertEquals(expected, actualValue);
    }

    @Test
    public void lengthOfLongestSubstringTest_2() {
        //Given
        String input = "bbbbb";
        int expected = 1;

        //When
        int actualValue = new Solution().lengthOfLongestSubstring(input);

        //Then
        assertEquals(expected, actualValue);
    }

    @Test
    public void lengthOfLongestSubstringTest_3() {
        //Given
        String input = "pwwkew";
        int expected = 3;

        //When
        int actualValue = new Solution().lengthOfLongestSubstring(input);

        //Then
        assertEquals(expected, actualValue);
    }

    @Test
    public void lengthOfLongestSubstringTest_4() {
        //Given
        String input = "";
        int expected = 0;

        //When
        int actualValue = new Solution().lengthOfLongestSubstring(input);

        //Then
        assertEquals(expected, actualValue);
    }

    @Test
    public void findMedianSortedArraysTest_1() {
        //Given
        int[] testArray_1 = new int[]{1, 2};
        int[] testArray_2 = new int[]{3};

        //When
        double actualValue = new Solution().findMedianSortedArrays(testArray_1, testArray_2);

        //Then
        assertEquals(2.0, actualValue, 0.00001);
    }

    @Test
    public void findMedianSortedArraysTest_2() {
        //Given
        int[] testArray_1 = new int[]{1, 2};
        int[] testArray_2 = new int[]{3, 4};

        //When
        double actualValue = new Solution().findMedianSortedArrays(testArray_1, testArray_2);

        //Then
        assertEquals(2.5, actualValue, 0.00001);
    }

    @Test
    public void findMedianSortedArraysTest_3() {
        //Given
        int[] testArray_1 = new int[]{};
        int[] testArray_2 = new int[]{};

        //When
        double actualValue = new Solution().findMedianSortedArrays(testArray_1, testArray_2);

        //Then
        assertEquals(0, actualValue, 0.00001);
    }

    @Test
    public void findMedianSortedArraysTest_4() {
        //Given
        int[] testArray_1 = new int[]{1,2,3};
        int[] testArray_2 = new int[]{};

        //When
        double actualValue = new Solution().findMedianSortedArrays(testArray_1, testArray_2);

        //Then
        assertEquals(2, actualValue, 0.00001);
    }

    @Test
    public void findMedianSortedArraysTest_5() {
        //Given
        int[] testArray_1 = new int[]{};
        int[] testArray_2 = new int[]{1,2,3};

        //When
        double actualValue = new Solution().findMedianSortedArrays(testArray_1, testArray_2);

        //Then
        assertEquals(2, actualValue, 0.00001);
    }

    @Test
    public void findMedianSortedArraysTest_6() {
        //Given
        int[] testArray_1 = new int[]{1,2,3,4};
        int[] testArray_2 = new int[]{2,4,6};

        //When
        double actualValue = new Solution().findMedianSortedArrays(testArray_1, testArray_2);

        //Then
        assertEquals(3, actualValue, 0.00001);
    }

    @Test
    public void findMedianSortedArraysPerformanceTest() {
        int sizeOfArray = 500000000;
        int[] testArray_1 = new int[sizeOfArray];
        int[] testArray_2 = new int[sizeOfArray];
        Random random = new Random();


        for( int i = 0; i < sizeOfArray ; i++){
            testArray_1[i] = random.nextInt();
            testArray_2[i] = random.nextInt();
        }

        Arrays.sort(testArray_1);
        Arrays.sort(testArray_2);


        long startTime = System.currentTimeMillis();
        double actualValue = new Solution().findMedianSortedArrays(testArray_1, testArray_2);
        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println(elapsedTime + " ms");
    }


}
