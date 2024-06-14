public class MinMaxSlidingWindow {

    static void minMaxSlidingWindow(int[] arr, int windowSize) {
        int n = arr.length;
        int front;
        int rear = windowSize - 1;
        for(front = 0; rear == windowSize-1 && rear <= n  -1 ; front++, rear++) {
            int min = arr[front];
            int max = arr[front];
            for(int i = front+1; i < front+windowSize ; i++) {
                if(arr[i] < min) {
                    min = arr[i];
                }
                if(arr[i] > max) {
                    max = arr[i];
                }
            }
            System.out.println(min + " " + max);
        }
    }
    public static void main(String[] args) {
        int data [] = {10, 3, 12, 50, 40, 15, 60, 1};
        int windowSize = 4;
        minMaxSlidingWindow(data, windowSize);
    }
    
}
