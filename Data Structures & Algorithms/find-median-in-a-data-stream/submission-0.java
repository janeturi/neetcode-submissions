class MedianFinder {
    // we are finding the median while numbers
    // are continously being added
    
private Queue<Integer> smallHeap; // smallheap to store
// the smaller half of numbers
private Queue<Integer> largeHeap; // largeheap to store
// the larger half

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a, b) -> b - a); // hopes to make 
        // a max heap, if negative, a is bigger
        // and goes to the top
        largeHeap = new PriorityQueue<>((a, b) -> a - b); // 
    }// a min heap, a - b will rturn a negative
    // which makes it 'smaller' and a will be given priority
    
    public void addNum(int num) {
        smallHeap.add(num); // add new numbers to small
        // heap
        if(
            smallHeap.size() - largeHeap.size() > 1 ||
            // if unbalnaced halves
            !largeHeap.isEmpty() && 
            smallHeap.peek() > largeHeap.peek() // small
            // top value is greater than large's
        ) {
            largeHeap.add(smallHeap.poll()); // if unbalanced,
            // we add smallHeap's value to rebalance again
        }
        if (largeHeap.size() - smallHeap.size() > 1){
            smallHeap.add(largeHeap.poll());
            // if largeheap has more
            // then add to smallheap
        }
    }
    
    public double findMedian() {
        if(smallHeap.size() == largeHeap.size()){ // if balanced
            return (double) (largeHeap.peek() + smallHeap.peek()) / 2;
        } else if (smallHeap.size() > largeHeap.size()){ // if smallheap
        // is bigger, then smallheap will have 1 element which will be the median
            return (double) smallHeap.peek();
        } else {
            return (double) largeHeap.peek();
            // largeheap will have 1 element which will be the median
        }
    }
}
