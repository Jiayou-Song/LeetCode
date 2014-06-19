public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> prelist = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++) {
            for(int j=0;j<=i;j++) {
                if(j == 0 || j == i)
                    list.add(1);
                else
                    list.add(prelist.get(j-1)+prelist.get(j));
            }
            res.add(new ArrayList<Integer>(list));
            prelist = new ArrayList<Integer>(list);
            list.clear();
        }
        return res;
    }
}
