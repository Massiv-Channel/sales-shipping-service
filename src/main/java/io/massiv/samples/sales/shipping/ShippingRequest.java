package io.massiv.samples.sales.shipping;

/**
 *
 */
public class ShippingRequest {
    private String item;
    private int quantity;

    public ShippingRequest(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public ShippingRequest() {
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
