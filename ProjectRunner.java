// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Hima Bathula (906421933)

/**
 * represents project runner class
 */

package towerofhanoi;

public class ProjectRunner

{

    /**
     * Main method sets number of discs as 6. Puzzle Window is passed to new
     * Hanoi Solver
     */

    public static void main(String[] args)
    {
        int disks = 6;

        if (args.length == 1)
        {
            disks = Integer.parseInt(args[0]);
        }

        new PuzzleWindow(new HanoiSolver(disks));

    }

}
