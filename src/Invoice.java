import javax.persistence.*;

@Entity
@Table(name="Invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int invoiceID;

    @Column(name="date")
    private int date;

    @OneToOne
    @JoinColumn(name = "contract_id", unique = true, nullable = false)
    private Contract contract;

    public Invoice(Contract contract, int date) {
        this.contract = contract;
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

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
