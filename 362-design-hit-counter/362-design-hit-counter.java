class HitCounter {
    //record the most recent record 300 timestamp,最近300个timestamp
    //rolling array
    int[] time;
    //the most recent 300 hit responding to time[]
    int[] hit;
    public HitCounter() {
        time = new int[300];
        hit = new int[300];
    }
    
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (time[index] != timestamp) {
            time[index] = timestamp;
            hit[index] = 1;
        } else {
            hit[index]++;
        }
    }
    
    public int getHits(int timestamp) {
        int res = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - time[i] < 300) {
                res += hit[i];
            }
        }
        return res;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */