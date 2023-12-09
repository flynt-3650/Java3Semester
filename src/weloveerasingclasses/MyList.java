package weloveerasingclasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyList<T> {
    private T[] array;

    public MyList(T[] array) {
        this.array = array;
    }

//    public MyList(int size) {
//        this.array = (T[]) new Object[size];
//        for (int i = 0; i < size; i++) {
//            this.array[i] = null;
//        }
//    }

    public T get(int index) {
        return array[index];
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public void print5() {
        List<T> l = new ArrayList<>(Arrays.asList(array).subList(0, 5));

        for (var item : l)
            System.out.println(item);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 54, 3123, 4543534};
        MyList<Integer> myList = new MyList<>(arr);
        myList.print5();
        System.out.println(myList.get(7));
    }
}

//
//    1. Написать метод для конвертации массива строк/чисел в список.
//    2. Написать класс, который умеет хранить в себе массив любых типов
//    данных (int, long etc.).
//    3. Реализовать метод, который возвращает любой элемент массива по
//    индексу.
//    4. Написать функцию, которая сохранит содержимое каталога в
//    список и выведет первые 5 элементов на экран.
//    5. *Реализуйте вспомогательные методы в классе Solution, которые
//    должны создавать соответствующую коллекцию и помещать туда переданные
//    объекты. Методы newArrayList, newHashSet параметризируйте общим типом T.
//    Метод newHashMap параметризируйте парой <K, V>, то есть типами К- ключ и
//    V-значение. Аргументы метода newHashMap должны принимать. Класс
//    содержит три переменные типа (T, V, K), конструктор, принимающий на вход.