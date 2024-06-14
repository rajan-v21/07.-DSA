public class BubbleSort {
    void bubble_sort(int arr[], int n) {
        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length;
        BubbleSort ob = new BubbleSort();
        ob.bubble_sort(arr, n);
        System.out.println("Sorted array");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }
}
