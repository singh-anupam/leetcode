class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> set = new ArrayList<>();
        for(String str :  folder)
        {
            String s ="";
            boolean flag =false;
            for(char ch :  str.toCharArray())
            {
                
                if(ch=='/'){
                if(set.contains(s))
                { flag =true;
                    break;
                }
                }
                s+=ch;

            }
            if(!flag)
            set.add(s);
        }

        // List<String> ans = new ArrayList<>();
        // for(String s : set)
        // ans.add(s);

        return set;

    }
}