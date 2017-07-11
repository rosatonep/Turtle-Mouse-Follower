/* Author: Philip Rosatone, U85355157 */

package cop2513.turtlemousefollow;

import edu.gatech.mediacomp.Turtle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.MouseInfo;

public class TurtleMouseFollower extends MouseAdapter { // Gets rid of unused methods.
    private static final int FORWARD_PIXELS = 3; // Constant for how many pixels the turtle will move forward.
    private Turtle t; // Creates a private turtle "t".

    public TurtleMouseFollower(Turtle turtle) { // Turtle constructor.
        t = turtle;

    } // End of constructor

    Point point = MouseInfo.getPointerInfo().getLocation(); // Gets the location of the mouse.

    Timer timer = new Timer(50, new ActionListener() { // Creates a timer.
        @Override
        public void actionPerformed(ActionEvent e) {
            t.forward(FORWARD_PIXELS); // Moves the turtle forward 3 pixels every iteration of the timer.
        }
    }); // End of Timer.

    @Override
    public void mouseEntered(MouseEvent e) { // Method is triggered once the mouse enters the world.
        int x = e.getX(); // Gets X position of the mouse.
        int y = e.getY(); // Gets Y position of the mouse.
        t.turnToFace(x, y); // Turns the turtle to face the mouse.
        t.forward(FORWARD_PIXELS); // Moves the turtle forward 3 pixels.
        timer.start(); // Starts the timer.

    } // End of mouseEntered.

    @Override
    public void mouseExited(MouseEvent e) { // Method is triggered once the mouse exits the world.
        timer.stop(); // Stops the timer.
        point = null; // Makes point NULL.

    } // End of mouseExited.

    @Override
    public void mouseMoved(MouseEvent e) { // Method is triggered once the mouse is moved.
        int x = e.getX(); // Gets X position of the mouse.
        int y = e.getY(); // Gets Y position of the mouse.
        t.turnToFace(x, y); // Turns the turtle to face the mouse.
        int x2 = t.getXPos(); // Gets X position of the turtle.
        int y2 = t.getYPos(); // Gets Y position of the turtle.
        if (x == x2 && y == y2) { // Checks if mouse and turtle are in the same position.
            point = null; // Makes point NULL.
            timer.stop(); // Stops the timer.
        }
        else if (x != x2 && y != y2){ // Once they are not equal the turtle begins to follow again.
            timer.start(); // Starts the timer.
        }
        /* Either due to the turtle itself not being consistent or the possibility of round off error, the turtle
           does tend to miss the mouse by a narrow margin and does not stop on the mouse. I have managed to get the
           turtle to stop on the mouse after a few tries and then after the moving the mouse again the turtle
           continues to follow as it should. */

    } // End of mouseMoved.

} // End of Class TurtleMouseFollower

