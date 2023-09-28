package BinarySearch;

// TODO: not working
public class AllocateBooks {

    private boolean isPossible(int n, int m, int mid, int[] arr) {
        int studentcount = 1;
        int pagesum = 0;
        for (int i = 0; i < n; i++) {
            if (pagesum + arr[i] <= mid) {
                pagesum += arr[i];
            } else {
                studentcount++;
                if (studentcount > m || arr[i] > mid) {
                    return false;
                }
                pagesum = arr[i];
            }
        }
        return true;
    }

    public long allocateBooks(int n, int m, int[] arr) {
        int s = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int e = sum;
        int ans = -1;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (isPossible(n, m, mid, arr)) {
                ans = mid;
                s = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }

        System.out.println(ans);
        return ans;
    }

}
