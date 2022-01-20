class Solution {
    public int daysBetweenDates(String date1, String date2) {
    int days1 = getDays(date1);
    int days2 = getDays(date2);
    return Math.abs(days1 - days2);
  }
  
  private int getDays(String date){
    String[] parts = date.split("-");
    int year = Integer.valueOf(parts[0]);
    int month = Integer.valueOf(parts[1]);
    int day = Integer.valueOf(parts[2]);
    
    int startYear = 1971, startMonth = 1, startDay = 1;
    int[] mdays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    int res = 0;
    for(int i = startYear; i < year; i++) {
      if(isLeap(i)) {
        res += 366;
      } else {
        res += 365;
      }
    }
    
    for(int i = startMonth; i < month; i++) {
      if(isLeap(year) && i == 2){
        res++;
      }
      res += mdays[i];
    }
    return res + day;
  }
  
  private boolean isLeap(int year) {
    if(year % 400 == 0) {
      return true;
    }
    if(year % 100 == 0) {
      return false;
    }
    if(year % 4 == 0) {
      return true;
    }
    return false;
  }
}