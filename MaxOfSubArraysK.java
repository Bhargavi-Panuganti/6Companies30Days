

// User function template for JAVA

class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        // Traverse through the array
        for (int i = 0; i < arr.length; i++) {
            // Remove indices of elements which are out of this window
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            // Remove from the deque all elements that are smaller than the current element
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // Add the current element at the back of the deque
            deque.offerLast(i);

            // Start adding results to the list from the point where we have a complete window
            if (i >= k - 1) {
                ans.add(arr[deque.peekFirst()]);
            }
        }

        return ans;
    }
}
