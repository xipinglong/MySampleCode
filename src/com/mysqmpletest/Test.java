package com.mysqmpletest;

public class Test {

	public static void main(String[] args) {

		String[][] twoDim = {{"11", "21", "31", "41", "51"}, {"12", "22", "32", "42", "52"}, 
				             {"13", "23", "33", "43", "53"}, {"14", "24", "34", "44", "54"}, 
				             {"15", "25", "35", "45", "55"}};
		   
//		String[][] twoDim = readInputs(args);

		int n = (twoDim.length);
		int m = (twoDim[0].length);

		//print out original input n x m matrix
		for(int i = 0; i < n; i++){ 
			for(int j = 0; j <m; j++) { 
				System.out.print(" " + twoDim[i][j] + " ");
			}
			System.out.println();
		}

		spiralPrint(n, m, twoDim);


	}

	/**
	 * read in two dimensional array from command line data entries
	 * @param args
	 * @return
	 */
	private static String[][] readInputs(String[] args) {
		String[] tokens = args;

		// there is no error checking for quickness
		int row = Integer.parseInt(tokens[0]);
		int col = Integer.parseInt(tokens[1]);

		String[][] twoDim = new String[row][col];

		int i = 2;
		for(int r = 0; r<row; r++) {
			for(int c=0; c<col; c++) {
				twoDim[r][c] = tokens[i++];
			}
		}
		return twoDim;
	}

	/**
	 * spiralPrint: print a two dimensional array in outer too inner spiral order
	 * @param n  number of columns
	 * @param m  number of number of rows
	 * @param a -two dimensional array
	 */
	private static void spiralPrint(int n, int m, String a[][]) {
		int i, k = 0, l = 0;

		/*      k - starting row index
		        m - ending row index
		        l - starting column index
		        n - ending column index
		        i - iterator
	   */

		while (k < m && l < n) {
			/* Print the first row from the remaining rows */
			for (i = l; i < n; ++i) {
				System.out.println(a[k][i]);
			}
			k++;

			/* Print the last column from the remaining columns */
			for (i = k; i < m; ++i) {
				System.out.println(a[i][n-1]);
			}
			n--;

			/* Print the last row from the remaining rows */
			if ( k < m) {
				for (i = n-1; i >= l; --i) {
					System.out.println(a[m-1][i]);
				}
				m--;
			}

			/* Print the first column from the remaining columns */
			if (l < n) {
				for (i = m-1; i >= k; --i) {
					System.out.println(a[i][l]);
				}
				l++;    
			}        
		}
	}
}
