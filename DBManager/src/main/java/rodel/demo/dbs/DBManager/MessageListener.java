package rodel.demo.dbs.DBManager;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import rodel.demo.dbs.DBManager.entity.CartProduct;

@Component
public class MessageListener {
    @Autowired
    StoreRepository storeRepository;

    @JmsListener(destination = "${store.queue}")
    public void receivedMessage(String message){
        System.out.println(message);
        Gson gson = new Gson();
        CartProduct product = gson.fromJson(message,CartProduct.class);
        System.out.println("Cart Id:" + product.getCartid());
        System.out.println("Item No:" + product.getItemno());
        System.out.println("Detail:" + product.getDetails());
        System.out.println("Qty:" + product.getQty());
        System.out.println("Amount:" + product.getAmount());
        System.out.println ("Record ID Before Saving --> " + product.getRecid() );
        storeRepository.save(product);
        System.out.println("Record ID After Saving --> " + product.getRecid() );


    }






}
