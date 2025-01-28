class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        # l=digits[0]
        # my_dict={
        #     "2":["a","b","c"],
        #     "3":["d","e","f"],
        #     "4":["g","h","i"],
        #     "5":["j","k","l"],
        #     "6":["m","n","o"],
        #     "7":["p","q","r","s"],
        #     "8":["t","u","v"],
        #     "9":["w","x","y","z"]
        # }
        # new=[my_dict[l]]
        
        # def now_add(k):
        #     for j in new:
        #         for i in k:
        #             new+=(j+i)
        #     return
        # if not digits:
        #     return []
        # if len(digits)==1:
        #     return my_dict[digits]
        # else:
        #     for i in digits[1:]:
        #         k=my_dict[i]
        #         now_add(k)
        
        #     return new
        if not digits:
            return []
        
        phone = {"2": "abc", "3": "def", "4": "ghi", "5": "jkl", "6": "mno", "7":  "pqrs",  "8": "tuv", "9": "wxyz"}
        res = []
        
        def backtrack(combination, k):
            if not k:
                res.append(combination)
                return
            for letter in phone[k[0]]:
                backtrack(combination + letter,k[1:])
        
        backtrack("", digits)
        return res
