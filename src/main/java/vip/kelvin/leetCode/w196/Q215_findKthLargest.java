package vip.kelvin.leetCode.w196;

/**
 * 堆排序
 * @author Kelvin范显
 * @date 2020/6/29 下午4:58
 */
class Q215_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int left = i * 2 + 1, right = i * 2 + 2, largest = i;
        if (left < heapSize && a[left] > a[largest]) largest = left;
        if (right < heapSize && a[right] > a[largest])  largest = right;
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int largest) {
        int temp = a[i];
        a[i] = a[largest];
        a[largest] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int k = 2;
        Q215_findKthLargest q215_findKthLargest = new Q215_findKthLargest();
        int kthLargest = q215_findKthLargest.findKthLargest(nums, k);
        System.out.println(kthLargest);
    }
}