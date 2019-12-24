package leetcode;

import com.fasterxml.jackson.core.JsonProcessingException;
import common.Common;

/**
 * @name
 * @ClassName Code_88
 * @Description leetCode 88题目 归并领个有序数组
 * @author: zdw
 * @date 2019/12/24 11:01
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 遍历m+n次,依次从两个数组两端找到最大的插入到nums1[]中
 */
public class Code_88 implements Common {

    private Code_88() {
    }

    private static final Code_88 CODE_88_INSTANCE = new Code_88();

    public static void main(String[] args) throws JsonProcessingException {
        int[] left = new int[20];
        left[0] = 1;
        left[1] = 3;
        left[2] = 5;
        left[3] = 6;
        left[4] = 15;
        int[] right = new int[]{2, 4, 7, 10, 12};
        int[] merge = CODE_88_INSTANCE.merge(left, 5, right, right.length);
        System.out.println(CODE_88_INSTANCE.toJsonString(merge));
    }

    public int[] merge(int[] left, int leftLength, int[] right, int rightLength) {
        //总长度遍历次数
        int k = leftLength + rightLength - 1;

        //左边数组长度
        int i = leftLength - 1;

        //右边数组长度
        int j = rightLength - 1;
        for (; k > 0; k--) {
            //左边数组遍历完了
            if (i < 0) {
                left[k] = right[j--];
                continue;
            }
            //右边数组遍历完了
            if (j < 0) {
                left[k] = left[i--];
                continue;
            }

            //每次都比较数组两端右边，看哪一个值大，值大的插入到left[k]中
            if (left[i] > right[j]) {
                left[k] = left[i--];
            } else {
                left[k] = right[j--];
            }
        }
        return left;

    }
}
