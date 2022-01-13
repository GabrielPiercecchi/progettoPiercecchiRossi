package inactiveClasses;

import org.json.simple.parser.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTest {

    public static void main(String[] args){

        // To take the input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Date ");

        String date = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date2=null;
        try {
            //Parsing the String
            date2 = dateFormat.parse(date);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date2);
    }
}
