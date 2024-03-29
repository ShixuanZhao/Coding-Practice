class MyCalendar {
    //<start, end>
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        //prev start time and next start time
        Integer prev = map.floorKey(start);
        Integer next = map.ceilingKey(start);
        //map.get(prev) 前一个会议的结束时间，next 后一个会议的开始时间
        if ((prev == null || map.get(prev) <= start) && (next == null || end <= next)) {
            map.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */