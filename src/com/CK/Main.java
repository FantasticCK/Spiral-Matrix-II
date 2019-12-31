package com.CK;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    // Right, Down, Left, Up
    private static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] generateMatrix(int n) {
        if (n == 0)
            return new int[0][0];
        int[][] matrix = new int[n][n];
        fillInMatrix(matrix, new int[]{0, 0}, 0, 1);
        return matrix;
    }

    private void fillInMatrix(int[][] matrix, int[] st, int d, int num) {
        if (num > matrix.length * matrix.length)
            return;
        int r = st[0], c = st[1];
        matrix[r][c] = num;
        int nr = r + dir[d][0], nc = c + dir[d][1];
        if (isValid(matrix, nr, nc)){
            fillInMatrix(matrix, new int[]{nr, nc}, d, num + 1);
        } else {
            d = d == 3 ? 0 : d + 1;
            nr = r + dir[d][0];
            nc = c + dir[d][1];
            fillInMatrix(matrix, new int[]{nr, nc}, d, num + 1);
        }
    }

    private boolean isValid(int[][] matrix, int r, int c) {
        int n = matrix.length;
        return r >= 0 && c >= 0 && r < n && c < n && matrix[r][c] == 0;
    }
}