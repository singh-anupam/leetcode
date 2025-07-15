class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int arr[] = new int[26];
        Arrays.fill(arr,Integer.MAX_VALUE);
        for(int i=0;i<s.length();i++)
        {
            arr[s.charAt(i)-'a']=Math.min(i,arr[s.charAt(i)-'a']);
            
        }
        // for(int i=0;i<26;i++)
        //     System.out.println(arr[i]);
        int j=s.length()-1;
        while(j>=0)
        {
            int x= arr[s.charAt(j)-'a'];
         //  System.out.println(x);
            int count =0;
            while(j>=x)
            {
                x=Math.min(x,arr[(s.charAt(j)-'a')]);
              //   System.out.println(x+" "+j);
                j--;
                count++;
            }
            ans.add(0,count);
        }
        return ans;
        
    }
}