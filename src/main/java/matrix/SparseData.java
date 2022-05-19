package matrix;

public class SparseData {
	
	private int row;
	private int col;
	private double val;
	
	public SparseData(int row, int col, double val) {
		this.setRow(row);
		this.setCol(col);
		this.setVal(val);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public double getVal() {
		return val;
	}

	public void setVal(double val) {
		this.val = val;
	}
}
