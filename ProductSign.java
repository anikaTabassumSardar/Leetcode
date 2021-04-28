public class ProductSign {

    public static void main(String[] args){
        ProductSign productSign = new ProductSign();
        int[] nums = {-1,-1, -1, -1, -1};
        System.out.println(productSign.isPositive(nums));
    }

    public boolean isPositive(int[] nums){
        int countNeg = 0;
        for(int n : nums){
            if(n == 0) return true; //if any one of the element is 0, the product will always be positive
            if(n < 0) countNeg++;
        }

        return (countNeg% 2) == 0; // if even number of negative elements exist, then we know the product will be positive, else negative

        /**
         * Complexities:
         *
         * Time: O(N) since we are iterating through all elements once
         * Space: O(1) as no extra space is required
         */
    }

    /**
     * Problem Statement:
     * Given an array of nums, determine the final sign of the product of all numbers in the array.
     *
     * He said:
     * Set a count to 0 and loop through the array.
     * If element ==0
     * return false
     * If element > 0
     * increment count
     *
     * Return count % 2 == 0
     */
}
