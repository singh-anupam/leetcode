class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int minTime[][] = new int[moveTime.length][moveTime[0].length];
        for(int dp[]: minTime)
        Arrays.fill(dp,Integer.MAX_VALUE); 
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        Queue<int[]> pq = new LinkedList<>();

        pq.offer(new int[]{0,0,0});
        int dirs[][] = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        int count=0;
        int cz=1;
        while(pq.size()>0){
            int size = pq.size();
             count++;
            if(count%2==1)
            cz=1;
            else
            cz=2;

            for(int i=0;i<size;i++){
            int rm[] = pq.poll();
            int time = rm[2];
            int x = rm[0];
            int y = rm[1];
    
            for(int dir[] : dirs){
                int nx = dir[0]+x;
                int ny = dir[1]+y;
                int newTime = Math.max(time,getNewTime(nx,ny,moveTime))+cz;
                if(isValid(nx,ny,minTime,newTime)){
                    
                    System.out.println(newTime+" "+cz+" "+count);
                    if(minTime[nx][ny]>newTime)
                    minTime[nx][ny]=newTime;
                   
                    pq.offer(new int[]{nx,ny,newTime});
                }
            }
            
            }
           

        }

        return minTime[minTime.length-1][minTime[0].length-1];
        
    }

    private boolean isValid(int i, int j, int arr[][], int newTime){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]<=newTime)
        return false;

        return true;
    }

    private int getNewTime(int i, int j, int arr[][]){
         if(i<0 || j<0 || i>=arr.length || j>=arr[0].length)
         return Integer.MAX_VALUE-2;

         return  arr[i][j];

    }
}