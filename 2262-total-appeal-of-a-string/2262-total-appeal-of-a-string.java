class Solution {
    public long appealSum(String s) {

        // Map<String,Integer> map = getPrefix(s);

        // // return find(prefix,0,s.length()-1);

        // // printPrefix(prefix);

        // long sum = 0;
        // for(int g=0;g<s.length();g++){
        //     for(int i=0,j=g;i<s.length() && j<s.length();i++,j++){
        //         sum+=map.get(i+","+j);
        //     }

        // }

        // return sum;

        long sum =0;
        int last[] = new int[26];
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i+1;
            for( int l : last)
            sum+=l;
        }

        return sum;
        
    }

    // private void printPrefix(int arr[][]){
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=0;j<arr[0].length;j++){
    //             System.out.print(arr[i][j]+" ");
    //         }
    //         System.out.println();
    //     }
    // }

    // private long find(int arr[][], int i, int j){
    //     for(int k=i;k<=j;k++){

    //     }
    // }

    // private Map<String,Integer> getPrefix(String s){

    //     Map<String,Integer> map = new HashMap<>();
    //     for(int i=0;i<s.length();i++){
    //         Set<Character> set = new HashSet<>();
    //         for(int j=i;j<s.length();j++){
    //             set.add(s.charAt(j));
    //             map.put(i+","+j,set.size());

    //         }
    //     }

    //     return map;
    // }
}