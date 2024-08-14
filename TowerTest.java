// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Hima Bathula (906421933)

package towerofhanoi;

/**
 * // -------------------------------------------------------------------------
 * /** represnts test class for towerTest
 * 
 * @author himabathula
 * @version Jul 28, 2024
 */

public class TowerTest
    extends student.TestCase
{

    /**
     * creates tower objects for left, middle, and right
     */
    private Tower leftTower;
    private Tower middleTower;
    private Tower rightTower;

    /**
     * positions the three different towers
     */

    @Override
    public void setUp()
    {

        leftTower = new Tower(Position.LEFT);
        middleTower = new Tower(Position.MIDDLE);
        rightTower = new Tower(Position.RIGHT);

    }


    /**
     * tests the push method
     */

    public void testPush()
    {
        Disk disk1 = new Disk(3);
        Disk disk2 = new Disk(2);
        Disk disk3 = new Disk(1);

        leftTower.push(disk1);
        assertEquals(disk1, leftTower.peek());

        middleTower.push(disk2);
        assertEquals(disk2, middleTower.peek());

        rightTower.push(disk3);
        assertEquals(disk3, rightTower.peek());

    }

}
