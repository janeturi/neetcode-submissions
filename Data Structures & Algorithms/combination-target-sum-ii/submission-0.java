class Solution {
    private static List<List<Integer>> res = new ArrayList<>();
// dont use hashset because hashset's auto clear duplicates, making
// it hard for us to avoid paths that use dupes
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res.clear();
        // clear to avoid wrong answers getting mixed in during recursive calls
        // used here and not the other because we are explicility trying to avoid 
        // duplicates
        Arrays.sort(candidates);
        dfs(0, new ArrayList<>(), 0, candidates, target); //  beginning
        
        return res;
    }

    private static void dfs(int idx, List<Integer> path, int cur, int[] candidates, int target){
        if (cur == target){ 
            res.add(new ArrayList<>(path)); // curate path 
            // if path sum's == target
            return;
        }

        for(int i = idx; i < candidates.length; i++){
            if(i > idx && candidates[i] == candidates[i - 1]) continue;
            // handle beginning duplicate
            if(cur + candidates[i] > target) break;
            // invalid & don't need to check further
            
            path.add(candidates[i]);
            dfs(i + 1, path, cur + candidates[i], candidates, target);
            // use i + 1 because we cant duplicate any numbers
            path.remove(path.size() - 1);
            // backtrack pattern hting
            // backtrack by removing the last last choice made and trying
            // another
        }
    }
}
