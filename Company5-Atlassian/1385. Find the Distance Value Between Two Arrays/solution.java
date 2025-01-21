class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int j=0;
        int rs=0;
        int sal=arr2.length;
        for(int i=0;i<arr1.length;i++){
            j=0;
            int flg=0;
            while(j<sal){
                if(Math.abs(arr1[i]-arr2[j])<=d){
                    flg=1;
                    break;
                }
                j++;
            }
            if(flg==0){rs++;}
        }
        return rs;
    }
}
