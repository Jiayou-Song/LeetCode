public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        int[] res = new int[2];
        for(int i=0;i<numbers.length;i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(map.containsKey(numbers[i])) 
                list = map.get(numbers[i]);
            list.add(i+1);
            map.put(numbers[i],new ArrayList<Integer>(list));
            list.clear();
            }
        for(Map.Entry<Integer,ArrayList<Integer>> i: map.entrySet()) {
            int key = i.getKey();
            int index1 = i.getValue().get(0);
            if(map.containsKey(target-key)) {
                int index2 = map.get(target-key).get(0);
                if(i.getValue().size() == 2)
                    index2 = i.getValue().get(1);
                if(index1 < index2) {
                    res[0] = index1;
                    res[1] = index2;
                }
                else {
                    res[0] = index2;
                    res[1] = index1;
                }
                return res;
            }
        }
        return res;
    }
}
