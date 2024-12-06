class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {

        Arrays.sort(banned);
     //   List<Integer> l = Arrays.asList(banned);
        Arrays.stream(banned).forEach(i->System.out.print(i+" "));
        int count=0;
        int x=0;long sum=0;
        for(int i=1;i<=n;i++){
            boolean flag=false;
        
                while(x<banned.length && banned[x]==i){
                    x++;
                    flag=true;
                }
                
               
             if(flag)
             continue;   
            
            sum+=i;
            System.out.println(sum +" "+i);
            if(sum>=maxSum)
            return count;

        count++;

        }
        return count;

        
    }
}