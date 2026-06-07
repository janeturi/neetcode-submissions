class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        # given an array of nums sort in ascending number
        # without using built in functions!

        def merge(arr, L, M, R):
            left, right = arr[L:M+1], arr[M+1:R+1] # split the halves to sort
            i, j, k = L, 0, 0 # our pointers

            while j < len(left) and k < len(right): # our pointers have not reeached the end of our halves
                if left[j] <= right[k]: # if the pointer on the left is less
                    arr[i] = left[j] # change in our result arrya
                    j += 1 # then move forward
                else:
                    arr[i] = right[k] # else do the opposite
                    k += 1 # move 
                i += 1 # move in our result array
                # this is self explanatory, move in all 3 of our arrays as we traverse and 
                # encounter smaller numbers and need a swap

            while j < len(left): # copy any remaining elements from either array 
            # i think this handles uneven halves? 
                arr[i] = left[j]
                j += 1
                i += 1

            while k < len(right):
                arr[i] = right[k]
                k += 1
                i += 1

        def mergeSort(arr, l, r):
            # divides the array into two halves
            # and does so recursively so it keeps going and going and goig and going
            if l >= r: 
                return 
            m = (l + r) // 2
            mergeSort(arr, l, m) # call a sort half function
            mergeSort(arr, m + 1, r) # call a sort half function 
            merge(arr, l, m, r) # merge both halves

        mergeSort(nums, 0, len(nums) - 1) # merge all
        return nums # then return the result array