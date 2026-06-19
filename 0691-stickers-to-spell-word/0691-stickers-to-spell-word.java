class Solution {
    public int minStickers(String[] stickers, String target) {

        target = sort(target);
        int n = stickers.length;
        Set<String> set = new HashSet<>();
       for(int i=0;i<n;i++){
            stickers[i]=sort(stickers[i]);
        }

        Queue<String> q = new LinkedList<>();
        int count = 0;
        q.offer(target);
        set.add(target);
        while(q.size()>0){
            int size = q.size();
            count++;            
            for(int i=0;i<size;i++){
                String rm = q.poll();
                for(String str : stickers){
                String remaining = filter(rm,str);
                if(remaining.isEmpty())
                return count;
                if(remaining.equals(rm) || set.contains(remaining))
                continue;
                q.offer(remaining);
                set.add(remaining);


                }
            }
            // count++;
        }
        return -1;
        
    }

   private String filter(String a, String b){
        StringBuilder sb = new StringBuilder();
        int idx=0;
        for(char ch : a.toCharArray()){
            boolean found = false;
            while(idx<b.length() && b.charAt(idx)<=ch){
                if(b.charAt(idx++)==ch){
                    found=true;
                    break;
                }
            }
            if(!found)
            sb.append(ch);
        }

        return sb.toString();
    }

    private String sort(String str){
        char arr[] = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}