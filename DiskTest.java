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
 * /** Represents the test class for Disc
 * 
 * @author himabathula
 * @version Jul 28, 2024
 */

public class DiskTest
    extends TestCase

/**
 * Creates 4 disc objects
 */
{

    private Disk disk1;
    private Disk disk2;
    private Disk disk3;

    @Override
    public void setUp()
    {
        /**
         * initializes 3 disc objects with widths of 10, 20, 10, null
         */
        disk1 = new Disk(10);
        disk2 = new Disk(20);
        disk3 = new Disk(10);

    }


    /**
     * returns the width of a disc as a string
     */

    public void testToString()
    {
        assertEquals("10", disk1.toString());
    }


    /**
     * tests the equals method compares two of the same discs compares discs of
     * different lengths compares disks when one is null compares disks of
     * different type
     */

    public void testEquals()
    {
        assertTrue(disk1.equals(disk1));
        assertTrue(disk1.equals(disk3));
        assertFalse(disk1.equals(disk2));
        assertFalse((disk1.equals(null)));
        assertFalse(disk1.equals(new Object()));
    }


    /**
     * compares disc widths throws exception when disc is compared to null
     */

    public void testCompareTo()
    {
        try
        {
            disk1.compareTo(null);
        }

        catch (IllegalArgumentException e)
        {
            assertEquals("other disk cannot be null", e.getMessage());
        }

        assertTrue(disk1.compareTo(disk2) < 0);
        assertTrue(disk2.compareTo(disk1) > 0);
        assertEquals(0, disk1.compareTo(disk3));

    }

}
