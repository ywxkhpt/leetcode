package sort_array;
//需要辅助空间
public class Solution {

    public static void mergeSort(int[] arrays,int start,int end){//归并排序
        if (arrays == null || arrays .length == 0 ){
            return;
        }

        if (start == end){ //长度是1 就返回
            return;
        }

        //step1 分两部分
        int mid =  start + (end - start)/2;

        //step2 对两部分归并排序
        mergeSort(arrays,start,mid);
        mergeSort(arrays,mid+1,end);

        //step3 对排序的两部分进行合并
        merge(arrays,start,mid,end);
    }

    public static void merge(int[] array,int left,int mid,int right){ //归并
        int start1 = left;
        int end1 = mid;
        int start2 = mid + 1;
        int end2 = right;

        int[] temp = new int[right - left + 1]; //存储结果 最后写入原数组
        int tempStart = 0;

        while(start1 <= end1 && start2 <= end2){
            if (array[start1] < array[start2]){
                 temp[tempStart] = array[start1];
                 start1++;
            }else {
                temp[tempStart] = array[start2];
                start2++;
            }
            tempStart++;
        }

        while (start1 <= end1){
            temp[tempStart] = array[start1];
            start1++;
            tempStart++;
        }

        while (start2 <= end2){
            temp[tempStart] = array[start2];
            start2++;
            tempStart++;
        }

        tempStart = 0;

        while (left <= right){ //复制回去
            array[left] = temp[tempStart];
            left++;
            tempStart++;
        }

    }

    public static void main(String[] args) {
        int[] arrays = {9, 2, 5, 1, 3, 2, 9, 5, 2, 1, 8};
        mergeSort(arrays,0,arrays.length - 1);
        for (int i : arrays) {
            System.out.print(i + " ");
        }
    }
}
