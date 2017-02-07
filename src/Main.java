import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        AddStuff(session);

        String hql = "FROM Document";
        Query query = session.createQuery(hql);
        List results = query.list();

        System.out.println("\u001B[32m==========================================================================================================================================");

        for (Object docment: results) {
            System.out.println(docment);
        }

        System.out.println("\u001B[32m==========================================================================================================================================");
        session.close();
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

       Contract contract1 = new Contract(supplier1, 4312,lot1,lot2,lot3);
       Contract contract2 = new Contract(supplier1, 542,lot4);
       Contract contract3 = new Contract(supplier2, 43,lot5,lot6);
       Contract contract4 = new Contract(supplier3, 31,lot7,lot8);
       Contract contract5 = new Contract(supplier3, 431,lot9);

        Invoice invoice1 = new Invoice(contract1, 123);
        Invoice invoice2 = new Invoice(contract2, 123123);
        Invoice invoice3 = new Invoice(contract3, 12433);
        Invoice invoice4 = new Invoice(contract4, 1232);
        Invoice invoice5 = new Invoice(contract5, 1233);

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

        session.save(contract1);
        session.save(contract2);
        session.save(contract3);
        session.save(contract4);
        session.save(contract5);

        session.save(invoice1);
        session.save(invoice2);
        session.save(invoice3);
        session.save(invoice4);
        session.save(invoice5);

        session.getTransaction().commit();
    }
}

