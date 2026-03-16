class Solution {
    public int shortestPathAllKeys(String[] grid) {

        int dirs[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        int maxlen = 0;

        Queue<int[]> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length();j++){
                char ch = grid[i].charAt(j);

                if(ch=='@')
                    q.offer(new int[]{0,i,j});

                else if(ch>='a' && ch<='f')
                    maxlen = Math.max(maxlen, ch-'a'+1);
            }
        }

        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){

                int rm[] = q.poll();
                int mask = rm[0];
                int x = rm[1];
                int y = rm[2];

                if(mask == (1<<maxlen)-1)
                    return steps;

                for(int dir[]:dirs){

                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if(nx<0 || ny<0 || nx>=grid.length || ny>=grid[0].length())
                        continue;

                    char ch = grid[nx].charAt(ny);

                    if(ch=='#') continue;

                    if(ch>='A' && ch<='F' && ((mask>>(ch-'A'))&1)==0)
                        continue;

                    int newMask = mask;

                    if(ch>='a' && ch<='f')
                        newMask |= (1<<(ch-'a'));

                    String key = newMask+"-"+nx+"-"+ny;

                    if(!vis.contains(key)){
                        vis.add(key);
                        q.offer(new int[]{newMask,nx,ny});
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}