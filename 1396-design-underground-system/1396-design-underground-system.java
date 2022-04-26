class UndergroundSystem {
    //<id, event>
    private Map<Integer, Event> arrivals;
    //<"start + end", Average>
    private Map<String, Average> averages;
    
    public UndergroundSystem() {
        arrivals = new HashMap<>();
        averages = new HashMap<>();
    }
    
    //checkIn->arrival
    public void checkIn(int id, String stationName, int t) {
        arrivals.put(id, new Event(id, stationName, t));
    }
    
    //update average
    public void checkOut(int id, String stationName, int t) {
        Event arrivalEvent = arrivals.get(id);
        //arrivals.remove(id);
        int diff = t - arrivalEvent.time;
        String key = arrivalEvent.stationName + "," + stationName;
        Average average = averages.getOrDefault(key, new Average());
        average.updateAverage(diff);
        averages.put(key, average);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "," + endStation;
        return averages.get(key).getAverage();
    }
    
    class Event {
        public int id;
        public String stationName;
        public int time;
        
        public Event(int id, String stationName, int time) {
            this.id = id;
            this.stationName = stationName;
            this.time = time;
        }
    }
    
    class Average {
        //total time 
        public double total = 0;
        //the number of passengers
        public int cnt = 0;
        
        public void updateAverage(int diff) {
            cnt++;
            total += diff;
        }
        
        public double getAverage() {
            return total / cnt;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */