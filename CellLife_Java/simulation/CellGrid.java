package simulation;

import core.Cell;


public class CellGrid
{
    // Store the cells of the game in this 2D array
    private Cell[][] cells;
    private Cell[][] tempCells;
    private double mutationChance;
    
    /**
     * Contructor for a CellGrid. Populates the grid with cells that will be
     * living and normal (with probability given by lifeChance) or dead. Cells
     * will NOT start mutated.
     * 
     * @param size
     *            the size of the grid will be size x size
     * @param lifeChance
     *            the probability of each cell starting out alive
     * @param mutationChance
     *            the probability that (when required) each cell will mutate
     */
    public CellGrid(int size, double lifeChance, double mutationChance)
    {
        this.cells = new Cell[size][size];
        this.tempCells = new Cell[size][size];
        this.mutationChance = mutationChance;
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                this.cells[i][j] = getRandomCell(lifeChance);
            }
        }
    }

    private Cell getRandomCell(double lifeChance) {
        double num = Math.random();
        if (num <= lifeChance) {
            return new NormalCell();
        }
        else {
            return new DeadCell();
        }
    }
    
    /**
     * Run one step in the simulation. This has 2 stages in the following order:
     * 
     * 1. Update all cells in the grid according to the rules given in the
     * assignment specification sheet (higher rules happen with more importance
     * than lower rules).
     * 
     * 2. Attempt to mutate every living cell.
     */
    public void simulateStep()
    {
        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells.length; j++) {
                int N = countNormalNeighbours(j, i);
                int M = countMutatedNeighbours(j, i);
                tempCells[i][j] = cells[i][j].getNextStage(N, M);
            }
        }
        copyCells();
    }
    
    private void copyCells() {
        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells.length; j++) {
                this.cells[i][j] = this.tempCells[i][j];
                mutateCell(j, i);
            }
        }
    }
    
    /**
     * Mutate the cell at the given coordinates. The mutation will be successful
     * with probability as given in the constructor, and only if the cell is
     * alive (i.e. not dead).
     * 
     * NOTE: This method can actually result in a cell changing from NormalCell to
     * MutatedCell; not only returning the result.
     * 
     * @param x
     *            the x coordinate (column) of the cell
     * @param y
     *            the y coordinate (row) of the cell
     * @return true if the mutation was successfully performed, false otherwise
     *         (including if the coordinates are invalid)
     */
    public boolean mutateCell(int x, int y)
    {
        if (isNormalCell(x, y)) {
            double num = Math.random();
            if (num <= this.mutationChance) {
                cells[y][x] = new MutatedCell();
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    /**
     * Check if the given coordinates are inside the grid of cells.
     * 
     * @param x
     *            the x coordinate (column) of the cell
     * @param y
     *            the y coordinate (row) of the cell
     * @return true if the given coordinates are inside the grid of cells, false
     *         otherwise.
     */
    public boolean isValidCoordinate(int x, int y)
    {
        if (x < 0 || x >= cells.length) {
            return false;
        }
        else if (y < 0 || y >= cells.length) {
            return false;
        }
        else {
            return true;
        }
    }
    
    /**
     * Count the number of normal neighbours in the 8 cells surrounding the
     * given coordinates.
     * 
     * @param x
     *            the x coordinate (column) of the cell
     * @param y
     *            the y coordinate (row) of the cell
     * @return the number of normal neighbours of the cell at the given
     *         coordinates or 0 if the coordinates are invalid.
     */
    public int countNormalNeighbours(int x, int y)
    {
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        int count = 0;
        
        for (int i=0; i<dx.length; i++) {
            if (isNormalCell(x + dx[i], y + dy[i])) {
                count++;
            }
        }
        
        return count;
    }

    /**
     * Count the number of mutated neighbours in the 8 cells surrounding the
     * given coordinates.
     * 
     * @param x
     *            the x coordinate (column) of the cell
     * @param y
     *            the y coordinate (row) of the cell
     * @return the number of mutated neighbours of the cell at the given
     *         coordinates or 0 if the coordinates are invalid.
     */
    public int countMutatedNeighbours(int x, int y)
    {
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        int count = 0;
        
        for (int i=0; i<dx.length; i++) {
            if (isMutatedCell(x + dx[i], y + dy[i])) {
                count++;
            }
        }
        
        return count;
    }
    
    /**
     * Get the cell at the given coordinates.
     * 
     * @param x
     *            the x coordinate (column) of the cell
     * @param y
     *            the y coordinate (row) of the cell
     * @return the cell at the given coordinates or null if the coordinates are
     *         invalid
     */
    public Cell getCell(int x, int y)
    {
        if (!isValidCoordinate(x, y)) {
            return null;
        }
        else {
            return this.cells[y][x];
        }
    }

    /**
     * Set the cell at the given coordinates to the cell provided, if the
     * coordinates are valid.
     * 
     * @param x
     *            the x coordinate (column) of the cell
     * @param y
     *            the y coordinate (row) of the cell
     * @param cell
     *            the new cell to put at the coordinates given.
     */
    public void setCell(int x, int y, Cell cell)
    {
        if (isValidCoordinate(x, y)) {
            this.cells[y][x] = cell;
        }
    }

    /**
     * Checks if an outbreak of mutated cells has occurred. An outbreak has
     * occurred if the number of living mutated cells is AT LEAST 10% of the
     * total number of living cells.
     * 
     * Note: "living" cells include both NormalCells and MutatedCells.
     * 
     * @return true if at least 10% of currently living cells are mutated, false
     *         otherwise.
     */
    public boolean isOutbreakOccurring() 
    {
        int mutated = 0;
        int total   = 0;
        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells.length; j++) {
                if (isNormalCell(j, i)) {
                    total++;
                }
                else if (isMutatedCell(j, i)) {
                    mutated++;
                    total++;
                }
            }
        }
        double percent = (double)mutated / total;
        return (percent >= 0.1);
    }
    
    /**
     * Check if the cell at the given coordinates is alive and non-mutated.
     * 
     * @param x
     *            the x coordinate (column) of the cell
     * @param y
     *            the y coordinate (row) of the cell
     * @return true if the cell at the given coordinates is alive and
     *         non-mutated, false otherwise.
     */
    public boolean isNormalCell(int x, int y)
    {
        // There is no need to change this method
        return (getCell(x, y) instanceof NormalCell);
    }

    /**
     * Check if the cell at the given coordinates is alive and mutated.
     * 
     * @param x
     *            the x coordinate (column) of the cell
     * @param y
     *            the y coordinate (row) of the cell
     * @return true if the cell at the given coordinates is alive and mutated,
     *         false otherwise.
     */
    public boolean isMutatedCell(int x, int y)
    {
        // There is no need to change this method
        return (getCell(x, y) instanceof MutatedCell);
    }
}