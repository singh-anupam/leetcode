class Solution {
    static final int MOD = (int)1e9 + 7;

    public long nCr(int n, int r, long fact[], long invFact[]){
        return fact[n]* invFact[n-r] % MOD * invFact[r] % MOD;
    }
    
    public int countGoodArrays(int n, int m, int k) {
        long fact[] = new long[n+1];
        long invFact[] = new long[n+1];
        fact[0]=1;
        for(int i=1;i<=n;i++){
            fact[i]=(fact[i-1]*i)% MOD;
        }
        
        for(int i=0;i<=n;i++){
            invFact[i]=power(fact[i],MOD-2);
        }

        long result = nCr(n-1,k,fact,invFact);
        result = result*m % MOD;
        result = result * power(m-1,n-k-1) % MOD;
        return (int) result;
        
    }

    private long power(long a, long b){
        // if(b==0)
        // return 1;
        // long half = power(a,b/2);
        // long result = half*half % MOD;
        // if(b%2==1)
        // return a*result % MOD;
        // return result;
          long result = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1)
                result = (result * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return result;
    }
}