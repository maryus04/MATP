import javax.persistence.*;

@Entity
@Table(name="Supplier")
@Inheritance(strategy=InheritanceType.JOINED)
public class Supplier {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int supplierID;

    @Column(name="supplier_name")
    private String supplierName;

    public Supplier(){}

    public Supplier(String name){
        supplierName = name;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
