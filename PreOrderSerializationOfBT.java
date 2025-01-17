class Solution {
    public boolean isValidSerialization(String preorder) {
        String[]arr=preorder.split(",");
        int slots=1;//only for root node in the beginning

        for(String node:arr){
            slots--;//used up one slot
            if(slots<0)return false;
            //at any moment if slots become negative that means we dont have slots left but we're trying to insert more nodes so return false there
            if(!node.equals("#")){
                slots+=2;//if the current node is not null then it gives rise to 2 new children so 2 slots opens up
            }
        }
        return slots==0;//lastly if slots become 0 then we have successfully used all slots in the tree
    }
}
