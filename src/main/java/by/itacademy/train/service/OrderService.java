package by.itacademy.train.service;

import by.itacademy.train.entity.Carriage;
import by.itacademy.train.entity.Order;

public interface OrderService {
    String generateBill(Order order);

    int calculateTotalPrice(Order order);

    void addCarriage(Carriage carriage, Order order);

    void deleteCarriage(Carriage carriage, Order order);
}