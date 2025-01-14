class Solution {
    private int numOfGoodLeafPairs;

    private List<Integer> dfs(TreeNode node, int distance) {
        if (node == null) return new ArrayList<>();
        if (node.left == null && node.right == null) return Arrays.asList(1);

        List<Integer> leftList = dfs(node.left, distance);
        List<Integer> rightList = dfs(node.right, distance);

        for (int lv : leftList) {
            for (int rv : rightList) {
                if (lv + rv <= distance) numOfGoodLeafPairs++;
            }
        }

        List<Integer> parentList = new ArrayList<>();
        for (int lv : leftList) {
            if (lv + 1 <= distance) parentList.add(lv + 1);
        }

        for (int rv : rightList) {
            if (rv + 1 <= distance) parentList.add(rv + 1);
        }

        return parentList;
    }

    public int countPairs(TreeNode root, int distance) {
        numOfGoodLeafPairs = 0;
        dfs(root, distance);
        return numOfGoodLeafPairs;
    }
}
