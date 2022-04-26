class UndergroundSystem {
    static class Event {
        int id;
        String name;
        int time;
        public Event(int id, String name, int time) {
            this.id = id;
            this.name = name;
            this.time = time;
        }
    }
    
    static class Average {
        double totalTime;
        int num; 
        
        public Average() {
            this.totalTime = 0;
            this.num = 0;
        }
        
        public void update(int duration) {
            totalTime += duration;
            num++;
        }
        
        public double getAverage() {
            return totalTime / num;
        }
    }
    Map<Integer, Event> arrival;
    Map<String, Average> average;
    public UndergroundSystem() {
        arrival = new HashMap<>();
        average = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        arrival.put(id, new Event(id, stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Event e = arrival.get(id);
        arrival.remove(id);
        int duration = t - e.time;
        String key = e.name + "+" + stationName;
        average.putIfAbsent(key, new Average());
        average.get(key).update(duration);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "+" + endStation;
        return average.get(key).getAverage();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */