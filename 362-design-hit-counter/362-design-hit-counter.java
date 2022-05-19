class HitCounter {
    //record the timestamp
    int[] time;
    int[] cnt;
    public HitCounter() {
        time = new int[300];
        cnt = new int[300];
    }
    
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (timestamp != time[index]) {
            time[index] = timestamp;
            cnt[index] = 1;
        } else {
            cnt[index]++;
        }
    }
    
    public int getHits(int timestamp) {
        int res = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - time[i] < 300) {
                res += cnt[i];
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