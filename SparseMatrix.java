import java.util.*;
import java.util.Map.Entry;

/**
 * A 2-D sparse matrix class.
 * 
 * @author ?
 *
 * CS1121, Fall 2011
 * Lab Section ?
 */
public class SparseMatrix {

	// instance variables (DO NOT CHANGE THE NEXT THREE LINES IN ANY WAY!)
	private final TreeMap<Integer,TreeMap<Integer,Double>> matrix;
	// the primary structure for keeping track of non-zero values
	private final int rows;
	// used to keep track of the number of rows, must be >0
	private final int cols;
	// used to keep track of the number of columns, must be >0

	/**
	 * Construct a new SparseMatrix object with a given number of rows and
	 * columns.
	 * Assume there is at least one row and one column.
	 *
	 * @param r The number of rows.
	 * @param c The number of columns.
	 */

	public SparseMatrix(int r, int c) {

		matrix = new TreeMap<Integer,TreeMap<Integer,Double>>();
		rows= r;
		cols=c;

	} // end of constructor

	/**
	 * Get the number of rows in this sparse matrix.
	 *
	 * @return the number of rows.
	 */
	public int numRows(TreeMap<Integer,TreeMap<Integer,Double>> matrix) {
		return rows;

	} // end of of numRows method

	/**
	 * Get the number of columns in this sparse matrix.
	 *
	 * @return the number of columns.
	 */
	public int numColumns(TreeMap<Integer,TreeMap<Integer,Double>> matrix) {
		return cols;

	} // end of of numColumns method

	/**
	 * Get the value at a given position.
	 *
	 * @param i The row.
	 * @param j The column.
	 *
	 * @return the value at row i and column j, or 0.0 if the position is
	 * 		not in the matrix.
	 */
	public double get(int i, int j) {
		double finder = 0.0;
		finder =matrix.get(i).get(j);
		return finder;

	} // end of get method

	/**
	 * Change the value at a given position.
	 * If the position is not in the matrix (i.e., i is not between 0 and rows-1
	 * and j is not between 0 and cols-1), then don't change anything.
	 *
	 * @param i The row.
	 * @param j The column.
	 * @param v The new value.
	 */
	public void set(int i, int j, double v) {
		if(matrix.get(i).get(j)!=null){
			matrix.get(i).put(j, v);
		}
	} // end of set method

	/**
	 * See if this matrix is the identity matrix (i.e., square, 1's on the 
	 * diagonal, 0's elsewhere.
	 *
	 * @return true if it is the identity matrix, false if not.
	 */
	public boolean isIdentity() {
		boolean test= false;
		int count=0;

		if(rows==cols){

			for(int k: matrix.keySet()){
				for(int m: matrix.get(k).keySet()){
					if(matrix.get(k).get(m)==1){
						if(k==m){
							count++;
						}

					}
				}

			}
			if(count==rows){
				test=true;
			}
		}
		return test;
	} // end of isIdentity method

	/**
	 * See if one matrix equals another.
	 * Two matrices are equal if the are the same size and every element of one
	 * is equal to the corresponding element of the other.
	 *
	 * @param a One matrix.
	 * @param b Another matrix.
	 *
	 * @return true if they are equal, false if not.
	 */
	public static boolean equals(SparseMatrix a, SparseMatrix b) {
		if(a.matrix.keySet().equals(b.matrix.keySet())&&b.matrix.values().equals(a.matrix.values())){
			return true;

		}
		else{
			return false;
		}

	} // end of equals method

	/**
	 * Add two sparse matrices and return the sum.
	 * Two matrices must be the same size or they can't be added.
	 *
	 * @param a One matrix.
	 * @param b Another matrix.
	 *
	 * @return a new sparse matrix that is the sum of a and b, or the null
	 * 		pointer if they are not the same size.
	 */
	public static SparseMatrix add(SparseMatrix a, SparseMatrix b) {
		SparseMatrix smatrix = new SparseMatrix(a.matrix., Interger);
		if(a.matrix.size()==b.matrix.size()){
			for(int k: a.matrix.keySet()){
				for(int m: a.matrix.get(k).keySet()){
					double aPlace=0;
					double bPlace=0;
					double sumPlace=0;

					aPlace=a.matrix.get(k).get(m);
					bPlace =b.matrix.get(k).get(m);
					sumPlace=aPlace+bPlace;
					a.matrix.get(k).put(m, sumPlace);

				}
			}

			return smatrix;
		}

		return null;
	} // end of add method

	/**
	 * Return the toString of the map structure of this sparse matrix.
	 * DO NOT CHANGE THIS METHOD IN ANY WAY.
	 *
	 * @return toString of the map.
	 */
	public String toString() {

		return matrix.toString(); // do not modify, replace or delete this line
	} // end of toString method

	/**
	 * Test driver.
	 *
	 * @param args Unused.
	 */
	public static void main(String [] args) {

		HashMap<String,SparseMatrix> matrix =
			new HashMap<String,SparseMatrix>();

		Scanner input = new Scanner(System.in);
		String cmd = input.next();
		while (!cmd.equals("end")) {
			if (cmd.equals("new")) {
				String name = input.next();
				int rows = input.nextInt();
				int cols = input.nextInt();
				if (rows < 1 || cols < 1) {
					System.out.println("new: rows and/or cols less than 1: ");
					System.exit(1);
				}
				SparseMatrix m = new SparseMatrix(rows,cols);
				int i = input.nextInt();
				while (i >= 0) {
					int j = input.nextInt();
					double v = input.nextDouble();
					m.set(i,j,v);
					i = input.nextInt();
				}
				matrix.put(name,m);
				System.out.printf("new %s = %s\n", name, m);
			}
			else if (cmd.equals("get")) {
				String which = input.next();
				if (!matrix.containsKey(which)) {
					System.out.println("numRows: no such matrix: " + which);
					System.exit(1);
				}
				int i = input.nextInt();
				int j = input.nextInt();
				System.out.printf("%s.get(%d,%d) = %f\n",
						which, i, j, matrix.get(which).get(i,j));
			}
			else if (cmd.equals("set")) {
				String which = input.next();
				if (!matrix.containsKey(which)) {
					System.out.println("numRows: no such matrix: " + which);
					System.exit(1);
				}
				int i = input.nextInt();
				int j = input.nextInt();
				double v = input.nextDouble();
				matrix.get(which).set(i,j,v);
				System.out.printf("%s.set(%d,%d,%f) = %s\n",
						which, i, j, v, matrix.get(which));
			}
			else if (cmd.equals("numRows")) {
				String which = input.next();
				if (!matrix.containsKey(which)) {
					System.out.println("numRows: no such matrix: " + which);
					System.exit(1);
				}
				System.out.printf("%s.numRows() = %d\n",
						which, matrix.get(which).numRows());
			}
			else if (cmd.equals("numColumns")) {
				String which = input.next();
				if (!matrix.containsKey(which)) {
					System.out.println("numColumns: no such matrix: " + which);
					System.exit(1);
				}
				System.out.printf("%s.numColumns() = %d\n",
						which, matrix.get(which).numColumns());
			}
			else if (cmd.equals("isIdentity")) {
				String which = input.next();
				if (!matrix.containsKey(which)) {
					System.out.println("isIdentity: no such matrix: " + which);
					System.exit(1);
				}
				System.out.printf("%s.isIdentity() = %b\n",
						which, matrix.get(which).isIdentity());
			}
			else if (cmd.equals("equals")) {
				String a = input.next();
				if (!matrix.containsKey(a)) {
					System.out.println("equals: no such matrix: " + a);
					System.exit(1);
				}
				String b = input.next();
				if (!matrix.containsKey(b)) {
					System.out.println("equals: no such matrix: " + b);
					System.exit(1);
				}
				System.out.printf("%s.equals(%s) = %b\n", a, b,
						SparseMatrix.equals(matrix.get(a),matrix.get(b)));
			}
			else if (cmd.equals("add")) {
				String a = input.next();
				String b = input.next();
				if (!matrix.containsKey(b)) {
					System.out.println("add: no such matrix: " + b);
					System.exit(1);
				}
				String c = input.next();
				if (!matrix.containsKey(c)) {
					System.out.println("add: no such matrix: " + c);
					System.exit(1);
				}
				matrix.put(a,SparseMatrix.add(matrix.get(b),matrix.get(c)));
				System.out.printf("new %s = SparseMatrix.add(%s,%s) = %s\n",
						a, b, c, matrix.get(a));
			}
			else {
				System.out.println("invalid command: " + cmd);
				System.exit(1);
			}
			cmd = input.next();
		}

	} // end of main method

} // end of SparseMatrix class
