package warehousepf;

public class Obsolete extends AbstractEvent {

    private Long id;
    private String product;
    private Integer qty;

    public Obsolete(){
        super();
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

    public void publish() {
    }
}
