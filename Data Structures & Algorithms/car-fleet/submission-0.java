class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // n cars traveling to same destination
        // i is the car
        // position[i] is position of ith car 
        // speed[i] is the speed of the ith car
        // destination is at position target miles
        // cars cannot pass another, can only drive the same speed
        // car fleet is non-empty set set of cars driving @
        // the same position + same speed, 
        // return the # of diff car fleets that will arrive
        // @ the destination

        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++){
            // 
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
            // put into two columns, 
            // first col = position
            // 2nd col = speed, this is just to sort through
            // the cars easier
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        // compares positions and sorts it descending (b -> a)
        // descending bc closest cars will be processed first and
        // will be part of the fleet
        Stack<Double> stack = new Stack<>();
        // initialize a stack that will hold the times of the stack
        for(int[] p : pair){
            stack.push((double) (target - p[0]) / p[1]);
            // pushes times, distance/speed
            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)){
                stack.pop();
                // if new cars time is less than or equal to the time before it, 
                // then pop from stack
                // size >= 2 because 2 is needed to have a fleet
                // also get what is currently below the current first car in the fleet (indices!!, first is n - 1!)
                // also <= bc if its greater then it's faster
            }
        }
        return stack.size();
        
    }
}
