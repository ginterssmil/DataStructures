package service;

import datastr.MyArrayList;


public class MainService {
    public static void main(String[] args) {
        MyArrayList symbols = new MyArrayList(3);
        symbols.add('a');
        symbols.add('b');
        symbols.add('c');
        symbols.add('d');

        symbols.sort();
        symbols.print();
        symbols.makeEmpty();

        
        try {
            symbols.print();
            symbols.add('Z',1);
            symbols.print();
            symbols.remove(2);
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}
