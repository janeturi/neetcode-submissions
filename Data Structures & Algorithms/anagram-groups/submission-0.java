class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       // plan: sort characters of each string to form a key
       // then add to the different sub-links 

       Map<String, List<String>> ordered = new HashMap<>(); // needs to be
       // a map to allow duplicates

       for (String s : strs) { // iterate over everything 
        char[] charArray = s.toCharArray(); // converts string into characters, then puts that into an array of characters
        Arrays.sort(charArray); // sorts them
        String sortedS = new String(charArray); // making a new string with 
        // them all sorted 
        ordered.putIfAbsent(sortedS, new ArrayList<>()); // if the key doesn't exist yet, put an empty string in place of it for now
        ordered.get(sortedS).add(s); // gets from the sorted, then adds those from
        // the corresponding key
       }        
       return new ArrayList<>(ordered.values());
    }

    }