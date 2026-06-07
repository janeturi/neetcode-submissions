class Solution {
    public int longestConsecutive(int[] nums) {
        // probably same method as longest common prefix
        // but with numbers?
        /*
        new intuition: 
        when you place a new number into the map, it might
        connect two existing sequences or extend one
        so idea is to look at the lengths stored @ neighbors:
        mp[num - 1] gives length of sequence ending b4 num (prefix)
        mp[num + 1] gives lenght of seq starting after num (postfix)
        add together + current num and now u have length of merged seq
        */
        Map<Integer, Integer> mp = new HashMap<>(); // sq length for prefix & postfixes
        int res = 0; // longest seq
        for(int i : nums){ // going through 
            if (!mp.containsKey(i)){ // if neither the post or pre has the current num
                mp.put(i, mp.getOrDefault(i - 1, 0) + mp.getOrDefault(i + 1, 0) + 1);
                // ret num, and value is set as num - 1, if it doesnt exist ret 0 + ret the one after, or if it doesn't exist
                // return 0 but + 1 to account for the current num
                mp.put(i - mp.getOrDefault(i - 1, 0), mp.get(i)); 
                // left boundary, current - the one before it, value is i
                mp.put(i + mp.getOrDefault(i + 1, 0), mp.get(i));
                // right boundary, current + the one after, value is i
                res = Math.max(res, mp.get(i)); // gets max length- either no longest sequence or u get i + values

            }
        }
    return res;
    }
}
