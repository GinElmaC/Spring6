package com.GinElmaC.Bean;

public class OrderService {
    private OrderDao orderDao;

    public OrderService() {
    }

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generate(){
        orderDao.insert();
    }

    /**
     * 获取
     * @return orderDao
     */
    public OrderDao getOrderDao() {
        return orderDao;
    }

    /**
     * 设置
     * @param orderDao
     */
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public String toString() {
        return "OrderService{orderDao = " + orderDao + "}";
    }
}
