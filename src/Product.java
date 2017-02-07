import javax.persistence.*;

@Entity
@Table(name="Product")
@Inheritance(strategy=InheritanceType.JOINED)
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int productId;

    @Column(name="product_name", unique = true, nullable = false)
    private String productName;

    @Column(name="product_prices")
    private int productPrice;

    public Product(String name, int price){
        productName = name;
        productPrice = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}
