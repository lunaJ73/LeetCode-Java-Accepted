/*
 * 198. House Robber
 * Target: Given a list of non-negative integers representing the amount of money of each house, 
 *         determine the maximum amount of money you can rob tonight without alerting the police.
 *         it will automatically contact the police if two adjacent houses were broken into on the same night. 
 * Difficulty：Easy
 * Classification：DP
 * Source Detail: https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */

/*
 * Solution 1
 * 2019-08-05  Runtime: ? ms
 * Algorithm: => Recursion(top-down). Formula: rob(i) = Math.max(rob(i - 1), rob(i - 2) + currentHouseValue) 
 * Time Complexity: ?. Space Conplexity: ?. 
 * Note: Time Limit Exceeded 
 */

class Solution {
    public int rob(int[] nums) {
        return helperRob(nums, nums.length - 1);
    }
    
    private int helperRob(int[] nums, int i) {
        if (i < 0) return 0;
        return Math.max(helperRob(nums, i - 1), helperRob(nums, i - 2) + nums[i]);
    }
}


/*
 * Solution 2
 * 2019-08-05  Runtime: 7 ms
 * Algorithm: => Recursion + res[](top-down). Optimal of sol 1. Formula: rob(i) = Math.max(rob(i - 1), rob(i - 2) + currentHouseValue) 
 * Time Complexity: O(n). Space Conplexity: O(n). 
 */
 
 class Solution {
    public int rob(int[] nums) {
        int[] res = new int[nums.length + 1];
        Arrays.fill(res, -1);
        return helperRob(nums, nums.length - 1, res);
    }
    
    private int helperRob(int[] nums, int i, int[] res) {
        if (i < 0) return 0;
        if (res[i] >= 0) return res[i];
        res[i] = Math.max(helperRob(nums, i - 1, res), helperRob(nums, i - 2, res) + nums[i]);
        return res[i];
    }
}


/*
 * Solution 3
 * 2019-08-05  Runtime: 0 ms
 * Algorithm: => Iteration(bottom-up). 
 * Time Complexity: O(n). Space Conplexity: O(n). 
 */
 
 class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] res = new int[nums.length + 1];
        res[0] = 0;
        res[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i + 1] = Math.max(res[i], res[i - 1] + nums[i]);
        }
        return res[nums.length];
    }
}


/*
 * Solution 4
 * 2019-08-05  Runtime: 7 ms
 * Algorithm: => Iteration + 2 variables(bottom-up). Optimal of sol 3. Going just 2 steps back, like Fibonacci sequence.
 * Time Complexity: O(n). Space Conplexity: O(1). 
 */
 
 class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int pre1 = 0;
        int pre2 = 0;
        for (int num : nums) {
            int tmp = pre1;
            pre1 = Math.max(pre1, pre2 + num);
            pre2 = tmp;
        }
        return pre1;
    }
}
