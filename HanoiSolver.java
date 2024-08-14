// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Hima Bathula (906421933)

package towerofhanoi;

import java.util.Observable;

/**
 * // -------------------------------------------------------------------------
 * /** Represents HanoiSolver class
 * 
 * @author himabathula
 * @version Jul 28, 2024
 */

public class HanoiSolver
    extends Observable
{
    /**
     * creates 3 tower objects creates numDisks variable
     */
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    /**
     * constructor sets up HanoiSolver class
     * 
     * @param numDisks
     *            the number of disks
     */
    public HanoiSolver(int numDisks)
    {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }


    /**
     * @return number of disks
     */

    public int disks()
    {
        return numDisks;
    }


    /**
     * gets the tower position based on the position provided from the tower
     * class
     * 
     * @param position
     *            represents position from position class
     * @return returns the middle tower for a default case
     */

    public Tower getTower(Position position)
    {

        switch (position)
        {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case MIDDLE:
                return middle;
            case DEFAULT:
            default:
                return middle;
        }

    }


    /**
     * returns the concatention of the string positions
     */

    @Override
    public String toString()
    {
        return left.toString() + middle.toString() + right.toString();
    }


    /**
     * moves the disks from the source tower to destination tower
     * 
     * @param source
     *            start tower
     * @param destination
     *            destination tower
     */

    public void move(Tower source, Tower destination)
    {
        Disk disk = source.pop();
        destination.push(disk);
        setChanged();
        notifyObservers(destination.position());

    }


    /**
     * computes the recursion for tower of hanoi. When there is only one disk,
     * the disk is moved from start to end. Otherwise the disks move from start
     * to temp using end as "temporary" collection. Then start to end is called
     * lastly temp discs are moved from temp to end using start tower as temp
     * 
     * @param disks
     *            number of disks
     * @param start
     *            start tower
     * @param temp
     *            temp tower
     * @param end
     *            end tower
     */

    public void solveTowers(int disks, Tower start, Tower temp, Tower end)
    {
        if (disks == 1)
        {
            move(start, end);
        }

        else
        {

            solveTowers(disks - 1, start, end, temp);

            move(start, end);

            solveTowers(disks - 1, temp, start, end);

        }
    }


    /**
     * calls the solveTowers method
     */

    public void solve()
    {

        solveTowers(numDisks, left, middle, right);
    }

}
