package tdd;

import org.junit.jupiter.api.Test;

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


}
