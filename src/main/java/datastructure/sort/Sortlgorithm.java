package datastructure.sort;

/**
 * @Author: wuxiaobing
 * @Date 2018/3/2
 **/
public class Sortlgorithm {
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 2, 4, 8, 3, 9};
        insertSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
