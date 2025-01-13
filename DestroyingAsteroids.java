class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long planet_mass=mass;

        for(int i=0;i<asteroids.length;i++)
        {
            if(planet_mass>=asteroids[i])
            {
                planet_mass+=asteroids[i];
               
            }else{
                return false;
            }
        }
        return true;
    }
}
