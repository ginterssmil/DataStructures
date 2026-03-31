package service;

import java.lang.reflect.Array;
import java.util.Arrays;

import model.MyArrayList;
import model.Student;


public class MainService {
    public static void main(String[] args) {

        try {
        MyArrayList symbols = new MyArrayList(3);
        symbols.add('a');
        symbols.add('b');
        symbols.add('c');
        symbols.add('d');

        symbols.print();

        symbols.sort();
        symbols.print();

        symbols.add('Z',1);
        symbols.print();
        symbols.remove(2);
        symbols.print();

        symbols.makeEmpty();


        }
        catch (Exception e) {
            System.out.println(e);
        }

        MyArrayList<Student> allStudents = new MyArrayList<Student>();
        Student s1 = new Student("Ilmars", "Sula", "123458-12345");
        Student s2 = new Student("Austrins", "Zeidz", "341259-12345");
        Student s3 = new Student("Janis", "Berzins", "173521-12345");
        try{
        allStudents.add(s1);
        allStudents.add(s2);
        allStudents.add(s3,0);
        allStudents.print();
        System.out.println(allStudents.search(s3));
        System.out.println(Arrays.toString(allStudents.getNextElements(s3)));
        
        System.out.println("==========sorted======");
        allStudents.sort();
        allStudents.print();

        System.out.println("remove 1 ele");
        allStudents.remove(0);

        System.out.println("==========howManyElements======");
        System.out.println(allStudents.getHowManyElements());

        System.out.println("==========makeEmpty======");
        allStudents.makeEmpty();
        allStudents.print();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
