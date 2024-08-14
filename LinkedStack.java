// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Hima Bathula (906421933)

package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * // -------------------------------------------------------------------------
 * /** Represents LinedStack class
 * 
 * @param <T>
 *            generic entry(disk)
 * @author himabathula
 * @version Jul 28, 2024
 */

public class LinkedStack<T>
    implements StackInterface<T>

{

    /**
     * created field variables for topNode and size of stack
     */

    private Node<T> topNode;
    private int size;

    /**
     * constructor for linkedStack initalizing field variables
     */

    public LinkedStack()
    {
        topNode = null;
        size = 0;

    }


    /**
     * clears stack
     */

    @Override
    public void clear()
    {
        topNode = null;
        size = 0;

    }


    /**
     * checks if stack is empty depending on size
     */

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }


    /**
     * checks what is on the top of the stack throws exception if stack is empty
     */

    @Override
    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }

        return topNode.getData();
    }


    /**
     * removes disc from the stack and reduces size of stack throws throws
     * exception if stack is empty
     */

    @Override
    public T pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }

        T entry = topNode.getData();
        topNode = topNode.getNextNode();
        size--;
        return entry;
    }


    /**
     * pushes new entry onto the stack increases size of stack
     */

    @Override
    public void push(T anEntry)
    {
        Node<T> newNode = new Node<T>(anEntry, topNode);
        topNode = newNode;
        size++;

    }


    /**
     * Returns the number of elements in the stack
     * 
     * @return the size of the stack
     */

    public int size()
    {
        return size;
    }


    /**
     * appends the disc width values
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> currentNode = topNode;
        while (currentNode != null)
        {
            sb.append(currentNode.getData());
            if (currentNode.getNextNode() != null)
            {
                sb.append(", ");
            }

            currentNode = currentNode.getNextNode();
        }

        sb.append("]");
        return sb.toString();
    }

    /**
     * //
     * -------------------------------------------------------------------------
     * /** Represents Node class
     * 
     * @param <T>
     *            generic entry (disk)
     * @author himabathula
     * @version Jul 28, 2024
     */

    private class Node<T>
    {
        private T data;
        private Node<T> next;

        /**
         * initalizes node components given data entry
         * 
         * @param data
         *            represents node entry
         */
        public Node(T data)
        {
            this.data = data;
            this.next = null;
        }


        /**
         * initalizes node components, given data entry and node
         */
        public Node(T entry, Node<T> node)
        {
            this(entry);
            this.setNextNode(node);
        }


        /**
         * sets next node as the given node
         * 
         * @param node
         *            represents next node
         */

        public void setNextNode(Node<T> node)
        {
            this.next = node;
        }


        /**
         * returns the next node
         */

        public Node<T> getNextNode()
        {
            return next;

        }


        /**
         * gets the data of the current node
         */

        public T getData()
        {
            return data;
        }

    }

}
