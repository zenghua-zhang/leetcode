package leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        if (rightIndex <= 0) {
            return 0;
        }
        while (leftIndex < rightIndex) {
            int area = area(height, leftIndex, rightIndex);
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    private int area(int[] heigth, int leftIndex, int rightIndex) {
        int l = Math.abs(leftIndex - rightIndex);
        int v = Math.min(heigth[leftIndex], heigth[rightIndex]);

        return l * v;
    }

}
