package com.lichuandi.jdk8;

/**
 * @author digege
 * @date 2021/11/4 11:49
 * @description：TODO
 * @page com.lichuandi.jdk8
 * version：1
 */
public class ComplicatedDataHolder {
    public final String data;
    public final int num;

   /* public ComplicatedDataHolder(int num) {
        this.num = num;
    }
    public ComplicatedDataHolder(String data) {
        this.data = data;
    }*/

    public ComplicatedDataHolder(String data, int num) {
        this.data = data;
        this.num = num;
    }
    // lots more fields and a constructor

    public static class Builder {
        private String data;
        private int num;

        public Builder data(String data) {
            this.data = data;
            return this;
        }

        public Builder num(int num) {
            this.num = num;
            return this;
        }

        public ComplicatedDataHolder build() {
            return new ComplicatedDataHolder(data, num); // etc
        }
    }
}

// final ComplicatedDataHolder cdh = new ComplicatedDataHolder.Builder()
//    .data("set this")
//    .num(523)
//    .build();
