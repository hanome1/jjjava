package ru.gb.lesson6;

public class ВечноГолодныйКот extends Cat {

    public ВечноГолодныйКот(String name) {
        super(name, Integer.MAX_VALUE); // вызов конструктора родительского класса
    }

    @Override
    public void eat(Plate plate) {
//        super.eat(plate);
        hungry = true;
    }

}
