class Solution {
    public int[][] intervalIntersection(int[][] first, int[][] second) {
        List<int[]> ans = new ArrayList<>();
        int l=0;
        int r =0;
        while(l<first.length && r<second.length){
            if(first[l][1]>=second[r][0] && second[r][1]>=first[l][0] ){
                ans.add(new int[]{Math.max(first[l][0],second[r][0]),Math.min(first[l][1],second[r][1])});
                
            }
            if(first[l][1]>second[r][1]){
                    r++;
                }
                else if (first[l][1]<second[r][1]){
                    l++;
                }
                else
                {
                    l++;
                    r++;
                }
        }
        int res[][] = new int[ans.size()][];
        int x =0;
        for(int arr[] : ans){
            res[x++]=arr;
        }
        return res;
        
    }
}