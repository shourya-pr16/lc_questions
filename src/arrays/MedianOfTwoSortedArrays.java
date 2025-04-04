package arrays;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = nums1.length;
        int partition = (nums1.length + nums2.length + 1) >> 1;

        while (low <= high) {
            int m1 = (low + high) >> 1;
            int m2 = partition - m1;

            int l1 = m1 == 0 ? Integer.MIN_VALUE : nums1[m1-1];
            int l2 = m2 == 0 ? Integer.MIN_VALUE : nums2[m2-1];

            int r1 = m1 == nums1.length ? Integer.MAX_VALUE : nums1[m1];
            int r2 = m2 == nums2.length ? Integer.MAX_VALUE : nums2[m2];

            if(r1 >= l2 && r2 >= l1) {
                if(((nums1.length+nums2.length)&1) == 0) {
                    return (Math.max(l1,l2) + Math.min(r1,r2)) >> 1;
                } else {
                    return Math.max(l1, l2);
                }
            }
            if(l1>r2) {
                high = m1 -1;
            } else {
                low = m1 + 1;
            }
        }
        return 0d;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,4,7,10,12};
        int[] arr2 = new int[]{2,3,6,15};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
