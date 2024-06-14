public class Sorting_Examples {
    void quick_sort(int a[], int start, int end) {
        int i, j, pivot;
        i = start;
        j = end;
        pivot = start;// start j:end 
        while(i < j)
        {
            while (a[i] < a[pivot])
                i++;
            while (a[j] > a[pivot])
                j--;    
            if (i < j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        if (i < end)
            quick_sort(a, i + 1, end);
        if (j > start)
            quick_sort(a, start, j - 1);
    }

    void merger(int a[], int start, int mid, int end) {
        int i = start, j = mid + 1;
        int t[] = new int[a.length];
        int ti = start;
        while (i <= mid && j <= end) {
            if (a[i] < a[j])
                t[ti++] = a[i++];
            else
                t[ti++] = a[j++];
        }
        while (i <= mid)
            t[ti++] = a[i++];
        while (j <= end)
            t[ti++] = a[j++];
        for (i = start; i <= end; i++)
            a[i] = t[i];
    }

    void mergesort(int a[], int start, int end) {
        if (start < end)// at most size 1
        {
            int mid = (start + end) / 2;
            mergesort(a, start, mid);
            mergesort(a, mid + 1, end);
            merger(a, start, mid, end);
        }
    }

    void selection_sort(int a[]) {
        int min, pos;
        for (int i = 0; i < a.length; i++) { // ref
            min = a[i];
            pos = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    pos = j;
                }
            }
            // swap a[i] -a[pos] a[pos]=a[i];
            a[i] = min;
        }
    }

    void insertion_sort(int a[]) {
        int i, j, new_element;
        for (i = 0; i < a.length - 1; i++) {
            new_element = a[i + 1];
            j = i + 1;
            while (j > 0 && a[j - 1] > new_element) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = new_element;
        }
    }

    void bubble_sort(int a[]) {
        int i, j, t;
        boolean flag;
        for (i = a.length - 1; i > 0; i--) {
            flag = true;
            for (j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    flag = false;
                    t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            } // j //flag==true-----if true means no swap means sorted 
            if(flag) break;
        }
    }

    void print_Array(int a[]) {
        System.out.println("Array has:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " , ");
        }
    }

    public static void main(String args[]) {
        int a[] = { 55, 11, 22, 99, 33, 66, 44, 77, 88 };
        Sorting_Examples obj = new Sorting_Examples();
        // obj.mergesort(a,0,a.length-1); //obj.quick_sort(a,0,a.length-1);
        // //obj.selection_sort(a); // // obj.insertion_sort(a); obj.bubble_sort(a);
        obj.print_Array(a);
    }

}