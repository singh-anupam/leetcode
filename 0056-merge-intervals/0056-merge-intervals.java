class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();
        int prev=intervals[0][1];
        int start = intervals[0][0];
        for(int arr[] : intervals){
            if(arr[0]>prev){
                ans.add(new int[]{start,prev});
                  start =arr[0];

               
            }
            
                prev=Math.max(prev,arr[1]);
        }
        ans.add(new int[]{start,prev});
        int array[][] =new int[ans.size()][];
        for(int i=0;i<ans.size();i++){
            array[i]=ans.get(i);
        }

        return array;
    }
}