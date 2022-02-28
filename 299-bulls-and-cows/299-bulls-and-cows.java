class Solution {
    public String getHint(String secret, String guess) {
        //table records the appearance of a digit
        //digit from secret will increase the counter
        //digit from guess will decrease the counter
        int[] count = new int[10];

        int counterA = 0, counterB = 0;

        for(int i = 0; i < secret.length(); i++){
            int a = secret.charAt(i) - '0', b = guess.charAt(i) - '0';
            if( a == b){
                //accurate match (same digit with same position)
                counterA ++;
            }else{

                //if prev part of guess has curr digit in secret
                //then we found a pair that has same digit with different position
                //guess里面有a，因为guess是减少counter的
                if(count[a] < 0) counterB ++;

                //if prev part of secret has curr digit in guess
                //then we found a pair that has same digit with different position
                //我猜b，答案里面也有b，因为secret是增加counter的
                if(count[b] > 0) counterB ++;

                count[a] ++;
                count[b] --;
            }
        }

        return counterA + "A" + counterB + "B";
    }
}