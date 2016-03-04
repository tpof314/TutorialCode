package simulation;

import core.Cell;

/**
 * A NormalCell is a special type of cell that is healthy. A NormalCell must keep
 * track of the amount of stamina it has. All NormalCells will start life with
 * 100% stamina. If the stamina gets to 1% or lower, the cell will die.
 */
public class NormalCell extends Cell
{	
	private double stamina;
	
	public NormalCell() {
		this.stamina = 1.0;
	}

	/**
	 * Get the amount of stamina left in this NormalCell expressed as a percentage.
	 * 
	 * 0.0 represents 0% and 1.0 represents 100%.
	 * 
	 * @return the percent of stamina left in this cell
	 */
	public double getPercentStamina() {
		return this.stamina;
	}
	
	@Override
	public Cell getNextStage(int numNormalNeighbours, int numMutatedNeighbours)
	{
		int M = numMutatedNeighbours;
		int N = numNormalNeighbours;
		this.stamina = this.stamina * 3 * N / (8 + 2 * M);
		
		if (this.stamina <= 0.01) {
			return new DeadCell();
		}
		
		if (numNormalNeighbours <= 1) {
			return new DeadCell();
		}
		else if (numNormalNeighbours == 2 || numNormalNeighbours == 3) {
			return this;
		}
		else {
			return new DeadCell();
		}
	}
}
