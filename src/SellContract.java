import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="SellContract")
public class SellContract {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int contractID;

    @Column(name="date")
    private int date;

    @Column(name="shipping_date")
    private int shippingDate;

    @Column(name="shipping_status")
    private String shippingStatus;

    @Column(name="addtitional_data")
    private String additionalData;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SellContract_lot", joinColumns = { @JoinColumn(name = "sell_contract_id") }, inverseJoinColumns = { @JoinColumn(name = "lot_id") })
    private Set<Lot> lotsList = new HashSet<Lot>(0);

    @ManyToOne(cascade=CascadeType.ALL)
    private Client client;

    public SellContract(){}

    public SellContract(Client client,int date, int shipping_date, Lot... lotList ){
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }
}
