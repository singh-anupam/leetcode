class Solution {
    public int slidingPuzzle(int[][] board) {

        String begin = "";
        for(int  arr[] : board){
            for(int i=0;i<arr.length;i++){
                begin+=arr[i];
            }
        }
        String target = "123450";

        int map[][] = new int[][]{{1,3},{0,2,4},{2,5},{0,4},{1,3,5},{2,4}};

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int count=0;

        queue.offer(begin);
        while(queue.size()>0)
        {
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                String rm =queue.poll();
                if(rm.equals(target))
                return count;

                int idx = rm.indexOf('0');
                int arr[] = map[idx];
                for(int pos: arr){
                    String str = swap(rm,idx,pos);
                    if(!set.contains(str))
                    {
                        set.add(str);
                        queue.offer(str);
                    }
                }
            }
            count++;
        }

        return -1;
        
    }

    private String swap(String str, int i, int j){
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i,str.charAt(j));
        sb.setCharAt(j,str.charAt(i));
        return sb.toString();
    }
}