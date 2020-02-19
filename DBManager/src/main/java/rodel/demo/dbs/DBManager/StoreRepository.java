package rodel.demo.dbs.DBManager;

import org.springframework.stereotype.Repository;
import rodel.demo.dbs.DBManager.entity.CartProduct;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StoreRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public long save(CartProduct product) {
        if (product.getRecid()==0){
            entityManager.persist(product);
        } else {
            entityManager.merge(product);
        }

        return product.getRecid();
    }

    public CartProduct findById(int recid){
        return entityManager.find(CartProduct.class,recid);
    }


}
