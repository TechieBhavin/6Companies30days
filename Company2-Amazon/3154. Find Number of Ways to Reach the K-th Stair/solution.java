class Solution {
    
    //Getting TLE need to memoize it Passing 368/600 Test Cases

    //using a map instead of 3-D memo array
    HashMap<String, Integer> memoizeMap = new HashMap<>();
    int K;

    public int waysToReachStair(int k) {
        
        K = k;
        int index = 1;
        int jump = 0;
        boolean canJumpBack = true;

        return solve(index, jump, canJumpBack);
    }
    public int solve(int index, int jump, boolean canJumpBack){

        if(index > K + 1){  //Base case (we cant go back to k-th stair with index value is greater than k+1)
            return 0;
        }

        String str = String.valueOf(index) + "_" + String.valueOf(jump) + "_" + String.valueOf(canJumpBack);

        if(memoizeMap.containsKey(str)){

            return memoizeMap.get(str);
        }

        int totalWays = 0;

        if(index == K){     //we we reach at k-th stair then increase the number of ways
            
            totalWays++;
        }
        //Now we have two possible ways 
        //1. we can go down stair by (index - 1) only if we are allowed for current turn
        if(canJumpBack == true){

            totalWays += solve(index - 1, jump, false);     //now for next turn we cant go downStair so (canJumpBack = false)
        }
        //2. we can go up stair by (index + 2 ^ jump) then jump becomes (jump + 1)
        totalWays += solve(index + (int)Math.pow(2, jump), jump+1, true);    //for next turn we can go downStair so (canJumpBack = true)
        memoizeMap.put(str, totalWays);
        
        return totalWays;   
    }
}
