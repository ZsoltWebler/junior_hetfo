package tdd;

class Solution {


    public int lengthOfLongestSubstring(String s) {


        String appearedCharacters = "";
        int longestSubStringCount = 0;
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);

            if (!appearedCharacters.contains(String.valueOf(currentChar))) {
                appearedCharacters += currentChar;
                counter++;
            } else {
                appearedCharacters = currentChar + "";
                longestSubStringCount = Math.max(longestSubStringCount, counter);
                counter = 1;
            }

        }

        return longestSubStringCount;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        return 0;
    }

}
