package sort;

public interface Sort {

    /**
     * 排序
     *
     * @param array
     * @return
     */
    int[] sort(int[] array);

    /**
     * desc:交换数组两个位置的值
     *
     * @param array
     * @param leftIndex
     * @param rightIndex
     */
    default void swap(int[] array, int leftIndex, int rightIndex) {
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
}
