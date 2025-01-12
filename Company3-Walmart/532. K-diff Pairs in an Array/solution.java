//  // O(n) Time Solution

//  class Solution {
//  		public int findPairs(int[] nums, int k) {
//  			Map<Integer, Integer> map = new HashMap();
//  			for (int num : nums)
//  				map.put(num, map.getOrDefault(num, 0) + 1);

//  			int result = 0;
//  			for (int i : map.keySet())
//  				if (k > 0 && map.containsKey(i + k) || k == 0 && map.get(i) > 1)
//  					result++;
//  			return result;
//  		}
//  	}
// class Solution {
//     public int findPairs(int[] nums, int k) {
//         Arrays.sort(nums);
//         int i=0, j=1, diff=0, n=nums.length, sum=Integer.MIN_VALUE;
//         int count=0;
//         while(j<n && i<n-1){
// 		    // ((nums[i]+nums[j])!=sum) -> this will take care of no repetetion
// 			//if we found any match, increase i , j by 1
//             if(nums[j]-nums[i]==k && (nums[i]+nums[j])!=sum){
//                 sum=nums[i]+nums[j];
//                 i++; j++; count++;
//             }
// 			//if diff is smaller than k increase j by 1
// 			else if((nums[j]-nums[i])<k){
//                 j++;
//             }
// 			//else case, when diff is greater than k, increase i by 1
// 			else{
//                 i++;
//             }
// 			//check if i and j are not same to aoid duplicates
//             if(i==j) j++;
//         }
//         return count;
//     }
// }
class Solution {
    public int findPairs(int[] nums, int k) {
	    // corner cases
        if(nums==null || nums.length==0 || k<0) return 0;
        int count=0;
        Map<Integer, Integer> hash=new HashMap<>();
		//frequency map
        for(int i:nums)
            hash.put(i, hash.getOrDefault(i, 0)+1);
        for(Map.Entry<Integer, Integer> entry:hash.entrySet())
		    // check if any such pair exist or not
			//in case of k==0 check whether any number having frequency >=2 or not.
            if((hash.containsKey(entry.getKey()+k) && k!=0) || (k==0 && entry.getValue()>1))
                count++;
        return count;
    }
}
