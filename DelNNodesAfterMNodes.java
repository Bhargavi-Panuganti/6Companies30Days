class Solution {
    static void linkdelete(Node head, int n, int m) {
        // your code here
        if(n==0)return;
        int M=0;  //count number of skeep node
        int N=0;  //count number of delete node
        
        Node temp=head;
        Node prev=head;
        
        
        while(temp!=null){
          if(M<m){
              prev=temp;
              temp=temp.next;
              M++;
          }
          else if(N<n){
              temp=temp.next;
              N++;
          }
          else if(m==M && n==N){
              prev.next=temp;
              M=0;
              N=0;
          }
          
        }
        
        //after counting skeep node +delete node temp reached to null then pev point  to null
        
        prev.next=null;
        
    }
}
