class Solution {
    public boolean isHappy(int n) {
        int slow=n;
        int fast= getNextNumber(n);
        while(fast!= 1 && slow!=fast){
            slow=getNextNumber(slow);
            fast=getNextNumber(getNextNumber(fast));
        }
        return fast==1;
    }
    private int getNextNumber(int n){
        int totalSum=0;
        while(n>0){
            int digit=n%10;
            totalSum+= digit*digit;
            n/=10;
        }
        return totalSum;
    }
}
