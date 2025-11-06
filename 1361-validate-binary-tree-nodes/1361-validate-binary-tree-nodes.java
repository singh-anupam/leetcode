class Solution {
    int par[];
    int component;
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        component = n;
        par = new int[n];
        for(int i=0;i<n;i++)
        par[i]=i;

        for(int i=0;i<n;i++)
        {
            if(leftChild[i]!=-1 && !union(i,leftChild[i]))
            return false;
            if(rightChild[i]!=-1 && !union(i,rightChild[i]))
            return false;
        }
        return component==1;

    }
    public boolean union(int p, int c)
    {
        if(par[c]!=c)
        return false;
        int x = find(c);
        int y = find(p);
        if(y==c )
        return false;
        par[c]=p;
        component--;
        return true;
    }
    public int find(int x)
    {
        if(par[x]==x)
        return x;
        return par[x]=find(par[x]);
    }
}