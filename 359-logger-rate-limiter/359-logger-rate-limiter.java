class Logger {
    Map<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        int end = map.getOrDefault(message, timestamp);
        if (end <= timestamp) {
            map.put(message, timestamp + 10);
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