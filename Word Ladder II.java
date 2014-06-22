public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        List<String> list1 = new ArrayList<String>();
        list1.add(start);
        List<String> temp1 = new ArrayList<String>();
        Map<String,List<List<String>>> map1 = new HashMap<String,List<List<String>>>();
        List<List<String>> tempList1 = new ArrayList<List<String>>();
        tempList1.add(list1);
        map1.put(start,tempList1);
        List<String> list2 = new ArrayList<String>();
        list2.add(end);
        List<String> temp2 = new ArrayList<String>();
        Map<String,List<List<String>>> map2 = new HashMap<String,List<List<String>>>();
        List<List<String>> tempList2 = new ArrayList<List<String>>();
        tempList2.add(list2);
        map2.put(end,tempList2);
        Map<String,Integer> depthMap = new HashMap<String,Integer>();
        depthMap.put(start,0);
        depthMap.put(end,0);
        int depth = 1;
        while(true) {
            boolean flag = true;
            if(!list1.isEmpty()) {
                for(String str: list1) {
                    for(int i=0;i<str.length();i++) {
                        char chr = str.charAt(i);
                        for(char c='a';c<='z';c++) {
                            if(c != chr) {
                                String s = str.substring(0,i) + Character.toString(c) + str.substring(i+1);
                                if(dict.contains(s) && !map1.containsKey(s)) {
                                    if(map2.containsKey(s)) {
                                        for(List<String> tlist1: map1.get(str)) {
                                            for(List<String> tlist2: map2.get(s)) {
                                                List<String> res = new ArrayList<String>(tlist1);
                                                res.addAll(tlist2);
                                                solutions.add(res);
                                                flag = false;
                                            }
                                        }
                                    }
                                    else {
                                        temp1.add(s);
                                        List<List<String>> _2DList = new ArrayList<List<String>>();
                                        for(List<String> list: map1.get(str)) {
                                            List<String> tempList = new ArrayList<String>(list);
                                            tempList.add(s);
                                            _2DList.add(tempList);
                                        }
                                        map1.put(s,_2DList);
                                        depthMap.put(s,depth);
                                    }
                                }
                                else if (map1.containsKey(s) && depth == depthMap.get(s)) {
                                    for(List<String> list: map1.get(str)) {
                                        List<String> tempList = new ArrayList<String>(list);
                                        tempList.add(s);
                                        map1.get(s).add(tempList);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else
                break;
            if(!flag)
                break;
            list1 = new ArrayList(temp1);
            temp1.clear();
            if(!list2.isEmpty()) {
                for(String str: list2) {
                    for(int i=0;i<str.length();i++) {
                        char chr = str.charAt(i);
                        for(char c='a';c<='z';c++) {
                            if(c != chr) {
                                String s = str.substring(0,i) + Character.toString(c) + str.substring(i+1);
                                if(dict.contains(s) && !map2.containsKey(s)) {
                                    if(map1.containsKey(s)) {
                                        for(List<String> tlist1: map1.get(s)) {
                                            for(List<String> tlist2: map2.get(str)) {
                                                List<String> res = new ArrayList<String>(tlist1);
                                                res.addAll(tlist2);
                                                solutions.add(res);
                                                flag = false;
                                            }
                                        }
                                    }
                                    else {
                                        temp2.add(s);
                                        List<List<String>> _2DList = new ArrayList<List<String>>();
                                        for(List<String> list: map2.get(str)) {
                                            List<String> tempList = new ArrayList<String>(list);
                                            tempList.add(0,s);
                                            _2DList.add(tempList);
                                        }
                                        map2.put(s,_2DList);
                                        depthMap.put(s,depth);
                                    }
                                }
                                else if (map2.containsKey(s) && depth == depthMap.get(s)) {
                                    for(List<String> list: map2.get(str)) {
                                        List<String> tempList = new ArrayList<String>(list);
                                        tempList.add(0,s);
                                        map2.get(s).add(tempList);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(!flag)
                break;
            list2 = new ArrayList(temp2);
            temp2.clear();
            depth ++;
        }
        return solutions;
    }
}
