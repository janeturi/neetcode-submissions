class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // we're finding cheapest price from a source to a destination
        // which is good for dijstrka or bellman ford
        // we cant use kruskal bc kruskal attempts to connect all nodes
        // however we only want to connect some nodes

        // bellman ford and dijstrka work, but dijkstra is algorithmically faster
        // but cannot handle negative weights

        // we use bellman ford because it checks for alllll possible paths
        // instead of doing the greedy algorithm that chooses the shortest

        // so basically we will get the cheapest always

        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE); // for now we have placeholder infinity
        prices[src] = 0; // current start of path

        for(int i = 0; i <= k; i++){
            int[] tmpPrices = Arrays.copyOf(prices, n); // copy prices of reachable paths

            for(int[] flight : flights){ 
                // go thrugh each flight
                int s = flight[0], d = flight[1], p = flight[2];
                // sources, destination, price

                if(prices[s] == Integer.MAX_VALUE) continue; 
                // skip if unreachable

                if(prices[s] + p < tmpPrices[d]){ // if adding this to the current path
                // gives u a low price than how it 
                    tmpPrices[d] = prices[s] + p; // update if yes
                }
            }

            prices = tmpPrices; // change
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
        // if we still have no improvements in price, like if we have some paths we didnt find
        // a cheapest ath for, return -1 aka nada
    }
}
