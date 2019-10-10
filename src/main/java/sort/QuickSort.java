package sort;

import com.fasterxml.jackson.core.JsonProcessingException;
import common.Common;

/**
 * @ClassName QuickSort
 * @Description 快速排序  时间复杂度： O(nlog(n)) (1) 找出简单的基线条件 (2) 确定如何缩小问题的规模，使其符合基线条件。
 * @author: zdw
 * @date 2019/10/10 10:16
 */
public class QuickSort implements Sort, Common {

    private static final QuickSort QUICK_SORT = new QuickSort();

    public static void main(String[] args) throws JsonProcessingException {
        int[] array = new int[]{9, 2, 1, 7, 4, 3, 8, 5, 6, 11, 10};
        QUICK_SORT.toJsonStringAndSout(array);
        QUICK_SORT.sort(array);
        QUICK_SORT.toJsonStringAndSout(array);
    }

    /**
     * 通过基准点，让基准点左边数字全部小于基准点，右边全部大于基准点，然后将基准点左右两边数组在进行快排
     * 以最左边作为基准点
     *
     * @param array
     * @return
     */
    @Override
    public int[] sort(int[] array) {
        partition(array, 0, array.length - 1);
        return array;
    }

    private void partition(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = this.quickSortInternally(array, left, right);
        partition(array, left, index - 1);
        partition(array, index + 1, right);
    }

    /**
     * 找到基准点下标位置
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private int quickSortInternally(int[] array, int left, int right) {
        //基准值
        int temp = array[right];
        //交换位置
        int index = left;
        for (int j = left; j < right; j++) {
            //找到所有比基准值小的数字
            if (array[j] < temp) {
                this.swap(array, index, j);
                index++;
            }
        }
        //最后将基准值归位到index处,这样基准值左边的数字都比基准值大，右边的都比其小
        swap(array, index, right);
        return index;
    }
}
