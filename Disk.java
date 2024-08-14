// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Hima Bathula (906421933)

package towerofhanoi;

import cs2.Shape;
import java.awt.Color;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 * @author himabathula
 * @version Jul 26, 2024
 */
public class Disk
    extends Shape
    implements Comparable<Disk>
{

    // ----------------------------------------------------------
    /**
     * Create a new Disk object.
     * 
     * @param width
     *            represents width of the disk
     */
    public Disk(int width)
    {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom rand = new TestableRandom();
        Color color =
            new Color(rand.nextInt(50), rand.nextInt(100), rand.nextInt(200));

    }


    /**
     * returns value of disk width as a string
     */

    @Override
    public String toString()
    {

        return String.valueOf(this.getWidth());

    }


    /**
     * checks to see whether the widths of two discs are equal
     */

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        else if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        Disk otherObj = (Disk)obj;
        return getWidth() == otherObj.getWidth();

    }


    /**
     * evaluates the comparison between the widths of two discs
     */

    @Override
    public int compareTo(Disk otherDisk)
    {
        if (otherDisk == null)
        {
            throw new IllegalArgumentException("other disk cannot be null");
        }

        else if (this.getWidth() < otherDisk.getWidth())
        {
            return -1;
        }

        else if (this.getWidth() > otherDisk.getWidth())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

}
