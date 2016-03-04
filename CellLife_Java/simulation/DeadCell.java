package simulation;

import core.Cell;

/**
 * A DeadCell is a cell that is dead. A DeadCell does not have stamina.
 */
public class DeadCell extends Cell
{
	public DeadCell() {
		
	}
	
	@Override
	public Cell getNextStage(int numNormalNeighbours, int numMutatedNeighbours)
	{
		if (numNormalNeighbours == 3) {
			return new NormalCell();
		}
		else if (numMutatedNeighbours == 2) {
			return new MutatedCell();
		}
		else {
			return this;
		}
	}
}
