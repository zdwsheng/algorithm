package search;

/**
 * @ClassName search.BinarySearch
 * @Description 二分法查找 时间复杂度：O(log2n),
 * @author: zdw
 * @date 2019/10/9 11:29
 */
public class BinarySearch implements Serach {
    private static final BinarySearch BINARY_SEARCH = new BinarySearch();

    public static void main(String[] args) {
        int target = 94;
        int[] array = new int[]{1, 10, 12, 59, 88, 94, 101};

        int index = BINARY_SEARCH.search(target, array);

        System.out.println(index);
    }

    /**
     * desc : 二分法查找 其实就是计算N个数除2需要多少次能除完 2^n = N
     *
     * @param target
     * @param array
     * @return
     */
    @Override
    public int search(int target, int[] array) {
        int left = 0;
        int right = array.length - 1;

        //判断必须要等于号，不然最右边的边界数字判断不到,eg:[2,3]
        while (right >= left) {
            int mid = (left + right) / 2;

            int temp = array[mid];

            if (temp == target) {
                return mid;
            }
            if (temp > target) {
                //减一 加一 是因为 下标为mid的就是temp 已经判断过了;如果target是array最右边界的，会死循环
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
