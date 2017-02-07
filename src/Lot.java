import javax.persistence.*;

@Entity
@Table(name="Lot")
public class Lot {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int lotID;

    @Column(name="quantity")
    private int quantity;

    @Column(name="transaction_status")
    private String transactionStatus;

    @ManyToOne(cascade=CascadeType.ALL)
    private Product product;

    public Lot(Product product, int quant){
        this.product = product;
        quantity = quant;
    }

    public int getLotID() {
        return lotID;
    }

    public void setLotID(int lotID) {
        this.lotID = lotID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
