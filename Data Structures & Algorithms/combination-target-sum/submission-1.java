

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int[] candidates, int target, int i, List<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (i == candidates.length || target < 0) return;

        curr.add(candidates[i]);
        helper(candidates, target - candidates[i], i, curr, ans);
        curr.remove(curr.size() - 1);

        helper(candidates, target, i + 1, curr, ans);
    }
}