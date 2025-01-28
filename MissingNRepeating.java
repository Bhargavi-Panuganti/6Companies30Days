

// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        int duplicate = -1;
        int missing = -1;
        int[] res=new int[2];
        // Traverse the array to find the duplicate
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1; // use absolute value in case it's already marked

            // If the number at index is negative, it means the number is duplicated
            if (arr[index] < 0) {
                duplicate = Math.abs(arr[i]);
            } else {
                arr[index] = -arr[index]; // Mark as visited by making it negative
            }
        }

        // Traverse the array again to find the missing number
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                missing = i + 1; // The index + 1 is the missing number
            }
        }
        res[0]=duplicate;
        res[1]=missing;
        return res;
    }
    }
