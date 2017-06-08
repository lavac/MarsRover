import java.util.Scanner;

public class Init {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int xCoOrdinate = in.nextInt();
        int yCoOrdinate = in.nextInt();
        Plateau plateau = new Plateau(xCoOrdinate, yCoOrdinate);
        for (int rover = 1; rover <= 2; rover++) {
            int initialXCordinate = in.nextInt();
            int initialYCordinate = in.nextInt();
            String direction = in.next();
            Position.Direction initialDirection = Position.Direction.fromString(direction);
            Location location = new Location(initialXCordinate, initialYCordinate);
            MarsRover marsRover = new MarsRover(location, initialDirection, plateau);
            String instruction = in.next();
            marsRover.navigatingAsPerInstruction(instruction);
            System.out.println(location.xCordinate + " " + location.yCordinate + " " + marsRover.getDirection());
        }
    }
}


