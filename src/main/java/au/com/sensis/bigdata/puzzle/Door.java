package au.com.sensis.bigdata.puzzle;

import java.util.ArrayList;
import java.util.Iterator;

/*
 *
 * http://www.techinterview.org/post/526370758/100-doors-in-a-row
 *
 * Problem: you have 100 doors in a row that are all initially closed. you make 100 passes
 * by the doors starting with the first door every time. the first time through you visit
 * every door and toggle the door (if the door is closed, you open it, if its open, you close it).
 *  the second time you only visit every 2nd door (door #2, #4, #6). the third time, every 3rd door
 *  (door #3, #6, #9), etc, until you only visit the 100th door.
 *
 * question: what state are the doors in after the last pass? which are open which are closed?
 *
 */
public class Door {

    private int id = 0;
    private boolean isClosed = true;

    public void visit() {
        isClosed = !isClosed;
    }

    public Door(int id) {
        this.id = id;
    }

    public String toString() {
        //System.out.println("id["+id+"]: "+isClosed);
        return "Door["+id+"]: "+(isClosed ? "Closed":"Open");
    }

    public static void main (String[] args) {

        int iNumberOfDoorsAndIteration = 100;

        // Init 100 doors
        ArrayList<Door> doors = new ArrayList<Door>(iNumberOfDoorsAndIteration);
        for(int i=1; i<=iNumberOfDoorsAndIteration; i++) {
            Door door = new Door(i);
            doors.add(door);
        }

        // Visit these doors
        for(int i=1; i<=iNumberOfDoorsAndIteration; i++) {
            int iMutiplier = i;
            for(int k=1; k*iMutiplier<=iNumberOfDoorsAndIteration; k++) {

                doors.get(k*iMutiplier-1).visit();
            }
        }

        // Print the status
        Iterator<Door> itor = doors.iterator();
        while (itor.hasNext()) {
            Door door = itor.next();
            System.out.println(door);
        }

    }
}
