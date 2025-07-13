class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int indegree[] = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int arr[] : prerequisites ){
            indegree[arr[0]]++;
            graph.get(arr[1]).add(arr[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
            q.offer(i);
        }

        int count =0;
        int x =0;
        int ans[] = new int[numCourses];
        while(q.size()>0){
            int rm = q.poll();
            ans[x++]=rm;
            count++;
            for(int nbr : graph.get(rm)){
                indegree[nbr]--;
                if(indegree[nbr]==0)
                q.offer(nbr);

            }
        }
        return count==numCourses?ans:new int[]{};
        
    }
}