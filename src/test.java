import java.util.Scanner;
public class test {

    public static void main(String[] args){

        while (true){
            Scanner my = new Scanner(System.in);
            try{
                System.out.println("Enter an integer : ");
                System.out.println(my.nextInt());
                break;
            }
            catch (Exception e){
                System.out.println("Invalid input");
            }
        }
    }
}
