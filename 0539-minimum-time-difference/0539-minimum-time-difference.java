class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();
        for(String str : timePoints){
            String arr[] = str.split(":");
            int time = Integer.parseInt(arr[0])*60+ Integer.parseInt(arr[1]);
            list.add(time);
        }

        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            min = Math.min(list.get(i)-list.get(i-1),min);
        }
        return Math.min(min,1440+list.get(0)-list.get(list.size()-1));
    }
}