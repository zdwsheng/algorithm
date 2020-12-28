package leetcode.回溯算法;

import java.util.LinkedList;
import java.util.List;

/**
 * @name 全排列
 * @ClassName Let46
 * @Description 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zdw
 * @date 2020/12/28 10:15
 */
public class Let46 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        List<List<Integer>> permuteList = permute(nums);
        System.out.println(permuteList);
    }

    private static final List<List<Integer>> result = new LinkedList<>();


    /**
     * 主函数，输入一组不重复的数字，返回它们的全排列
     *
     * @param nums
     * @return
     */
    private static List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return result;
    }

    /**
     * 路径：记录在 track 中
     * 选择列表：nums 中不存在于 track 的那些元素
     * 结束条件：nums 中的元素全都在 track 中出现
     *
     * @param nums
     * @param track
     */
    private static void backtrack(int[] nums, LinkedList<Integer> track) {
        // 1.4 触发结束条件
        if (track.size() == nums.length) {
            result.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 1.1  排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 1.2  做选择
            track.add(nums[i]);
            // 1.3  进入下一层决策树
            backtrack(nums, track);
            // 1.5 取消选择   到1.4之后，此条道路已经走到尽头，所以走回头路在选择
            track.removeLast();
        }
    }
}
