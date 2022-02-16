class Solution {
    /*
        sort each car by position(descending), this way,the ascending distance to destination. and for
        each car, we wil have the time to arrive at target
        Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
        Car(10, 1) (8, 1)   (5, 7) (3, 3)   (0, 12)   num = 3
        -------------    -------------    -------
    */
    class Car{
        int position;
        double time;
        
        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }
    
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length < 2) {
            return position.length;
        }
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            double time = (double)(target - position[i]) / (double)(speed[i]);
            cars[i] = new Car(position[i], time);
        }
        Arrays.sort(cars, (a, b) -> (b.position - a.position));
        //num of fleet
        int cnt = 1;
        //the index of prev car we are chasing
        int prev = 0;
        for (int i = 1; i < cars.length; i++) {
            if (cars[i].time > cars[prev].time) {
                cnt++;
                prev = i;
            }
        }
        return cnt;
    }
}