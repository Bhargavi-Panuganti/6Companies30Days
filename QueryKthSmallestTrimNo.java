class Solution {
        public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] solution = new int[queries.length];

        //1. Map the elements into an object so we can easily track which index a particular number belongs to
        Node[] unsorted = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            unsorted[i] = new Node(nums[i], i);
        }

        int digit = nums[0].length() - 1;
        int len = nums[0].length();

        int finished = 0;
        //2. Loop through all of the digits from the end to the start.
        while (digit >= 0 && finished < queries.length) {
            //3. perform counting sort on the current digit, this will sort the array up to the trimmed value
            unsorted = countingSort(unsorted, digit);
            int qIndex = 0;

            //4. find any queries whose trim value matches the digit we have currently sorted to
            for (int[] query : queries) {
                int trimi = query[1];
                int ki = query[0];
                //5. find the kith smallest value for the query and add it to the solution
                if (len - trimi == digit) {
                    solution[qIndex] = unsorted[ki - 1].index;
                    finished++;
                }
                qIndex++;
            }
            digit--;
        }

        return solution;
    }

    public Node[] countingSort(Node[] unsorted, int digit) {
        //Note. It is quite important that counting sort is stable so that this property is maintained
        //If two trimmed numbers are equal, the number with the lower index is considered to be smaller
        int[] buckets = new int[10];
        for (Node num : unsorted) {
            buckets[num.value.charAt(digit) - '0']++;
        }

        for (int i = 1; i < buckets.length; i++) {
            buckets[i] = buckets[i] + buckets[i - 1];
        }

        Node[] sorted = new Node[unsorted.length];
        for (int i = unsorted.length - 1; i >= 0; i--) {
            sorted[--buckets[unsorted[i].value.charAt(digit) - '0']] = unsorted[i];
        }

        return sorted;
    }

        private class Node {
        String value;
        int index;

        public Node(String value, int index) {
            this.index = index;
            this.value = value;
        }
    }
}
