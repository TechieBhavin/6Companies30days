class Solution {
    public int maxProduct(String s) {
        char[] strArr = s.toCharArray();
        int n = strArr.length;
        Map<Integer, Integer> pali = new HashMap<>();
        // save all elligible combination into hashmap
        for (int mask = 0; mask < 1<<n; mask++){
            String subseq = "";
            for (int i = 0; i < 12; i++){
                if ((mask & 1<<i) > 0)
                    subseq += strArr[i];
            }
            if (isPalindromic(subseq))
                pali.put(mask, subseq.length());
        }
        // use & opertion between any two combination
        int res = 0;
        for (int mask1 : pali.keySet()){
            for (int mask2 : pali.keySet()){
                if ((mask1 & mask2) == 0)
                    res = Math.max(res, pali.get(mask1)*pali.get(mask2));
            }
        }

        return res;
    }

    public boolean isPalindromic(String str){
        int j = str.length() - 1;
        char[] strArr = str.toCharArray();
        for (int i = 0; i < j; i ++){
            if (strArr[i] != strArr[j])
                return false;
            j--;
        }
        return true;
    }
}
