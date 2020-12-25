package leetcode.动态规划;

/**
 * @name
 * @ClassName Let322
 * @Description 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zdw
 * @date 2020/12/24 17:00
 */
public class Let322 {

    static int[] coins = new int[]{1, 3, 5};


    public static void main(String[] args) {
        for (int i = 0; i <= 11; i++) {
            System.out.println("凑齐 " + i + " 元需要 " + dpCache(i) + " 个硬币");
        }
    }


    private static int dp(int amount) {
        //2.1如果刚好有解  amount-coin=0 ，返回0，subProblem可以+1
        if (amount == 0) {
            return 0;
        }
        //2.2如果无解，amount-coin<0,返回-1
        if (amount < 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        //1.便利所有的硬币
        for (int coin : coins) {

            //2.如果选择此枚硬币coin,那么求子问题的解subProblem,subProblem有解则加上一枚硬币（值为coin）即可
            int subProblem = dp(amount - coin);
            //2.3如果方程无解，continue
            if (subProblem == -1) {
                continue;
            }
            //方程有解,从min 和 subProblem+1中选择一个最小解
            min = Math.min(min, subProblem + 1);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }


    private static int[] cache;

    private static int dpCache(int amount) {

        cache = new int[amount + 1];

        //2.1如果刚好有解  amount-coin=0 ，返回0，subProblem可以+1
        if (amount == 0) {
            return 0;
        }
        //2.2如果无解，amount-coin<0,返回-1
        if (amount < 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        //1.便利所有的硬币
        for (int coin : coins) {

            int balance = amount - coin;
            int subProblem = -1;
            //2.如果选择此枚硬币coin,那么求子问题的解subProblem,subProblem有解则加上一枚硬币（值为coin）即可
            if (balance >= 0) {
                if (cache[balance] != 0) {
                    subProblem = cache[balance];
                } else {
                    subProblem = dp(balance);
                }
            }

            //2.3如果方程无解，continue
            if (subProblem == -1) {
                continue;
            }
            //方程有解,从min 和 subProblem+1中选择一个最小解
            min = Math.min(min, subProblem + 1);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
