package warehousepf;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Warehouse_table")
public class Warehouse {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String product;
    private Integer qty;

    @PostPersist
    public void onPostPersist(){
        InStock inStock = new InStock();
        BeanUtils.copyProperties(this, inStock);
        inStock.publish();

        Obsolete obsolete = new Obsolete();
        BeanUtils.copyProperties(this, obsolete);
        obsolete.publish();


    }

    @PostRemove
    public void onPostRemove(){
        Shipped shipped = new Shipped();
        BeanUtils.copyProperties(this, shipped);
        shipped.publish();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }




}
