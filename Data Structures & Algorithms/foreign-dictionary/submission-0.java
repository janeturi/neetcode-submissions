class Solution {
    public String foreignDictionary(String[] words) {
      /* foreign language using latin alphabet
      but order of letters isnt abc...z like eng

        you will recieve a list of non-empty strings 'words'
        where words are sorted alphabeticaly based on the rules
        of the new language

        derive order of letters in this language

        we can use kahn's algorithm to check indegrees and prereqs(!!)
        we cannot use a tree like bst and stuff because those don't 
        allow us to have multiple parents/prereqs
      */

      Map<Character, Set<Character>> adj = new HashMap<>(); //dictionary
      Map<Character, Integer> indegree = new HashMap<>();

      for(String word : words){ // map letter to number of prereqs
        for(char c : word.toCharArray()){
            adj.putIfAbsent(c, new HashSet<>());
            indegree.putIfAbsent(c, 0);
        }
      }

      for(int i = 0; i < words.length - 1; i++){
        String w1 = words[i];
        String w2 = words[i + 1];
        int minLen = Math.min(w1.length(), w2.length()); // we want to check
        // to make sure that every string is actually lexicographically smaller than the other
        // string, so
        if(w1.length() > w2.length() &&  // first letter where they differ is considered
        // smaller in a than b
        // amd a is a prefix of b and a.length < b.length
        w1.substring(0, minLen).equals(w2.substring(0, minLen))){
            return "";
        }

        for(int j = 0; j < minLen; j++){
            if(w1.charAt(j) != w2.charAt(j)){ // when not similar
                if(!adj.get(w1.charAt(j)).contains(w2.charAt(j))){
                    //get point where they differ 
                    adj.get(w1.charAt(j)).add(w2.charAt(j)); // add edge'
                    // this basically means that now everything in the second word
                    // is considered more than everyhting in the first word
                    // so the prereqs requireed for it go up
                    // +  we add it to our dictionary
                    
                    indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
                }
                break;
            } 
           
        }
      }

      Queue<Character> q = new LinkedList<>();
      for(char c : indegree.keySet()){ // now we do the kahn's algo part
      // everything with indegree = 0 meaning no prereqs aka our beginning letter
        if(indegree.get(c) == 0) q.offer(c);
      }

      StringBuilder res = new StringBuilder();
      while(!q.isEmpty()){
        char cur = q.poll();
        res.append(cur); // append the current letter
        for(char neigh : adj.get(cur)){ // go through dictionary
            indegree.put(neigh, indegree.get(neigh) - 1);
            // erase as prereq from others
            if(indegree.get(neigh) == 0) q.offer(neigh);
            // offer the new ones with no prereqs
        }
      }

      if(res.length() != indegree.size()) return "";
        // if we have random letters tha tdont fit in our dictionary
      return res.toString();
      // return result

    }
}
