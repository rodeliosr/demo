package rodel.demo.dbs.DBManager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CartProduct {



    @Id
    @GeneratedValue
    private int recid;


    private long cartid;
    private int itemno;
    private String details;
    private int qty;
    private double amount;

    public CartProduct() {
    }

    public CartProduct(long cartid, int itemno, String details, int qty, double amount) {
        this.cartid = cartid;
        this.itemno = itemno;
        this.details = details;
        this.qty = qty;
        this.amount = amount;
    }

    public int getRecid() {
        return recid;
    }

    public long getCartid() {
        return cartid;
    }

    public int getItemno() {
        return itemno;
    }

    public String getDetails() {
        return details;
    }

    public int getQty() {
        return qty;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "CartProduct{" +
                "recid=" + recid +
                ", cartid=" + cartid +
                ", itemno=" + itemno +
                ", details='" + details + '\'' +
                ", qty=" + qty +
                ", amount=" + amount +
                '}';
    }
}
