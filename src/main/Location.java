/**
 * Created by lavanya on 6/7/17.
 */
public class Location {
    int xCordinate;
    int yCordinate;

    Location(int xCordinate, int yCordinate) {
        this.xCordinate = xCordinate;
        this.yCordinate = yCordinate;
    }

    public boolean equals(Object obj) {
        Location location = (Location) obj;
        if (!(location instanceof Location))
            throw new IllegalArgumentException();
        return (xCordinate == location.xCordinate && yCordinate == location.yCordinate);
    }

    public boolean checkLocationWithTheBoundaryValues(Plateau plateau) {
        if (this.xCordinate > plateau.getUpperXCordinate() || this.xCordinate < 0)
            return false;
        if (this.yCordinate > plateau.getUpperYCordinate() || this.yCordinate < 0)
            return false;
        return true;
    }


}

