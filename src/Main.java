import java.io.IOException;
import java.util.InputMismatchException;

public  class Main{
    public static void main(String[] args)
            throws IOException {
        Formula1ChampionshipManager driverObj = new Formula1ChampionshipManager(); //creating an Obj for the Formula1ChampionshipManager class

        while (true) {
            try{
                int enterCase = Formula1ChampionshipManager.getIn();
                switch (enterCase) {
                    case 1 -> driverObj.createADriver();    //methods calling for the user's input.
                    case 2 -> driverObj.deleteADriver();
                    case 3 -> driverObj.changeADriver();
                    case 4 -> driverObj.driverStatics();
                    case 5 -> driverObj.driverDetailsTable();
                    case 6 -> driverObj.getRaceData();
                    case 7 -> driverObj.saveDataOnFile();
                    case 8 -> driverObj.loadDataFromFile();
                    case 9 -> driverObj.gui();
                    default -> System.out.println("Wrong Input.");      // if the user enter an invalid integer system shows.
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Invalid Input. Please try again.");   // if the user enter an invalid value system shows.
            }
        }
    }
}
