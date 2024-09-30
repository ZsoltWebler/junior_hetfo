package tdd;

import java.util.Arrays;

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

    public double findMedianSortedArrays_(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];

        int i = 0;
        for (; i < nums1.length; i++) {
            nums3[i] = nums1[i];
        }
        for (int j = 0; j < nums2.length; j++) {
            nums3[i + j] = nums2[j];
        }

        if (nums3.length == 0) {
            return 0.0;
        }

        Arrays.sort(nums3);

        if (nums3.length % 2 == 0) {
            return (nums3[nums3.length / 2] + nums3[nums3.length / 2 - 1]) / 2.0;
        } else {
            return nums3[nums3.length / 2];
        }

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int arraySize = nums1.length + nums2.length;

        int currentIndexNumber = 0;
        int previousIndexNumber = 0;

        int nums1Index = 0;
        int nums2Index = 0;

        for (int i = 0; i <= arraySize / 2; i++) {
            previousIndexNumber = currentIndexNumber;
            if (nums1[nums1Index] < nums2[nums2Index]) {
                currentIndexNumber = nums1[nums1Index];
                nums1Index++;
            } else {
                currentIndexNumber = nums1[nums2Index];
                nums2Index++;
            }
        }
        return arraySize % 2 == 0 ? (previousIndexNumber + currentIndexNumber) / 2.0 : currentIndexNumber;
    }

    public int hIndex(int[] citations) {


        int hIndex = 0;

        while (true) {

            int numberOfArticlesWithAtLeastNCitation = 0;

            for (int i = 0; i < citations.length; i++) {

                if (hIndex <= citations[i]) {
                    numberOfArticlesWithAtLeastNCitation++;
                }

            }

            if (numberOfArticlesWithAtLeastNCitation < hIndex) {
                return hIndex-1;
            } else if (numberOfArticlesWithAtLeastNCitation == hIndex) {
                return hIndex;
            }

            hIndex++;
        }


    }

}
