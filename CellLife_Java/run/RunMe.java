package run;

import visualiser.CellVisualiser;

/**
 * Run this class to test your code with a visual simulation.
 * 
 * Controls:
 *  - Spacebar: Run 1 step of the simulation
 *  - Enter: Pause/unpause
 *  - N: Start a new simulation
 *  - O: Show the options
 *  - Left-click: change the state of the cell you clicked on
 *  - Right-click: kill the cell you clicked on
 *  
 * Note: don't forget to add "info1103_cellife_visualiser.jar" to the project buildpath.
 */
public class RunMe
{
	public static void main(String[] args)
	{
		new CellVisualiser();
	}
}
