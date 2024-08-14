// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Hima Bathula (906421933)

package towerofhanoi;

import cs2.*;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

/**
 * represents PuzzleWindow Class
 */

public class PuzzleWindow
    implements Observer
{
    /**
     * window components instantiated
     */

    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;
    /**
     * A factor in which the width of the disks are multiplied by
     */
    public static final int WIDTH_FACTOR = 15;
    /**
     * The vertical gap between each disk on the tower
     */
    public static final int DISK_GAP = 0;
    /**
     * The height of each disk on the tower
     */
    public static final int DISK_HEIGHT = 15;

    /**
     * Creates a new PuzzleWindow view for a given HanoiSolver game
     *
     * @param g
     *            the game to create a view for
     */
    public PuzzleWindow(HanoiSolver g)
    {
        this.game = g;
        game.addObserver(this);
        window = new Window();
        window.setTitle("Tower of Hanoi");
        window.setSize(700, 700);

        // The height and Y location of each pole are the same
        int poleHeight = 400;
        int poleY = (window.getGraphPanelHeight() / 2) - (poleHeight / 2);
        left = new Shape(
            (200 - 15 / 2),
            poleY,
            15,
            poleHeight,
            new Color(50, 50, 50));
        middle = new Shape(
            ((window.getGraphPanelWidth() / 2) - 15 / 2),
            poleY,
            15,
            poleHeight,
            new Color(50, 50, 50));
        right = new Shape(
            ((window.getGraphPanelWidth() - 200) - 15 / 2),
            poleY,
            15,
            poleHeight,
            new Color(50, 50, 50));

        for (int width =
            (game.disks() + 1) * WIDTH_FACTOR; width > WIDTH_FACTOR; width -=
                WIDTH_FACTOR)
        {
            Disk disk = new Disk(width);
            window.addShape(disk);
            game.getTower(Position.LEFT).push(disk);
            moveDisk(Position.LEFT);

        }

        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);

        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");

    }


    /**
     * moves disk to respective tower position
     * 
     * @param position
     *            holds the value of the tower position
     */

    private void moveDisk(Position position)
    {
        Disk currentDisk = null;
        Shape currentPole = null;

        switch (position)
        {
            case LEFT:
                currentPole = left;
                currentDisk = game.getTower(Position.LEFT).peek();
                break;
            case MIDDLE:
                currentPole = middle;
                currentDisk = game.getTower(Position.MIDDLE).peek();
                break;
            case RIGHT:
                currentPole = right;
                currentDisk = game.getTower(Position.RIGHT).peek();
                break;
            default:
                break;

        }

        /**
         * positions the discs on the middle of the tower based on x and y
         * coordinates
         */

        int newX = currentPole.getX()
            + (currentPole.getWidth() - currentDisk.getWidth()) / 2;
        int newY = currentPole.getY() + currentPole.getHeight()
            - DISK_HEIGHT * game.getTower(position).size();

        currentDisk.moveTo(newX, newY);

    }


    /**
     * Updates the view whenever a disk is moved in the back-end
     *
     * @param o
     *            The observable that triggered the update
     * @param arg
     *            arguments sent by the game; should be a position
     */
    @Override
    public void update(Observable o, Object arg)
    {
        if (arg.getClass() == Position.class)
        {
            Position position = (Position)arg;
            moveDisk(position);
            sleep();
        }
    }


    /**
     * Runs when the Solve button is clicked, tells the puzzle to start solving
     *
     * @param button
     *            the button that was clicked
     */
    public void clickedSolve(Button button)
    {
        button.disable();
        new Thread() {
            @Override
            public void run()
            {
                game.solve();
            }
        }.start();
    }


    /**
     * pauses between disk movements
     */

    private void sleep()
    {
        try
        {
            Thread.sleep(500);
        }
        catch (Exception e)
        {
        }
    }
}
