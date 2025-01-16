class Solution {
        public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for (int ast : asteroids) {
            if (mass < ast) {
                return false;
            }else if (mass > 100_000) { // now we can conclude all can be destroyed.
                return true;
            }
            mass += ast;
        }
        return true;
    }
}
