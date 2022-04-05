class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            if (mark[h * 60 + m]) return 0;
            mark[h * 60 + m] = true;
        }
        Integer first = null;
        Integer prev = null;
        Integer res = Integer.MAX_VALUE;
        for (int i = 0; i < 1440; i++) {
            if (mark[i]) {
                if (first == null) {
                    first = i;
                    prev = i;
                } else {
                    //1440是一周， 两条线形成一个锐角一个钝角,一个顺时针一个逆时针
                    res = Math.min(res, Math.min(i - prev, 1440 - i + prev));
                    prev = i;
                }
            }
        }
        //corner case the first one and last one
        res = Math.min(res, Math.min(prev - first, 1440 - prev + first));
        return res;
    }
}