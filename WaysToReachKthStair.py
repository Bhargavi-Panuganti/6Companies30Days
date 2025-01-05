class Solution:
    def waysToReachStair(self, k: int, ans = 0) -> int:

        if k < 3: return 2 + 2 * (k > 0)

        for jump in range(min(k, 30)):

            n = (1 << jump)-k
            if n < 0:  continue
            
            ans+= comb(jump + 1, n)

        return ans  
