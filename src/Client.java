import javax.persistence.*;

@Entity
@Table(name="Client")
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int clientId;

    @Column(name="client_name")
    private String name;

    @Column(name="client_surname")
    private String surname;

    @Column(name="client_address")
    private String address;

    public Client (){}

    public Client (String name,String surname, String address){
        this.name=name;
        this.surname=surname;
        this.address=address;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
