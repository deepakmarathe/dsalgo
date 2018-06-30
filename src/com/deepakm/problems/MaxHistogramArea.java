package com.deepakm.problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaxHistogramArea {

    public int getArea(int input[]) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for (i = 0; i < input.length; ) {
            if (stack.isEmpty() || input[stack.peekFirst()] <= input[i]) {
                stack.offerFirst(i++);
            } else {
                int top = stack.pollFirst();
                if (stack.isEmpty()) {
                    area = input[top] * i;

                } else {
                    area = input[top] * (i - stack.peekFirst() - 1);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pollFirst();
            if (stack.isEmpty()) {
                area = input[top] * i;
            } else {
                area = input[top] * (i - stack.peekFirst() - 1);
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxHistogramArea maxHistogramArea = new MaxHistogramArea();
        int input[] = {2,2,2,6,1,5,4,2,2,2,2};
        int maxArea = maxHistogramArea.getArea(input);
        System.out.println(maxArea);
    }
}
