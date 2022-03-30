import java.io.Serializable;
import java.util.Comparator;

public class Formula1Driver extends Driver implements Comparable<Formula1Driver> {

    int numOf1P;
    int numOf2P;
    int numOf3P;
    int points;
    int numOfRaces;

    public int getNumOfRaces() {
        return numOfRaces;
    }

    public void setNumOfRaces(int numOfRaces) {
        this.numOfRaces = numOfRaces;
    }

    public int getPoints() {
        return points;
    }
    public int getP1() {
        return numOf1P;
    }
    public int getP2() {
        return numOf2P;
    }
    public int getP3() {
        return numOf3P;
    }


    public void setPoints(int points) {
        this.points = points;
    }


    public void setNumOf1P(int numOf1P) {
        this.numOf1P = numOf1P;
    }

    public void setNumOf2P(int numOf2P) {
        this.numOf2P = numOf2P;
    }

    public void setNumOf3P(int numOf3P) {
        this.numOf3P = numOf3P;
    }

    public void placesAdder(int place) {
        if (place == 1) {
            numOf1P++;
            setNumOf1P(numOf1P);

        } else if (place == 2) {
            numOf2P++;
            setNumOf2P(numOf2P);

        } else if (place == 3) {
            numOf3P++;
            setNumOf3P(numOf3P);

        }
    }

    public void updatePoints(int place) {
        if (place == 1) {
            points = points + 25;


        } else if (place == 2) {

            points = points + 18;
        } else if (place == 3) {

            points = points + 15;
        } else if (place == 4) {
            points = points + 12;

        } else if (place == 5) {
            points = points + 10;

        } else if (place == 6) {
            points = points + 8;

        } else if (place == 7) {
            points = points + 6;

        } else if (place == 8) {
            points = points + 4;

        } else if (place == 9) {
            points = points + 2;

        } else if (place == 10) {
            points = points + 1;


        }
    }

    public void updateTotalRaces() {
        numOfRaces++;
    }

    @Override
    public String toString() {
        return "Formula 1 Driver --> "+"Name = "+getName()+", Location = "+getLocation()+", Team = "+getTeam()+", First Places = "+numOf1P+", Second Places = "+numOf2P+", Third Places = "+numOf3P+", Points = "+points+ ", Number of races participated = "+numOfRaces;
    }

    @Override
    public int compareTo(Formula1Driver formula1Driver) {      //compare the points in the table
        return Integer.compare(this.getPoints(), formula1Driver.getPoints());
    }

    public static Comparator<Formula1Driver> sortByPointsAscOrder = new Comparator<Formula1Driver>() {
        @Override
        public int compare(Formula1Driver d1, Formula1Driver d2) {
            int wins1 = d1.getPoints();
            int wins2 = d2.getPoints();

            return wins1-wins2;
        };
    };

    public static Comparator<Formula1Driver> sortByPointsDesOrder = new Comparator<Formula1Driver>() {
        @Override
        public int compare(Formula1Driver d1, Formula1Driver d2) {
            int wins1 = d1.getPoints();
            int wins2 = d2.getPoints();

            return wins2-wins1;
        };
    };

    public static Comparator<Formula1Driver> sortByWins = new Comparator<Formula1Driver>() {
        @Override
        public int compare(Formula1Driver d1, Formula1Driver d2) {
            int wins1 = d1.getP1();
            int wins2 = d2.getP1();

            return wins2-wins1;
        }
    };

}


