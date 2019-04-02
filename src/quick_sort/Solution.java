package quick_sort;

public class Solution {
    public static void sort(int[] num,int start,int end){
        if (start >= end) return;
        int loc = partition(num, start, end);
        sort(num,start,loc-1);
        sort(num,loc+1,end);
    }

    private static int partition(int[] num,int start,int end){
        int i = start;
        int j = end;
        int x = num[start];
        while (i != j){
            while(i < j && num[j] > x){
                j--;
            }
            while (i < j && num[i] <= x){
                i++;
            }
            if(i < j){
                swap(num,i,j);
            }
        }
        num[start] = num[i];
        num[i] = x;
        return i;
    }

    private static void swap(int[] num ,int i ,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        int[] num = {};
        sort(num,0,num.length-1);
        System.out.println(num);
    }
}
