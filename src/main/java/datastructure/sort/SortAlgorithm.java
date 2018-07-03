package datastructure.sort;

/**
 * @Author: wuxiaobing
 * @Date 2018/7/3
 **/
public class SortAlgorithm {

    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 1、将当前处理的记录赋给temp
            int tmp = arr[i];
            int j = i - 1;
            //2、对有序序列，从后往前遍历，直到当前处理的记录(j>=0&&temp<arr[j]为false为止)
            for (; j >= 0 && arr[j] > tmp; j--) {
                //3.将当前处理的位置的元素后移一位
                arr[j + 1] = arr[j];
            }
            //4.找到了不大于temp的位置，则将temp放置于该位置之后
            arr[j + 1] = tmp;
        }
    }

    public void shellInsert(int[] arr) {
        //希尔排序和直接插入排序类似，只是加了入了一个间隔因子d
        for (int d = arr.length / 2; d > 0; d /= 2) {
            for (int i = d; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - d;
                for (; j >= 0 && arr[j] > tmp; j -= d) {
                    arr[j + d] = arr[j];
                }
                arr[j + d] = tmp;
            }
        }
    }
}
