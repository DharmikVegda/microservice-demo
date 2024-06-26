package com.example.securityservice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

interface Sayble{
    void say();
}
public class Main {

    public Main(){
        System.out.println("Hello world!!!!!");
    }
    public void saySomething(){
        System.out.println("Hello world!!");
    }
    public static void main(String[] args) {
        String[] names = {"first","second","third"};
        Deque<String> deque = new ArrayDeque<>(Arrays.asList(names));
        deque.poll();
        System.out.println(deque);
    }
}
