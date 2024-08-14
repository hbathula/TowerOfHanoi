// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Hima Bathula (906421933)

package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * // -------------------------------------------------------------------------
 * /** Represents test class for LinkedStackTest
 * 
 * @author himabathula
 * @version Jul 28, 2024
 */

public class LinkedStackTest
    extends TestCase

{
    /**
     * creates reference to linkedStack of discs of type Disc class
     */

    private LinkedStack<Disk> stack;

    @Override
    public void setUp()
    {

        /**
         * initalizes stack
         */
        stack = new LinkedStack<>();
    }


    /**
     * tests clear method
     */
    public void testClear()
    {
        stack.push(new Disk(1));
        stack.push(new Disk(2));
        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }


    /**
     * tests isEmpty method
     */

    public void testIsEmpty()
    {
        assertTrue(stack.isEmpty());
        stack.push(new Disk(1));
        assertFalse(stack.isEmpty());
    }


    /**
     * tests peek method checks the exception method
     */

    public void testPeek()
    {
        try
        {
            stack.peek();
        }
        catch (EmptyStackException e)
        {
            // empty catch block

        }

        stack.push(new Disk(1));
        assertEquals(1, stack.peek().getWidth());
    }


    /**
     * tests pop method
     */

    public void testPop()
    {
        try
        {
            stack.pop();
        }
        catch (EmptyStackException e)
        {
            // empty catch block
        }

        stack.push(new Disk(1));
        assertEquals(1, stack.pop().getWidth());
        assertTrue(stack.isEmpty());

    }


    /**
     * tests toString() method
     */

    public void testToString()
    {
        assertEquals("[]", stack.toString());
        stack.push(new Disk(1));
        assertEquals("[1]", stack.toString());
        stack.push(new Disk(2));
        assertEquals("[2, 1]", stack.toString());
    }

}
