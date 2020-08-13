public class trap {
    public int traps(int[] height) {
        int h = 0;
        int area = 0;
        int i = 0, j = height.length - 1;
        while(i < j){
            if(height[i] < height[j]){
                h = Math.max(h, height[i]);
                area += h - height[i];
                i++;
            }
            else{
                h = Math.max(h, height[j]);
                area += h - height[j];
                j--;
            }
        }
        return area;
    }
}