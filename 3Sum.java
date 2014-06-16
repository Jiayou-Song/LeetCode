public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> values = new ArrayList<Integer>();
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++) {
            if(!values.contains(num[i])) {
                values.add(num[i]);
                int front = i+1;
                int tail = num.length-1;
                list.clear();
                list.add(num[i]);
                list.add(num[front]);
                list.add(num[tail]);
                while(front < tail) {
                    int sum = list.get(0)+list.get(1)+list.get(2);
                    if(sum == 0) {
                        solutions.add(new ArrayList<Integer>(list));
                        while(front+1 < tail && num[front] == num[front+1]) {
                            front ++;
                        }
                        front ++;
                        list.set(1,num[front]);
                    }
                    else if(sum < 0) {
                        front ++;
                        list.set(1,num[front]);
                    }
                    else {
                        tail --;
                        list.set(2,num[tail]);
                    }
                }
            }
        }
        return solutions;
    }
}
