package datastructure.sort;

import org.junit.Test;

/**
 * @Author: wuxiaobing
 * @Date 2018/3/2
 **/
public class SortAlgorithm {

    public int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];//为待插入的元算空出位置
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;//每一次内部遍历之后，将待插入元素放置给定位置
        }
        return arr;
    }

    public int[] shellSort(int[] arr) {
        for (int d = arr.length / 2; d > 0; d /= 2) {//使用增量d来控制插入排序
            for (int i = d; i < arr.length; i++) {
                int j = i - d;
                int temp = arr[i];
                for (; j >= 0; j -= d) {
                    if (arr[j] > temp) {
                        arr[j + d] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + d] = temp;
            }
        }
        return arr;
    }

    public int[] simpleSelectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int flag = i;
            for (int j = i; j < arr.length; j++) {
                if (temp > arr[j]) {
                    temp = arr[j];
                    flag = j;
                }
            }

            if (i != flag) {
                arr[flag] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    public int[] bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public int partition(int[] arr, int low, int high) {
        int privot = arr[low];
        while (low < high) {
            while (low < high && privot <= arr[high]) high--;
            if (low < high) {
                arr[low] = arr[high];
                low++;
            }
            while (low < high && privot >= arr[low]) low++;
            if (low < high) {
                arr[high] = arr[low];
                high--;
            }
        }
        arr[low] = privot;
        return low;
    }

    public int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            quickSort(arr, 0, partition - 1);
            quickSort(arr, partition + 1, high);
        }
        return arr;
    }

    public void mergeArray(int[] arr, int low, int mid, int high) {
        int llen = mid - low + 1;
        int rlen = high - mid;

        int[] L = new int[llen];
        int[] R = new int[rlen];


        /**这里的k=low的取值要注意*/
        for (int i = 0, k = low; i < llen; i++, k++) {
            L[i] = arr[k];
        }

        for (int i = 0, k = mid + 1; i < rlen; i++, k++) {
            R[i] = arr[k];
        }
        /**这里的k=low的取值要注意*/
        int r = 0, l = 0, k = low;

        while (r < rlen && l < llen) {
            if (R[r] <= L[l]) {
                arr[k++] = R[r++];
            } else {
                arr[k++] = L[l++];
            }
        }

        while (r < rlen) arr[k++] = R[r++];
        while (l < llen) arr[k++] = L[l++];
    }

    public int[] mergeSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;

        if (low < high) {
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            mergeArray(arr, low, mid, high);
        }
        return arr;

    }


    @Test
    public void testResult() {
        printResult(insertSort(new int[]{1, 6, 5, 0, 2, 7, 4, 9, 3, 8}));
        printResult(shellSort(new int[]{1, 6, 5, 0, 2, 7, 4, 9, 3, 8}));
        printResult(simpleSelectSort(new int[]{1, 6, 5, 0, 2, 7, 4, 9, 3, 8}));
        printResult(bubbleSort(new int[]{1, 6, 5, 0, 2, 7, 4, 9, 3, 8}));
        printResult(quickSort(new int[]{1, 6, 5, 0, 2, 7, 4, 9, 3, 8}, 0, 9));
        printResult(mergeSort(new int[]{1, 6, 5, 0, 2, 7, 4, 9, 3, 8}, 0, 9));
    }

    public void printResult(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
