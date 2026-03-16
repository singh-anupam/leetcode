class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int dirs[][] = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        int maxlen =0;
        Queue<int[]> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            String str = grid[i];
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='@')
                q.offer(new int[]{0,i,j});
                else if(str.charAt(j)-'a'>=0 && str.charAt(j)-'a'<=6)
                maxlen = Math.max(str.charAt(j)-'a'+1,maxlen);
            }
        }

        int steps = 0;
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int rm[] = q.poll();
                if((rm[0]==(1<<maxlen)-1))
                return steps;
            
                for(int dir[] : dirs){
                    int nx = rm[1]+dir[0];
                    int ny = rm[2]+dir[1];
                     
                    if(nx<0 || nx>=grid.length || ny<0 || ny>=grid[0].length() || grid[nx].charAt(ny)=='#')
                    continue;
                    char ch = grid[nx].charAt(ny);
                    if(ch>='A' && ch<='F' && (rm[0]>>(ch-'A')&1)==0)
                    continue ;
               
                    if(ch>='a' && ch<='f')
                    rm[0]|=(1<<ch-'a');
                    if(!vis.contains(rm[0]+""+nx+""+ny));
                    {
                        q.offer(new int[]{rm[0],nx,ny});
                        vis.add(rm[0]+""+nx+""+ny);
                    }
                }
                
            }
            steps++;

        }
        return -1;
    }
}