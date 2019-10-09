package sort;

import com.fasterxml.jackson.core.JsonProcessingException;
import common.Common;

/**
 * @ClassName SelectiveSorting
 * @Description 选择排序 时间复杂度： O(n^2)
 * @author: zdw
 * @date 2019/10/9 15:02
 */
public class SelectiveSorting implements Sort, Common {

    private static final SelectiveSorting SELECTIVE_SORTING = new SelectiveSorting();


    public static void main(String[] args) throws JsonProcessingException {
        int[] array = new int[]{213, 35, 1, 25, 2, 72, 15, 61, 73, 12, 74};
        SELECTIVE_SORTING.toJsonStringAndSout(array);
        SELECTIVE_SORTING.sort(array);
        SELECTIVE_SORTING.toJsonStringAndSout(array);
    }

    /**
     * 遍历数组，每次找到最小数字和当下数字进行交换
     *
     * @param array
     * @return
     */
    @Override
    public int[] sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            //最小数据下标
            int minIndex = i;

            //找到最小的数字下标
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            //交换
            this.swap(array, i, minIndex);
        }
        return array;
    }
}
