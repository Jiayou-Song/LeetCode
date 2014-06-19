public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prelist = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<=rowIndex;i++) {
            for(int j=0;j<=i;j++) {
                if(j == 0 || j == i)
                    list.add(1);
                else
                    list.add(prelist.get(j-1)+prelist.get(j));
            }
            prelist = new ArrayList<Integer>(list);
            list.clear();
        }
        return prelist;
    }
}
