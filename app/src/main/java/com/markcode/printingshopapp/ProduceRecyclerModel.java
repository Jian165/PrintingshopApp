package com.markcode.printingshopapp;

public class ProduceRecyclerModel {
    Integer IconId;
    int OrderId;
    double PricerPerPeice;
    int OrderQuantity;

    public ProduceRecyclerModel(Integer iconId, int orderId, double pricerPerPeice, int orderQuantity) {
        IconId = iconId;
        OrderId = orderId;
        PricerPerPeice = pricerPerPeice;
        OrderQuantity = orderQuantity;
    }

    public Integer getIconId() {
        return IconId;
    }

    public void setIconId(Integer iconId) {
        IconId = iconId;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public double getPricerPerPeice() {
        return PricerPerPeice;
    }

    public void setPricerPerPeice(double pricerPerPeice) {
        PricerPerPeice = pricerPerPeice;
    }

    public int getOrderQuantity() {
        return OrderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        OrderQuantity = orderQuantity;
    }
}
