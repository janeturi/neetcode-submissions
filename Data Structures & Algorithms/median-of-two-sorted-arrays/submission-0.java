class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // given two int arrays num1, size m
        // and num2, size n
        // we want to reeturn the medican value among all
        // elements of the two arrays

        // this odesnt look hard im confused, i think
        // difficult part is figueing out how to merge
        // both arrays ok i lied it works but not optimal

        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = (total + 1) / 2; // + 1 if odd for index reasonss
        // goal is to put both arrays side by side and
        // make it so that the left contains exactly 
        // half of total elmeents (or +1) if odd


        // this means that the median is the largest # on a
        // and smallest # on b

        if (B.length < A.length){
            int[] temp = A;
            A = B;
            B = temp;
        }
        // making sure a is the smaller array
        // we want to search the smaller array to avoid index
        // based errors

        int left = 0;
        int right = A.length;

        while(left <= right){
            
            int i = (left + right) / 2;
            // i is the cut index of a
            int j = half - i;
            // cut index of b, halving b

            // i will tell you how many letters from a go into left
            // and j will tell you how many letters from b go into left
            // it will only be valid if a <= b,
            // so with each pass, the number of i increases, therefore also
            // j and ends when the condition is no longer valid

            int Aleft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            // largest element on left side of a
            // if i > 0 = true, use A[i - 1] (element b4 half 
            // else, use the min value because that means there 
            // isn't enough -> just a placeholder

            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            // smallest elmeent on right side of a 

            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            // largest element on left side of b

            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;
            // smallest elmeent on right side of a
            // this is added to handle edge cases, like
            // when a section has 0 elmeents

            if (Aleft <= Bright && Bleft <= Aright){
                // valid partition
                if (total % 2 != 0){
                    return Math.max(Aleft, Bleft);
                    // odd -> return largest element in left half
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                // even -> average 
            } else if (Aleft > Bright){
                right = i - 1;
                // we have too many elmeents from a, we adjust to move left
            } else {
                left = i + 1;
                // too few elements from a, adjust right
            }
        }

        return -1;
    }
}
