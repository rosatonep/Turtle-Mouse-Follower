/* Author: Philip Rosatone, U85355157 */

package cop2513.turtlemousefollow;

import edu.gatech.mediacomp.Turtle;
import edu.support.EndWorld;

public class Main {

    public static void main(String[] args) {

        EndWorld w = new EndWorld(); // Creates a EndWorld.
        Turtle t = new Turtle(w); // Creates a turtle.

        TurtleMouseFollower follower = new TurtleMouseFollower(t); // Calls the TurtleMouseFollower Class.
        w.addMouseListener(follower); // Adds the MouseListener interface.
        w.addMouseMotionListener(follower); // Adds the MouseMotionListener interface.

    } // End of main
} // End of Class Main

