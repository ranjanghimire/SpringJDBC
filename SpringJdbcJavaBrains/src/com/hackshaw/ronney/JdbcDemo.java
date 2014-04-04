package com.hackshaw.ronney;

import com.hackshaw.ronney.dao.JdbcDaoImpl;
import com.hackshaw.ronney.model.Circle;

public class JdbcDemo {

    public static void main(String[] args) {
        Circle circle = new JdbcDaoImpl().getCircle(1);
        System.out.println(circle.getName());

    }

}
