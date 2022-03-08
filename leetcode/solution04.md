# leetCode 4. Median of Two Sorted Arrays

- [문제 링크](https://leetcode.com/problems/median-of-two-sorted-arrays/)

</br>

```java

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int len = m+n;

        int[] arr = new int[len];

        int i=0;
        int j=0; // nums1 index
        int k=0; // nums2 index

        while(j<m && k<n)
            arr[i++] = nums1[j] < nums2[k] ? nums1[j++] : nums2[k++];

        while(j<m)
            arr[i++] = nums1[j++];

        while(k<n)
            arr[i++] = nums2[k++];

        if(len % 2 ==0)
            return (double)(arr[len/2 - 1] + arr[len/2]) / 2.0;
        else
            return (double)arr[len/2];

    }
}

```
