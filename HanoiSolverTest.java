// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Hima Bathula (906421933)

package towerofhanoi;

import student.TestCase;

/**
 * // -------------------------------------------------------------------------
 * /** Represents the HanoiSolver class
 * 
 * @author himabathula
 * @version Jul 28, 2024
 */

public class HanoiSolverTest
    extends TestCase
{

    /**
     * creates objects for HanoiSolver and three different towers
     */

    private HanoiSolver solver;
    private Tower left;
    private Tower middle;
    private Tower right;

    /**
     * sets up solver, towers, and pushes three different discs with three
     * different widths
     */

    @Override
    public void setUp()
    {
        solver = new HanoiSolver(3);
        left = solver.getTower(Position.LEFT);
        middle = solver.getTower(Position.MIDDLE);
        right = solver.getTower(Position.RIGHT);
        left.push(new Disk(3));
        left.push(new Disk(2));
        left.push(new Disk(1));

    }


    /**
     * tests the number of disks
     */

    public void testDisks()
    {
        assertEquals(3, solver.disks());

    }


    /**
     * tests the getTower method
     */

    public void testGetTower()
    {

        assertEquals(left, solver.getTower(Position.LEFT));
        assertEquals(middle, solver.getTower(Position.MIDDLE));
        assertEquals(right, solver.getTower(Position.RIGHT));
        assertEquals(middle, solver.getTower(Position.DEFAULT));

    }


    /**
     * tests the concatenation ability of the tower positions as toString()
     */

    public void testToString()
    {
        String leftString = left.toString();
        String middleString = middle.toString();
        String rightString = right.toString();

        String expString = leftString + middleString + rightString;

        assertEquals(expString, solver.toString());

    }


    /**
     * tests the move method
     */

    public void testMove()
    {
        assertEquals(3, left.size());
        assertEquals(0, right.size());

        solver.move(left, right);

        assertEquals(2, left.size());
        assertEquals(1, right.size());

    }


    /**
     * tests the solveTowers method
     */

    public void testSolveTowers()
    {
        assertEquals(3, left.size());
        assertEquals(0, middle.size());
        assertEquals(0, right.size());

        solver.solveTowers(3, left, middle, right);

        assertEquals(0, left.size());
        assertEquals(0, middle.size());
        assertEquals(3, right.size());

    }


    /**
     * tests the solver() method
     */

    public void testSolve()
    {

        assertEquals(3, left.size());
        assertEquals(0, middle.size());
        assertEquals(0, right.size());

        solver.solve();

        assertEquals(0, left.size());
        assertEquals(0, middle.size());
        assertEquals(3, right.size());

    }

}
