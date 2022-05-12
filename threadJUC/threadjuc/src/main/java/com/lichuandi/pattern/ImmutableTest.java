package com.lichuandi.pattern;

/**
 * @author digege
 * @date 2021/10/29 17:11
 * @description：TODO
 * @page com.lichuandi.pattern
 * version：1
 */
public class ImmutableTest {
  public static void main(String[] args) {
      Person alice = new Person("Alice", "Alaska");
      new PrintPersonThread(alice).start();
      new PrintPersonThread(alice).start();
      new PrintPersonThread(alice).start();
  }
}
final class Person {
    private final String name;
    private final String address;
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    @Override
    public String toString() {
        return "[ Person: name = " + name + ", address = " + address + " ]";
    }
}
class PrintPersonThread extends Thread {
    private Person person;
    //Person是final类型的
    public PrintPersonThread(Person person) {
        this.person = person;
    }
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " prints " + person);
        }
    }
}