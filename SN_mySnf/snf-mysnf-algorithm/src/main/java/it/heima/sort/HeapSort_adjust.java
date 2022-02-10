package it.heima.sort;

import java.util.Arrays;

public class HeapSort_adjust {
    //这是一个全局变量，用于标记还剩多少数需要排序
    public static int len;

    public static void main(String[] args) {
        int[] array = new int[]{9, 8, 7, 6, 5, 43, 1};
//        int[] array = new int[]{8,9,10};
        HeapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len < 1) return array;
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }

    /**
     * 建立最大堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len / 2 - 1); i >= 0; i--) { //感谢 @让我发会呆 网友的提醒，此处应该为 i = (len/2 - 1)
            adjustHeap(array, i);
        }
    }

    /**
     * 调整使之成为最大堆
     * 以array[i]为根节点构造大顶堆
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if ((i * 2+1) < len && array[i * 2+1] > array[maxIndex])
            maxIndex = i * 2+1;
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 2 < len && array[i * 2 + 2] > array[maxIndex])
            maxIndex = i * 2 + 2;
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            //保证了左右子树继续是大顶堆
            adjustHeap(array, maxIndex);
        }
    }

    //交换数组的两个index
    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
}