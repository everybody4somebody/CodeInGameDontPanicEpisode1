import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        int exitFloor = in.nextInt(); // floor on which the exit is found
        int exitPos = in.nextInt(); // position of the exit on its floor
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
        int nbElevators = in.nextInt(); // number of elevators
        int[] elevatorPos = new int[nbFloors];
        for (int i = 0; i < nbElevators; i++) {
            elevatorPos[in.nextInt()] = in.nextInt(); // floor on which this elevator is found
        }

        // game loop
        while (true) {
            int cloneFloor = in.nextInt(); // floor of the leading clone
            int clonePos = in.nextInt(); // position of the leading clone on its floor
            String direction = in.next(); // direction of the leading clone: LEFT or RIGHT
            if(cloneFloor == exitFloor){
                System.err.println("EXIT ON FLOOR, POS: " + exitPos);
                System.err.println("CLONE POS: " + clonePos);
                System.err.println("CLONE DIRECTION: " + direction);
                if(direction.equals("RIGHT") && exitPos < clonePos){
                    System.out.println("BLOCK"); // action: WAIT or BLOCK
                } else if(direction.equals("LEFT") && exitPos > clonePos){
                    System.out.println("BLOCK"); // action: WAIT or BLOCK
                } else {
                    System.err.println("TEST");
                    System.out.println("WAIT"); // action: WAIT or BLOCK
                }
            } else if(cloneFloor != -1) {
                System.err.println("EXIT NOT ON FLOOR");
                if(direction.equals("RIGHT")){
                    System.err.println("RIGHT");
                    System.err.println("Elevator Position: " + elevatorPos[cloneFloor]);
                    System.err.println("Clone Position: " + clonePos);
                    if(elevatorPos[cloneFloor] < clonePos){
                        System.out.println("BLOCK"); // action: WAIT or BLOCK
                    } else {
                        System.out.println("WAIT"); // action: WAIT or BLOCK
                    }
                    
                } else if(direction.equals("LEFT")) {
                    System.err.println("LEFT");
                    if(elevatorPos[cloneFloor] > clonePos){
                        System.out.println("BLOCK"); // action: WAIT or BLOCK
                    } else {
                        System.out.println("WAIT"); // action: WAIT or BLOCK
                    }
                }
            } else {
                System.out.println("WAIT"); // action: WAIT or BLOCK                
            }
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

        }
    }
}
