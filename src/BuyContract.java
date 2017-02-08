import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="BuyContract")
public class BuyContract {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int contractID;

    @Column(name="date")
    private int date;

    @Column(name="shipping_date")
    private int shippingDate;

    @Column(name="addtitional_data")
    private String additionalData;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "BuyContract_lot", joinColumns = { @JoinColumn(name = "buy_contract_id") }, inverseJoinColumns = { @JoinColumn(name = "lot_id") })
    private Set<Lot> lotsList = new HashSet<Lot>(0);

    @ManyToOne(cascade=CascadeType.ALL)
    private Supplier supplier;

    public BuyContract(){}

    public BuyContract(Supplier supplier, int date, int shipping_date, Lot... lotList ){
        this.supplier = supplier;
        this.date = date;
        shippingDate = shipping_date;
        HashSet set1 = new HashSet();
        for (Lot lot :
                lotList) {
            set1.add(lot);
        }
        lotsList = set1;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public int getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(int shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Set<Lot> getLotsList() {
        return lotsList;
    }

    public void setLotsList(Set<Lot> lotsList) {
        this.lotsList = lotsList;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
