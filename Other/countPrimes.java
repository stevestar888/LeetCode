//Tis the ancience Sieve of Eratosthenes
//An elegant alogrithm that runs in O(N log (log N))
//from over two thousand years ago.

class Solution {
    public int countPrimes(int n) {
       boolean[] isPrime = new boolean[n];
        
       for (int i = 2; i < n; i++) {
          isPrime[i] = true;
       }

       for (int i = 2; i * i < n; i++) {
          if (isPrime[i]) {
              for (int j = i * i; j < n; j += i) {
                 isPrime[j] = false;
              }
          }
       }
        
       int count = 0;
       for (int i = 2; i < n; i++) {
          if (isPrime[i]) count++;
       }
        
       return count;
    }
}
