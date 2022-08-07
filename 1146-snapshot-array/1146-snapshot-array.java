class SnapshotArray {
/*
The idea is, the whole array can be large,
and we may take the snap tons of times.
(Like you may always ctrl + S twice)

Instead of record the history of the whole array,
we will record the history of each cell.
And this is the minimum space that we need to record all information.

For each A[i], we will record its history.
With a snap_id and a its value.

When we want to get the value in history, just binary search the time point.
*/
    TreeMap<Integer, Integer>[] A;
    int snap_id = 0;
    public SnapshotArray(int length) {
        A = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            A[i] = new TreeMap<Integer, Integer>();
            A[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        A[index].put(snap_id, val);
    }
    
    public int snap() {
        return snap_id++;
    }
    
//     For those who are trying to understand why floorEntry() method is used in the get method - There is a possibility that snap() call is made multiple times consecutively, 
// in that case we are not updating the snap_id with any value in the TreeMap but just incrementing the snap_id. So if a get call is made with some input snap_id we need to find the greatest snap_id lower than input snap_id for which an entry was added to the TreeMap.
    public int get(int index, int snap_id) {
        return A[index].floorEntry(snap_id).getValue();
    }
}


/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */