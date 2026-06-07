class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        /* given a list of flgight tickets tickets where
        tickets[i] = [from_i, to_i] represent the source airport
        and destination airport

        each from_i and to_i consists of three uppercase english letters

        we want to reconstruct iteerary in order and return it
        aka, reconstruct flight path that someone who departed from 'jfk'
        took assuming each tix was used exactly once

        if there are multiple valid flight paths, return the lexicographically
        smallest one

        we use hierholzer's algo, which aims to find the
        path through a cycle having only visited each node once

        other methods like kijistra wouldnt work bc that finds shortest

        we simulate dfs using a stack, keep moving while tickets exist
        and when we have n flights, we backtrack and record the airport
        */

        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        // check for adjacent nodes
        for(List<String> ticket : tickets){
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
            // save to hashmap, each node will contain a key pointing to the next node
            // we'll process the next node that's considered the smallest
        }

        LinkedList<String> res = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK"); // push first boarding place ('jfk')

        while(!stack.isEmpty()){
            String curr = stack.peek(); // outgoing flight
            if(!adj.containsKey(curr) || adj.get(curr).isEmpty()){
                // if no outgoing flights, pop and push destination
                res.addFirst(stack.pop()); // popping gives smallest destination btw
            } else {
                stack.push(adj.get(curr).poll());
                // outgoing flights, add next flight to stack
                // + remove current from queue bc its been processed and path isnt done yet
            }
        }

        return res;
    }
}
