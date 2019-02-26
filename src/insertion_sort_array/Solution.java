package insertion_sort_array;

//数组的插入排序
//双循环 插入的时候从后往前比较大小
public class Solution {
    public static void insertSort(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return;
        }
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) { //从后往前比较
                if (array[j] < array[j - 1]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                } else break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4,5,3,9,3,7,2,1};
        insertSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
