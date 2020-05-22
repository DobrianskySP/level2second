package ru.gb.jtwo.lthree;

public class Main {
    public static void main(String[] args) {
    PhoneBook phoneBook = new PhoneBook();
    phoneBook.putPerson("Добрянский", "+79657851265", "dobriansky.sp@oilpc.ru");
    phoneBook.putPerson("Иванов", "+79001231223", "ivanov.sp@oilpc.ru");
    phoneBook.putPerson("Петров", "+78007894545", "petrov.sp@oilpc.ru");
    phoneBook.getEmail("Добрянский");
    phoneBook.getNumber("Добрянский");
    phoneBook.putPerson("Добрянский", "79006366670", "hhgf@klvnv");
    phoneBook.getNumber("Иванов");
    phoneBook.getNumber("Петров");
    phoneBook.getNumber("Добрянский");
    phoneBook.getEmail("Добрянский");

    }
}
