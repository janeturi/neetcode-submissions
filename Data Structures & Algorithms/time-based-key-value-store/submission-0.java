class TimeMap {
// implement a key-value thing that supports:
// storing multiple vals for the same key @ specified time stamps
// retrieving key's value at a specified time stamp

// idea is that to answer a get q about this, we only
// need to find the latest timestamp that is less than the given
// timestamp, which is easier when u use a binary search
    private Map<String, List<Pair<Integer, String>>> keyStore;
    // takes string 
    // then stores a list of a pair of ints & strings
    // (timestamp, value) 
    public TimeMap() {
        keyStore = new HashMap<>();
        // initialize hashmap
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    // stores a key value into the map
    // so if there's no key value already in the map, create 
    // an arraylist as a key
    // now append/add the timestamped value pair to the list
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = keyStore.getOrDefault(key, new ArrayList<>());
        // retrieves list of values
        int left = 0;
        int right = values.size() - 1;
        String result = ""; // if it doesn't exist, return ""

        while (left <= right){
            int middle = left + (right - left) / 2;
            if (values.get(middle).getKey() <= timestamp){
                // if mid is less than time, check right
                // if equal, change result
                // we're finding the LATEST answer, so we group
                // these together
                result = values.get(middle).getValue();
                left = middle + 1;
            } else {
                // else, the value appeared way before
                // so we check left
                right = middle - 1;
            }
        }
        return result;
    }
        private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
