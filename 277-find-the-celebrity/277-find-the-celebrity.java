/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        //brute force
//         鸣人的定义
//         1、所有其他人都认识名人。

//         2、名人不认识任何其他人。  只要观察任意两个候选人的关系，我一定能确定其中的一个人不是名人，把他排除。
        //我们可以不断从候选人中选两个出来，然后排除掉一个，直到最后只剩下一个候选人，这时候再使用一个 for 循环判断这个候选人是否是货真价实的「名人」。
        // for (int candidate = 0; candidate < n; candidate++) {
        //     int other = 0;
        //     for (; other < n; other++) {
        //         if (candidate == other) {
        //             continue;
        //         }
        //         if (knows(candidate, other) || !knows(other, candidate)) {
        //             break;
        //         }
        //     }
        //     if (other == n) {
        //         return candidate;
        //     }
        // }
        // return -1;
        
        //优化的解法 o（n）类似摩尔投票法，从2个人中可以排除一个人不是名人
        // 先假设 cand 是名人
    int cand = 0;
    for (int other = 1; other < n; other++) {
        if (!knows(other, cand) || knows(cand, other)) {
            // cand 不可能是名人，排除
            // 假设 other 是名人
            cand = other;
        } else {
            // other 不可能是名人，排除
            // 什么都不用做，继续假设 cand 是名人
        }
    }

    // 现在的 cand 是排除的最后结果，但不能保证一定是名人
    for (int other = 0; other < n; other++) {
        if (cand == other) continue;
        // 需要保证其他人都认识 cand，且 cand 不认识任何其他人
        if (!knows(other, cand) || knows(cand, other)) {
            return -1;
        }
    }

    return cand;
    }
}