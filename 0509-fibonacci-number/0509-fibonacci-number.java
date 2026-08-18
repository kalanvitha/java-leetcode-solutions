class Solution {
    int [] mem=new int[31];
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(mem[n]!=0) return mem[n];
        mem[n]=fib(n-1)+fib(n-2);
        return mem[n];
    }
}