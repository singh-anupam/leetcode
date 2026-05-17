class Solution {
    public boolean canReach(int[] arr, int start) {

        return find(arr, start);
        
    }

    private boolean find(int arr[], int pos){
        
        if(arr[pos]==0)
        return true;
        if(arr[pos]<0)
        return false;


        int last = (arr[pos]+pos);
        int first = (pos-arr[pos]);
        
        if(last<arr.length){
        arr[pos]=-arr[pos];
        if(find(arr,last))
        return true;
        arr[pos]=-arr[pos];
        }
        if(first>=0){
        arr[pos]=-arr[pos];
        if(find(arr,first))
        return true;
        arr[pos]=-arr[pos];
        }
        
        

        return false;
        
    }
}