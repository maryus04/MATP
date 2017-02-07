import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Contract")
public class Contract {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int contractID;

    @Column(name="shipping_date")
    private int shippingDate;

    @Column(name="addtitional_data")
    private String additionalData;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Contract_lot", joinColumns = { @JoinColumn(name = "contract_id") }, inverseJoinColumns = { @JoinColumn(name = "lot_id") })
    private Set<Lot> lotsList = new HashSet<Lot>(0);

    @ManyToOne(cascade=CascadeType.ALL)
    private Supplier supplier;

    public Contract(Supplier supplier, int shipping_date, Lot... lotList ){
        this.supplier = supplier;
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
}
