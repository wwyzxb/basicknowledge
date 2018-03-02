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

    public int[] bubbleSort(int[] arr){
        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<i;j++){}
        }
        return arr;
    }



    @Test
    public void testResult() {
        printResult(insertSort(new int[]{1, 6, 5, 0, 2, 7, 4, 9, 3, 8}));
        printResult(shellSort(new int[]{1, 6, 5, 0, 2, 7, 4, 9, 3, 8}));
        printResult(simpleSelectSort(new int[]{1, 6, 5, 0, 2, 7, 4, 9, 3, 8}));
    }

    public void printResult(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
