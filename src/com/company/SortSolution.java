package com.company;

/**
 * Created by yzc on 17/3/23.
 */
public class SortSolution {

    public void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public void bubbleSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            boolean isSwap = false;
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                    isSwap = true;
                }
            }
            if (!isSwap) break;
        }
    }

    // 直接选择排序
    public void selectSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }
    }

    // 直接插入排序，数列基本有序的情况下效率很高
    public void insertSort(int a[]) {
        for (int i = 1; i < a.length; i++) {
            // 如果无序数列中前后两个数已经有序，则不用做这一次循环
            if (a[i] < a[i-1]) {
                int index = i;
                int tmp = a[i];
                // 每一次从无序数列中拿一个数插入到有序数列中，如果小，就把大的数往后串一个位置，同时记录应该插入数据的位置，最后把数放入
                for (int j = i - 1; j >= 0; j--) {
                    if (tmp < a[j]) {
                        index = j;
                        a[j + 1] = a[j];
                    }
                }
                a[index] = tmp;
            }
        }
    }

    // 希尔排序：折半步长 + 直接插入排序

    // 归并排序,时间复杂度n*logn，较为快速
    public void mergeArray(int a[], int first, int mid, int last, int result[]) {
        int i = first;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= last) {
            if (a[i] < a[j]) {
                result[k++] = a[i++];
            }
            else {
                result[k++] = a[j++];
            }
        }

        while (i <= mid) {
            result[k++] = a[i++];
        }

        while (j <= last) {
            result[k++] = a[j++];
        }

//        for (int l = 0; l < k; l++) {
//            a[first+l] = result[l];
//        }
        System.arraycopy(result, 0, a, first, k);
    }

    public void mergeSort(int a[], int first, int last, int result[]) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(a, first, mid, result);
            mergeSort(a, mid + 1, last, result);
            mergeArray(a, first, mid, last, result);
        }
    }

    // 快速排序
    public void quickSort(int a[], int first, int last) {
        if (first < last) {
            int i = first;
            int j = last;
            int tmp = a[i];
            while (i < j) {
                while (i < j && a[j] > a[i]) {
                    j--;
                }
                if (i < j) {
                    swap(a, i, j);
                    i++;
                }

                while (i < j && a[i] < a[j]) {
                    i++;
                }
                if (i < j) {
                    swap(a, i, j);
                    j--;
                }
            }
            a[i] = tmp;
            quickSort(a, first, i - 1);
            quickSort(a, i + 1, last);
        }
    }


}
