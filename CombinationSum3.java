import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // maximum allowed sum is 45 (Sum of 1 to 9)
        // If k>n it is not possible to create any list 
        if (n > 45 || k > n) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        
        // Helper method for Depth First Search (DFS)
        dfs(1, new ArrayList<>(), 0, k, n, res);
        return res;
    }

    private void dfs(int index, List<Integer> currList, int total, int k, int n, List<List<Integer>> res) {
        // Checks if the current list of numbers has length of k and sums up to n
        if (currList.size() == k) {
            if (total == n) {
                res.add(new ArrayList<>(currList)); // Add a new copy of currList to res
            }
            return;
        }

        // Loop iterates from index to 9 
        for (int i = index; i <= 9; i++) {
            int currTotal = total + i; // update the current total to include i
            if (currTotal <= n) {
                currList.add(i); // add current number to currList
                dfs(i + 1, currList, currTotal, k, n, res); // recursive call
                currList.remove(currList.size() - 1); // backtrack
            } else {
                return;
            }
        }
    }
}
