class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {

int i =0;
int j =0;
    for(String command :  commands){
        if(command.equals("DOWN")){
            i++;

        }
        else if(command.equals("RIGHT")){
            j++;

        }
         else if(command.equals("LEFT")){
            j--;
            
        }
        else{
            i--;

        }
    }
    System.out.println(i+" "+j);

    return i*n+j;
        
    }
}