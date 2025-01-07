import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        long sum = 0, mx = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            while (s.contains(nums[i])) {
                sum -= nums[j];
                s.remove(nums[j]);
                j++;
            }

            s.add(nums[i]);
            sum += nums[i];

            if (s.size() == k) {
                mx = Math.max(mx, sum);
                sum -= nums[j];
                s.remove(nums[j]);
                j++;
            }
        }

        return mx;
    }
}
// class Solution {
//     public long maximumSubarraySum(int[] arr, int k) {
//         Map<Integer, Integer> um = new HashMap<>();
//         int l = 0, r;
//         long lastSum = 0;

//         for (r = 0; r < k; r++) {
//             um.put(arr[r], um.getOrDefault(arr[r], 0) + 1);
//             lastSum += arr[r];
//         }

//         long sum = 0;
//         while (r <= arr.length) {
//             if (um.size() == k) { // Check if window is distinct
//                 sum = Math.max(lastSum, sum);
//             }

//             if (l < arr.length) {
//                 um.put(arr[l], um.get(arr[l]) - 1);
//                 if (um.get(arr[l]) == 0) {
//                     um.remove(arr[l]);
//                 }
//                 lastSum -= arr[l];
//                 l++;
//             }

//             if (r < arr.length) {
//                 um.put(arr[r], um.getOrDefault(arr[r], 0) + 1);
//                 lastSum += arr[r];
//             }
//             r++;
//         }

//         return sum;
//     }
// }
// import java.util.HashMap;

// class Solution {
//     public long maximumSubarraySum(int[] nums, int k) {
//         long sum = 0, maxi = 0;
//         int l = 0;
//         HashMap<Integer, Integer> freq = new HashMap<>();

//         for (int r = 0; r < nums.length; r++) {
//             sum += nums[r];
//             freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);

//             if (r - l + 1 == k) {
//                 if (freq.size() == k) {
//                     maxi = Math.max(maxi, sum);
//                 }
//                 sum -= nums[l];
//                 freq.put(nums[l], freq.get(nums[l]) - 1);
//                 if (freq.get(nums[l]) == 0) freq.remove(nums[l]);
//                 l++;
//             }
//         }
//         return maxi;
//     }
// }
