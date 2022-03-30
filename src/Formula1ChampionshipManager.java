import java.util.*;
import java.io.*;

public class Formula1ChampionshipManager extends Gui{
    static ArrayList<Formula1Driver> info = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static ArrayList<Formula1Driver> racersList = new ArrayList<>();
    static ArrayList<Formula1Driver> ascendingOrderList = new ArrayList<>(racersList);   //creating an array lists for
    static ArrayList<Formula1Driver> descendingOrderList = new ArrayList<>(racersList);     //output the results
    static ArrayList<Formula1Driver> sortedByWinsList = new ArrayList<>(racersList);      //as mentioned in the CW.
    static ArrayList<String> DatesList = new ArrayList<>();


    static int getIn() {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Please Enter...");
        System.out.println();
        System.out.println("Enter number '1' to create a driver.");
        System.out.println("Enter number '2' to delete a driver.");
        System.out.println("Enter number '3' to change driver.");
        System.out.println("Enter number '4' to see driver statics.");
        System.out.println("Enter number '5' to see driver table.");
        System.out.println("Enter number '6' to enter race data.");
        System.out.println("Enter number '7' to save data on a file.");
        System.out.println("Enter number '8' to see saved data on file.");
        System.out.println("Enter number '9' to see GUI interface.");
        System.out.println();

        return input.nextInt();        //return the input value and call the necessary method.
    }

    public  void createADriver() {      //create a new driver when user inputs number 1. (create a driver method)
        Formula1Driver f1driver = new Formula1Driver();    //creating a new object called f1driver for the Formula1Driver class.
        System.out.println();

        System.out.print("Driver's name : ");
        f1driver.name = input.next();          //input details from the user.

        System.out.print("Driver's location : ");
        f1driver.location = input.next();

        System.out.print("Driver's team : ");
        f1driver.team = input.next();

        System.out.print("1st places (wins) : ");
        f1driver.numOf1P = input.nextInt();

        System.out.print("2nd places : ");
        f1driver.numOf2P = input.nextInt();

        System.out.print("3rd places : ");
        f1driver.numOf3P = input.nextInt();

        System.out.print("Collected points : ");
        f1driver.points = input.nextInt();

        System.out.print("Races participated : ");
        f1driver.numOfRaces = input.nextInt();


        System.out.println();
        info.add(f1driver);     //data will be saved in f1driver object


    }

    public  void deleteADriver() {    //creating delete driver method
        System.out.println();
        System.out.println("Select the driver to delete.");
        for (Formula1Driver drv: info) {
            System.out.println(info.indexOf(drv) + " -> " + drv.name);   //print drivers with numbers
        }
        System.out.print("Enter the driver number to delete : ");
        info.remove(input.nextInt());   //the driver will be removed from the info array
    }

    //creating change driver method to change driver for a team.
    public void changeADriver() {
        System.out.println();
        System.out.println("Select the team to change driver.");
        for (Formula1Driver drv: info) {
            System.out.println(info.indexOf(drv) + " -> " + drv.team);
        }
        System.out.print("Enter the team number to change : ");
        int teamNum = input.nextInt();

        System.out.print("Enter new Driver's name : ");
        info.get(teamNum).name = input.next();

        System.out.print("Location of the new Driver : ");
        info.get(teamNum).location = input.next();

        System.out.print("1st places (wins) : ");
        info.get(teamNum).numOf1P = input.nextInt();

        System.out.print("2nd places : ");
        info.get(teamNum).numOf2P = input.nextInt();

        System.out.print("3rd places : ");
        info.get(teamNum).numOf3P = input.nextInt();

        System.out.print("Collected points :  : ");
        info.get(teamNum).points = input.nextInt();

        System.out.print("Races participated : ");
        info.get(teamNum).numOfRaces = input.nextInt();

    }
//creating driver statistic method to see driver's statistics individually.
    public void driverStatics() {
        System.out.println();
        System.out.println("Select the driver to see his statics.");
        for (Formula1Driver drv: info) {
            System.out.println(info.indexOf(drv) + ". " + drv.name);
        }
        System.out.print("Enter the driver number to see his statics : ");
        int stat = input.nextInt();
        System.out.println();
        System.out.println("Driver's name : "+info.get(stat).name);
        System.out.println("Driver's location : "+info.get(stat).location);
        System.out.println("Driver's team : "+info.get(stat).team);
        System.out.println("Number of races participated : "+info.get(stat).numOfRaces);
        System.out.println("Collected points : "+info.get(stat).points);
        System.out.println("Number of 1st positions : "+info.get(stat).numOf1P);
        System.out.println("Number of 2nd positions : "+info.get(stat).numOf2P);
        System.out.println("Number of 3rd positions : "+info.get(stat).numOf3P);
    }

    public void driverDetailsTable() {
        Formula1Driver[] formula1Drivers = info.toArray(new Formula1Driver[]{});   //data in the arrayList is pass to formula1driver array
        List<Formula1Driver> sortedList1 = Arrays.asList(formula1Drivers);    //f1driver array data passing to the sorted list.
        LinkedList<Formula1Driver> ListInOrder = new LinkedList<>();  //initializing the linkedList.
        LinkedList<Formula1Driver> sortedByWinsArrayList = new LinkedList<>(info);
        LinkedList<Formula1Driver> sortedByPointsArrayList = new LinkedList<>(info);

        sortedByWinsArrayList.sort(Formula1Driver.sortByWins);  //sort as most winning in GUI table.
        sortedByWinsList.addAll(sortedByWinsArrayList);

        sortedByPointsArrayList.sort(Formula1Driver.sortByPointsAscOrder);   //sort as ascending order.
        ascendingOrderList.addAll(sortedByPointsArrayList);

        sortedByPointsArrayList.sort(Formula1Driver.sortByPointsDesOrder);  //sort as descending order.
        descendingOrderList.addAll(sortedByPointsArrayList);

        Collections.sort(sortedList1, Collections.reverseOrder());
        for (Formula1Driver f1: sortedList1){
            ListInOrder.add(f1);
        }

        for (int i = 0; i < 10; i++) {
            if (ListInOrder.get(i).getPoints() == ListInOrder.get(i+1).getPoints()){
                if (ListInOrder.get(i).getP1() < ListInOrder.get(i+1).getP1()){
                    Collections.swap(ListInOrder, i, (i + 1));
                }
            }
            break;
        }
        System.out.println();
        String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15d | %-15d |%n";
        System.out.format("|------------------------------------------------------------------------------------------%n");
        System.out.format("|      Name       |      Team       |     Location    |      Points     |       Wins      |%n");
        System.out.format("|------------------------------------------------------------------------------------------%n");
        for (Formula1Driver drv:ListInOrder){
            System.out.format(leftAlignFormat, drv.getName() , drv.getTeam() , drv.getLocation() , drv.getPoints(), drv.getP1());
        }
        System.out.format("-------------------------------------------------------------------------------------------%n");
    }

    //creating a race data method to input race data by user.
    public static void getRaceData() {
        System.out.println();
        System.out.print("Enter Date of the race : ");
        String date = input.next();  //ask the user to enter a race date.
        DatesList.add(date);

        for(int i = 1; i <= info.toArray().length; i++){
            System.out.println();
            System.out.println("Enter driver's number who finished the race place "+ i + ".");
            System.out.println("If no one finishes for this position please enter '123'...");

            for (Formula1Driver drv: info) {
                System.out.println(info.indexOf(drv) + ". " + drv.name);
            }
            if(i==1) {      //if the driver places i (Position),
                int x = input.nextInt();
                if(x!=123){     //if enter 123 you can leave the position for no one.
                    info.get(x).points = info.get(x).points + 25;
                    info.get(x).numOf1P = info.get(x).numOf1P + 1; }

            }else if(i==2){
                int x = input.nextInt();
                if(x!=123){
                    info.get(x).points = info.get(x).points + 18;
                    info.get(x).numOf2P = info.get(x).numOf2P + 1; }

            }else if(i==3){
                int x = input.nextInt();
                if(x!=123){
                    info.get(x).points = info.get(x).points + 15;
                    info.get(x).numOf3P = info.get(x).numOf3P + 1; }

            }else if(i==4){
                int x = input.nextInt();
                if(x!=123){
                    info.get(x).points = info.get(x).points + 12; }

            }else if(i==5){
                int x = input.nextInt();
                if(x!=123){
                    info.get(x).points = info.get(x).points + 10; }

            }else if(i==6){
                int x = input.nextInt();
                if(x!=123){
                    info.get(x).points = info.get(x).points + 8; }

            }else if(i==7){
                int x = input.nextInt();
                if(x!=123){
                    info.get(x).points = info.get(x).points + 6; }

            }else if(i==8){
                int x = input.nextInt();
                if(x!=123){
                    info.get(x).points = info.get(x).points + 4; }

            }else if(i==9){
                int x = input.nextInt();
                if(x!=123){
                    info.get(x).points = info.get(x).points + 2; }

            }else if(i==10){
                int x = input.nextInt();
                if(x!=123){
                    info.get(x).points = info.get(x).points + 1; }
            }
        }
    }

    public void saveDataOnFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("data.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for(Formula1Driver formula1Driver : info)                 //the data on arraylist will be written to the file and save.
            objectOutputStream.writeObject(formula1Driver);
        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println("Data Successfully Saved.");

    }

    public void loadDataFromFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("data.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        do{
            try {
                Formula1Driver driver = (Formula1Driver) objectInputStream.readObject();
                info.add(driver);       //the data will be added to the data arraylist.
            }
            catch(EOFException | ClassNotFoundException ex) {
                break;
            }
        }
        while (true);

    }

    public void gui() {
        GuiPart gui = new GuiPart();
    }

}