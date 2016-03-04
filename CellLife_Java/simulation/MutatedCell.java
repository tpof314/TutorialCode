package simulation;

import core.Cell;

/**
 * A MutatedCell is a special type of cell that is alive, but has mutated to
 * live by different rules. A MutatedCell does not have stamina.
 */
public class MutatedCell extends Cell
{
	public MutatedCell() {
		
	}
	
	@Override
	public Cell getNextStage(int numNormalNeighbours, int numMutatedNeighbours)
	{
		if (numNormalNeighbours >= 2) {
			return new NormalCell();
		}
		else if (numMutatedNeighbours >= 2 && numMutatedNeighbours <= 4) {
			return this;
		}
		else {
			return new DeadCell();
		}
	}
}
