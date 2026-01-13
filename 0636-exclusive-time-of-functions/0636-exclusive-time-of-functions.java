class Solution {
    class Pair{
        int id;
        int start;
        Pair(int id, int start){
            this.id = id;
            this.start=start;

        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Pair> stack = new Stack<>();
        int arr[] = new int[n];
        for(String str :  logs){
            String brr[] = str.split(":");
            if(brr[1].equals("start")){
                if(stack.size()>0){
                    Pair p = stack.peek();
                    arr[p.id]+=Integer.parseInt(brr[2])-p.start;
                }

                stack.push(new Pair(Integer.parseInt(brr[0]),Integer.parseInt(brr[2])));

            }else{
                Pair rm = stack.pop();
                arr[rm.id]+=Integer.parseInt(brr[2])-(rm.start)+1;
                if(stack.size()>0){
                    Pair p = stack.peek();
                    p.start = Integer.parseInt(brr[2])+1;
                }
            }
        }

        return arr;
        
    }
}