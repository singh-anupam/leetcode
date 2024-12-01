class Solution {
   public boolean checkIfExist(int[] arr) {
        for(int j = 0; j<arr.length; j++){
            for(int i = arr.length-1; i>j; i--){
                if((arr[j] == arr[i]*2) || (arr[i] / 2 == arr[j]  && arr[i] % 2 == 0)){
                    return true;
                }
            }
        }
        return false;
    }
}