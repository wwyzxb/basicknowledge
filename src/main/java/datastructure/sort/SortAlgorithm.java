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

    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //使用min表示临时最小变量
            int min = arr[i];
            //使用pos记录临时最小变量的下标
            int pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    pos = j;
                }
            }
            //如果检测到i下标后面有最小变量，则进行位置交换
            if (pos != i) {
                arr[pos] = arr[i];
                arr[i] = min;
            }
        }
    }

    public void heapSort(int[] arr) {
        //构建大顶堆：根结点比左右子节点元素值都要大，子堆也满足同样的规则
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点调整，从下至上，从左至右
            adjustHeap(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            //将堆顶元素和数组末尾元素交换
            swap(arr, 0, i);
            //每次交换之后重新从堆顶开始调整堆
            adjustHeap(arr, 0, i);
        }
    }

    private void adjustHeap(int[] arr, int pos, int length) {
        //先取出待调整元素的值
        int temp = arr[pos];
        //调整的过程中可能造成局部不符合最大堆的定义，所以需要往下一层继续调整
        for (int i = pos * 2 + 1; i < length; i = i * 2 + 1) {
            //选取左右节点中较大的一个
            if (i + 1 < length && arr[i] < arr[i + 1]) {
                i++;
            }
            //比较子节点和待调整节点的值
            if (arr[i] > temp) {
                arr[pos] = arr[i];
                //继续对子树进行调整
                pos = i;
            } else {
                break;
            }
        }
        //将当前需要调整的
        arr[pos] = temp;

    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
