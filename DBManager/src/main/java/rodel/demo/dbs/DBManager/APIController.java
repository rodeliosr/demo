package rodel.demo.dbs.DBManager;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rodel.demo.dbs.DBManager.entity.CartProduct;

@RestController
@RequestMapping("api/v1")
public class APIController {

    @Autowired
    private StoreRepository storeRepository;


    @GetMapping("/getSampleProduct")
    public CartProduct getSampleCard(){
        CartProduct product = new CartProduct(1,1001,"BAG",10, 100.00);

        return product;

    }

}
