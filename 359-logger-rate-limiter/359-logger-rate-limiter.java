class Logger {
    //<message, the lastest timestamp>
    Map<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        //the lastest timestamp that the message occur
        int time = map.getOrDefault(message, -1);
        if (time == -1 || timestamp - time >= 10) {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */