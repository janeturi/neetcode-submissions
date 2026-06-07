class LRUCache {
// have thing where u remove least recently used items

    private final Map<Integer, Integer> cache;
    // track of cache used
    private final int capacity; // size capacity

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            // capacity capacity, load factor of 0.75f (resize when hashmap
            //is 0.75% full), maintains access order (makes it so we remove the 
            // least recently used)
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
            return size() > LRUCache.this.capacity;
            } // removes least recently used when put is used. activates when we reach capacity
        };
    }
    
    public int get(int key) {
        return cache.getOrDefault(key, -1);
        // if it exists, returns key. if it doesn't, returns -1
    }
    
    public void put(int key, int value) {
        // update value of key if key exists, otherwise, adds
        // keyvalue pair to the cache
        cache.put(key, value);
    }
}
