package leetcode.动态规划;

/**
 * @name
 * @ClassName DpBase
 * @Description 动态规划基本框架
 * @author: zdw
 * @date 2020/12/25 10:56
 */
public abstract class DpBase {

    void base() {
        /**
         *   # 初始化 base case
         *   dp[0][0][...] = base
         *   # 进行状态转移
         *   for 状态1 in 状态1的所有取值：
         *       for 状态2 in 状态2的所有取值：
         *           for ...
         *               dp[状态1][状态2][...] = 求最值(选择1，选择2...)
         */
    }
}
