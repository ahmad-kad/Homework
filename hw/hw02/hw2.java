package hw.hw02;

public class hw2 {
    public int findBadVersion(int[] versions) {
        int left = 0;
        int right = versions.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(versions[mid])) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return isBadVersion(versions[left]) ? versions[left] : -1;
    }
}
}
