class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, v -> new TreeMap<>()).put(timestamp, value);
    }

    // key doesnt exist resturn "";
    // key exists, process timestamp
    //      -- find the one that is equal or less that we're providing
    //      -- return value (where key == key && ts <= timestmap)
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> entries = map.get(key);
        if (entries == null) return "";
        int result = getFloor(timestamp, entries.keySet());
        return result != -1 ? entries.get(result) : "";
    }

    private int getFloor(int target, Set<Integer> timestamps) {
        List<Integer> ts = new ArrayList<>(timestamps);
        int l = 0;
        int r = ts.size() - 1;
        int res = -1;
        // 1 2 3 4 5 6 7 8
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (ts.get(mid) <= target) {
                res = ts.get(mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
