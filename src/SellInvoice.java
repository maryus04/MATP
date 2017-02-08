import javax.persistence.*;

@Entity
@Table(name="SellInvoice")
public class SellInvoice {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int invoiceID;

    @Column(name="date")
    private int date;

    @OneToOne
    @JoinColumn(name = "contract_id", unique = true, nullable = false)
    private SellContract buyContract;

    public SellInvoice(){}

    public SellInvoice(SellContract buyContract, int date) {
        this.buyContract = buyContract;
        this.date = date;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public SellContract getBuyContract() {
        return buyContract;
    }

    public void setBuyContract(SellContract buyContract) {
        this.buyContract = buyContract;
    }
}
