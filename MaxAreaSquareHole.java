class Solution
{
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars)
    {
        int h_max = 1, v_max = 1, h_cur = 1, v_cur = 1;
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int prev = -1;
        for(int i : hBars)
        {
            if(i == prev + 1)
                h_cur++;
            else h_cur = 1;
            h_max = Math.max(h_cur,h_max);
            prev = i;
        }
        prev = -1;
        for(int i : vBars)
        {
            if(i == prev + 1)
                v_cur++;
            else v_cur = 1;
            v_max = Math.max(v_cur,v_max);
            prev = i;
        }
        int min = Math.min(h_max, v_max)+1;
        return min*min;
    }
}
