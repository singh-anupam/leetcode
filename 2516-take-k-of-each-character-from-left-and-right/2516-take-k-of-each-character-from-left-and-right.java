class Solution {
    public int takeCharacters(String s, int k) {

        int count_a =0;
        int count_b =0;
        int count_c =0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a')
            count_a++;
            if(s.charAt(i)=='b')
            count_b++;
            if(s.charAt(i)=='c')
            count_c++;
        }
        if(count_a <k || count_b<k || count_c<k)
        return -1;

        int i=0,j=0;
        int max=0;
        while(j<s.length())
        {
            if(s.charAt(j)=='b')
            count_a--;
            if(s.charAt(j)=='b')
            count_b--;
            if(s.charAt(j)=='c')
            count_c--;
            while(i<j && (count_a<k || count_b<k ||count_c<k))
            {
                if(s.charAt(i)=='a')
            count_a++;
            if(s.charAt(i)=='b')
            count_b++;
            if(s.charAt(i)=='c')
            count_c++;
            i++;
            }
            max = Math.max(max,j-i+1);
            j++;

        }
        return s.length()-max;
        
    }
}