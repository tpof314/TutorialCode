package core;

import simulation.DeadCell;

/* DO NOT CHANGE THIS CLASS */
public class Cell
{
	/**
	 * Get the next stage of a cell based of the number of neighbours it has
	 * according to the rules provided in the assignment specification sheet
	 * (higher rules happen with more importance than lower rules).
	 * 
	 * For NormalCells, this will also include calculating the new stamina of
	 * the cell.
	 * 
	 * @param numNormalNeighbours
	 *            the number of normal neighbours of the cell
	 * @param numMutatedNeighbours
	 *            the number of mutated neighbours of the cell
	 * @return the cell that this cell is to be replaced with (return "this" to
	 *         stay the same).
	 */
	public Cell getNextStage(int numNormalNeighbours, int numMutatedNeighbours)
	{
		// To keep the cell the same, use "return this;"
		// To change to a new type of cell, use "return new ___Cell();"
		
		return new DeadCell();
	}
}
