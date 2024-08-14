// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Hima Bathula (906421933)

package towerofhanoi;

/**
 * // -------------------------------------------------------------------------
 * /** represents tower class
 * 
 * @author himabathula
 * @version Jul 28, 2024
 */

public class Tower
    extends LinkedStack<Disk>
{

    // field variables
    private Position position;

    /**
     * constructor for tower class
     * 
     * @param position
     *            takes position of tower
     */
    public Tower(Position position)
    {
        super();
        this.position = position;
    }


    /**
     * @return returns position of tower
     */

    public Position position()
    {
        return position;
    }


    /**
     * overrides the LinkedStacks push method
     * 
     * @param disk
     *            disk obj
     */

    @Override
    public void push(Disk disk)
    {
        if (disk == null)
        {
            throw new IllegalArgumentException();
        }

        if (isEmpty() || disk.compareTo(peek()) < 0)
        {
            super.push(disk);
        }
        else
        {

            throw new IllegalStateException();
        }

    }
}
