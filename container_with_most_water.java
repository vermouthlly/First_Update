/**
 * container_with_most_water
 */
public class container_with_most_water {

    public static int maxArea(int[] height) {
        int front = 0, max = 0;
        int end = height.length - 1;
        while(front != end) {
            if(height[front] <= height[end]) {
                if((end - front) * height[front] > max) {
                    max = (end - front) * height[front];
                }
                front++;
            }else {
                if((end - front) * height[end] > max) {
                    max = (end - front) * height[end];
                }
                end--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }
}