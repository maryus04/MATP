import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {
    public static void main(String[] args) {
        List results = Operation.Get(Operation.DATA_TYPES.CLIENT);

        System.out.println("\u001B[32m==========================================================================================================================================");

        for (Object docment: results) {
            System.out.println(((Client)docment).getName());
        }

        System.out.println("\u001B[32m==========================================================================================================================================");
    }

    private static void AddStuff(Session session){

        Supplier supplier1 = new Supplier("Turmechistan SRL");
        Supplier supplier2 = new Supplier("NAV MONOTONO SRL");
        Supplier supplier3 = new Supplier("RO FARFRUIDI SRL");

        Product product1 = new Product("Sarmalute" , 1);
        Product product2 = new Product("Castane" , 3);
        Product product3 = new Product("Ciorba" , 13);
        Product product4 = new Product("Paine" , 1);
        Product product5 = new Product("Ficati" , 145);
        Product product6 = new Product("Dan" , 18);

        Lot lot1 = new Lot(product1, 13);
        Lot lot2 = new Lot(product1, 55);  // CONTRACT 1
        Lot lot3 = new Lot(product1, 123);

        Lot lot4 = new Lot(product2, 32);  // CONTRACT 2

        Lot lot5 = new Lot(product3, 56);
        Lot lot6 = new Lot(product4, 87);  // CONTRACT 3

        Lot lot7 = new Lot(product5, 24);
        Lot lot8 = new Lot(product6, 78);  // CONTRACT 4

        Lot lot9 = new Lot(product6, 59);  // CONTRACT 5

       BuyContract buyContract1 = new BuyContract(supplier1,12, 4312,lot1,lot2,lot3);
       BuyContract buyContract2 = new BuyContract(supplier1,32, 542,lot4);
       BuyContract buyContract3 = new BuyContract(supplier2,43, 43,lot5,lot6);
       BuyContract buyContract4 = new BuyContract(supplier3,54, 31,lot7,lot8);
       BuyContract buyContract5 = new BuyContract(supplier3,12, 431,lot9);

        BuyInvoice buyInvoice1 = new BuyInvoice(buyContract1, 123);
        BuyInvoice buyInvoice2 = new BuyInvoice(buyContract2, 123123);
        BuyInvoice buyInvoice3 = new BuyInvoice(buyContract3, 12433);
        BuyInvoice buyInvoice4 = new BuyInvoice(buyContract4, 1232);
        BuyInvoice buyInvoice5 = new BuyInvoice(buyContract5, 1233);

        Client client1 = new Client("Tanti", "Pachita", "strada garii");
        Client client2 = new Client("Caramida", "Plictisita", "strada viitorului");

        SellContract contract1 = new SellContract(client1,12,243,lot1,lot2);
        SellContract contract2 = new SellContract(client2,132,2443,lot3,lot7);

        session.beginTransaction();

        session.save(supplier1);
        session.save(supplier2);
        session.save(supplier3);

        session.save(product1);
        session.save(product2);
        session.save(product3);
        session.save(product4);
        session.save(product5);
        session.save(product6);

        session.save(lot1);
        session.save(lot2);
        session.save(lot3);
        session.save(lot4);
        session.save(lot5);
        session.save(lot6);
        session.save(lot7);
        session.save(lot8);
        session.save(lot9);

        session.save(buyContract1);
        session.save(buyContract2);
        session.save(buyContract3);
        session.save(buyContract4);
        session.save(buyContract5);

        session.save(buyInvoice1);
        session.save(buyInvoice2);
        session.save(buyInvoice3);
        session.save(buyInvoice4);
        session.save(buyInvoice5);

        session.save(client1);
        session.save(client2);

        session.save(contract1);
        session.save(contract2);

        session.getTransaction().commit();
    }
}

