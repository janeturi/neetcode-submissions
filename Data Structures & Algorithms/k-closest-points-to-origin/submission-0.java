class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // given a 2d array points where 
        // points[i] = [xi, yi] reps the coords 

        // we need to return the k closed points to the 
        // origin [0,0]

        // distance is defined as the euclidean distance
        // sqrt((xl - x2)^2 + (y1 - y2)^2)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(
            b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));
        // orangizing priority (if res < 0, a < b, res > 0, b > a, res = 0, equal prior)
        // the points tell u distance, 
        // max-heap (thats why its
        // flipped) where the heap stores farthest at top
        // so we can pop farthest when we add more points
        
        for(int[] point : points){
            maxHeap.offer(point); // add points to array
            if(maxHeap.size() > k) maxHeap.poll(); // remove
            // points if the size is greater than k
        }

        int[][] res = new int[k][2]; // stores result array
        int i = 0;
        while(!maxHeap.isEmpty()){
            res[i++] = maxHeap.poll(); // adds points to res
            // array 
        }
        return res;
    }
}
