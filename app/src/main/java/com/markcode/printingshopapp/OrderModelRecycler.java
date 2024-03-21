package com.markcode.printingshopapp;

public class OrderModelRecycler {
    private Integer OrderID;
    private String OrderType;
    private Double OrderPricePerPiece;
    private  Integer OrderQuantity;
    private int ImgOrderImage;


    public OrderModelRecycler(Integer orderID, String orderType, Double orderPricePerPiece, Integer orderQuantity, int imgOrderImage) {
        OrderID = orderID;
        OrderType = orderType;
        OrderPricePerPiece = orderPricePerPiece;
        OrderQuantity = orderQuantity;
        ImgOrderImage = imgOrderImage;
    }

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer orderID) {
        OrderID = orderID;
    }

    public void setOrderPricePerPiece(Double orderPricePerPiece) {
        OrderPricePerPiece = orderPricePerPiece;
    }

    public int getImgOrderImage() {
        return ImgOrderImage;
    }

    public void setImgOrderImage(int imgOrderImage) {
        ImgOrderImage = imgOrderImage;
    }


    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String orderType) {
        OrderType = orderType;
    }

    public  Double getOrderPricePerPiece() {
        return OrderPricePerPiece;
    }

    public void setOrderPricePerPiece(double orderPricePerPiece) {
        OrderPricePerPiece = orderPricePerPiece;
    }

    public Integer getOrderQuantity() {
        return OrderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        OrderQuantity = orderQuantity;
    }
}
