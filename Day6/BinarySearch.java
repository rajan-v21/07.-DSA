public class BinarySearch {
    void binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                System.out.println("Element found at index " + mid);
            if (arr[mid] > x)
                binarySearch(arr, l, mid - 1, x);
            if (arr[mid] < x)
                binarySearch(arr, mid + 1, r, x);
        }
    }
    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        BinarySearch ob = new BinarySearch();
        ob.binarySearch(arr, 0, n - 1, x);
    }
}
