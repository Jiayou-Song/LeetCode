public class Solution {
    private List<Integer> list = new ArrayList<Integer>();
    public int minimumTotal(List<List<Integer>> triangle) {
        findMin(0,0,triangle);
        return list.get(0);
    }
    public void findMin(int row, int index, List<List<Integer>> triangle) {
        if(row == triangle.size()-1) {
            if(index > list.size()-1)
                list.add(triangle.get(row).get(index));
            return;
        }
        if(index == 0) {
            findMin(row+1,index,triangle);
            findMin(row+1,index+1,triangle);
        }
        else
            findMin(row+1,index+1,triangle);
        list.set(index,triangle.get(row).get(index) + Math.min(list.get(index),list.get(index+1)));
    }
}
