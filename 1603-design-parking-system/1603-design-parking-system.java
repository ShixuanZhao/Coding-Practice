class ParkingSystem {
    //cnt[0]:number of big [1]:number of medium [2]:number of small
    int[] cnt;
    public ParkingSystem(int big, int medium, int small) {
          cnt = new int[] {big, medium, small};
    }
    
    public boolean addCar(int carType) {
        return cnt[carType - 1]-- > 0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */