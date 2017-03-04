package com.matrix;

import java.util.Scanner;

public class MatrixMultiplication {

	public static void main(String...a){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of rows : ");
		int row = scanner.nextInt();
		System.out.print("Enter the number of columns : ");
		int col = scanner.nextInt();
		System.out.println("Rows you entered = "+row+"\nColumns you entered = "+col);
		int m1[][]=new int[row][col];
		int m2[][]= new int[row][col];
		System.out.println();
		
		createMatrix(scanner, row, col, m1);
		createMatrix(scanner, row, col, m2);
		
		System.out.println();
		System.out.println("Matrix you entered");
		displayMatrix(row, col, m1);
		displayMatrix(row, col, m2);
		
		displayMatrix(m1.length, m2[0].length, multiplyMatrices(m1, m2));
	}

	private static void displayMatrix(int row, int col, int[][] m1) {
		for(int r=0;r<row;r++){
			for(int c=0;c<col;c++){
				System.out.print(m1[r][c]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------");
	}

	private static void createMatrix(Scanner scanner, int row, int col, int[][] m1) {
		System.out.println("Enter the  matrix");
		for(int r=0;r<row;r++){
			System.out.println("Enter row "+(r+1));
			for(int c=0;c<col;c++){
				m1[r][c]=scanner.nextInt();
				System.out.println();
			}
		}
		System.out.println("-----------------------------");
	}
	
	public static int[][] multiplyMatrices(int [][]m1,int [][]m2){
		if(m1[0].length == m2.length){
		int [][] result = new int[m1.length][m2[0].length];
			for(int row=0;row<m1.length;row++){
				result[row]=getRowMultiplicationResults(m1[row], m2);
			}
			return result;
		}
		else{
			System.out.println("Incorrect dimensions");
			return null;
		}
		
	}
	private static int[] getRowMultiplicationResults(int[]m1,int[][]m2){
		int[] res= new int[m1.length];
		for(int r=0;r<m1.length;r++){
			int multiplier= m1[r];
			for(int c=0;c<m2[r].length;c++){
				res[c] = res[c]+ (multiplier*m2[r][c]);
			}
		}
		return res;
	}
}
