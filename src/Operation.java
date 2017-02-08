import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

public final class Operation {

    static SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    static Session session = sessionFactory.openSession();

    public enum DATA_TYPES {
        CLIENT { public String toString() { return "Client"; } },
        BUYCONTRACT { public String toString() { return "BUYCONTRACT"; } },
        BUYINVOICE{ public String toString() { return "BUYINVOICE"; } },
        LOT {public String toString() { return "LOT"; } },
        PRODUCT {public String toString() {return "PRODUCT";}},
        SELLCONTRACT {public String toString() {return "SELLCONTRACT";}},
        SELLINVOICE {public String toString() {return "SELLINVOICE";}},
        SUPPLIER { public String toString() {return "SUPPLIER";}};
    }


    public static void Insert(Object data){
        session.save(data);
        session.getTransaction().commit();
    }

    public static List<Object> Get(DATA_TYPES data_types){
        String hql = "FROM " + data_types;
        Query query = session.createQuery(hql);
        return query.list();
    }
}
