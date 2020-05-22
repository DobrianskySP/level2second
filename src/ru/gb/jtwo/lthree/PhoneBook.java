package ru.gb.jtwo.lthree;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    HashMap<String, ArrayList<Person>> pb = new HashMap<>();

    public void putPerson(String name, String phone, String email){
        if (pb.containsKey(name)){
            ArrayList<Person> persons = pb.get(name);
            persons.add(new Person(phone, email));
        } else {
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(new Person(phone, email));
            pb.put(name, persons);
        }
    }

    public void getNumber(String name){
        ArrayList<Person> person = pb.get(name);
        ArrayList<String> phones = new ArrayList<>();
        for (int i = 0; i < person.size(); i++) {
            phones.add(person.get(i).phone);
        }
        System.out.println("Номер телефона " + name + ": " + phones);
    }
    public void getEmail(String name){
        ArrayList<Person> person = pb.get(name);
        ArrayList<String> email = new ArrayList<>();
        for (int i = 0; i < person.size(); i++) {
            email.add(person.get(i).email);
        }
        System.out.println("Номер телефона " + name + ": " + email);
    }

}
