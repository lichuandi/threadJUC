package com.lichuandi.atomic;

/**
 * @Auther digege
 * @Date 2021/1/13
 * @Description：com.lichuandi.atomic version：1
 */
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {

    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater
            .newUpdater(User.class, "old");

    public static void main(String[] args) {
        User conan = new User("conan", 10);
        System.out.println(a.getAndIncrement(conan));
        System.out.println(a.get(conan));
    }

    public static class User {
        private String name;
        //注意需要用volatile修饰
        public volatile int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }
}