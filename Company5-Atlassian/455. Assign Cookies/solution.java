class Solution {
    public int findContentChildren(int[] g, int[] s) {
//sort the array
        Arrays.sort(g); Arrays.sort(s);
// intialize the count for tracking assign of cookies.
        int count = 0;
// intialize two pointer i = 0 and j = 0 to iterate on g and s 
        int i = 0, j = 0;
        while(i < g.length && j < s.length) {
//if g[i] <= s[i], means we can assign jth cookie to ith child,
// increase the count and increment i and j pointer.4
// else we will increase the cookie pointer j till we get  g[i] <= s[i]
            if(g[i] <= s[j]) {
                count++;
                i++; j++;
            }
            else j++;
        }
        return count;
    }
}
