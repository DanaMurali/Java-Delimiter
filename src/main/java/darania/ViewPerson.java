package darania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewPerson {

PersonList personList = new PersonList();
//PersonArray <Person> people = new PersonArray();

    public static void ViewPersons() {

        try {
            File file = new File("src/data");
            Scanner scFile = new Scanner(file);

            //if there is nothing next, come out of function.
            if (!scFile.hasNext()) {
                System.out.println("File is empty!");
                return;
            }

            String header = scFile.nextLine();
            System.out.println(header);

            scFile.useDelimiter(",|\\n");

            while (scFile.hasNext()) {


                String id = scFile.next();
                String first_name = scFile.next();
                String last_name = scFile.next();
                String email = scFile.next();
                String gender = scFile.next();

                PersonList.personArray.add(new Person(id, first_name, last_name, email, gender));

            }
            PersonList.personArray.forEach(person -> System.out.println(person));
            //System.out.println(PersonList.personArray);

        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        }

    }

}
