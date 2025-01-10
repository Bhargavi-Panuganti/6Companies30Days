class Solution:
    def firstUniqChar(self, s: str) -> int:
        index=-1
        for i in s:
            if s.count(i)==1:
                index=s.index(i)
                break
        return index
        
