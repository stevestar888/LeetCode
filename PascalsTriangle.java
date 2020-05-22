//compute pascal's triangle; pretty straightforward.
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList();
        
        if (numRows == 0) return ans;
        ans.add(new ArrayList(Arrays.asList(1)));
        if (numRows == 1) return ans;
        ans.add(new ArrayList(Arrays.asList(1, 1)));
        if (numRows == 2) return ans;
        
        for (int i = 2; i < numRows; i++) {
            List<Integer> prev = ans.get(i-1);
            List<Integer> curr = new ArrayList();
            curr.add(1);
            
            int x = 0;
            int y = 1;
            
            while (y < prev.size()) {
                curr.add(prev.get(x++) + prev.get(y++));
            }
            
            curr.add(1);
            ans.add(curr);
        }     
        return ans;
    }
}