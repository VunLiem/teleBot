package DAO;

import entity.SaleTransEntity;
import org.hibernate.Session;
import org.jfree.data.category.DefaultCategoryDataset;
import utils.HibernateUtils;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import java.util.List;

public class SaleTransDAO {
    static public void saveSaleTrans(SaleTransEntity saleTrans) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.getTransaction();
            session.save(saleTrans);
            session.flush();
            session.clear();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            session.getTransaction().commit();
        }
    }
    static public DefaultCategoryDataset getALlSaleTrans1(DefaultCategoryDataset dataset1) {
        try {
            System.out.println("==================");
            Session session = HibernateUtils.getSessionFactory().openSession();

            String sql = "select sum(amountNotTax), day(saleTransDate), month(saleTransDate) " +
                    "FROM SaleTransEntity WHERE saleTransType = '89' " +
                    "group by saleTransDate order by saleTransDate asc";

            TypedQuery<Tuple> query = session.createQuery(sql, Tuple.class);
            List<Tuple> sum = query.getResultList();
            String title = "Graph of amount not tax";
            int count = 0;
            for (Tuple t : sum) {
                System.out.println("Sum: " + t.get(0) + " | Date: " + t.get(1) + "/" + t.get(2));
                dataset1.addValue((Double) t.get(0), title , t.get(1) + "/" + t.get(2) );
                count++;
                if (count == 14) break;
            }
            return dataset1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    static public DefaultCategoryDataset getALlSaleTrans2(DefaultCategoryDataset dataset2) {

        try {
            System.out.println("==================");
            Session session = HibernateUtils.getSessionFactory().openSession();
            String sql = "select sum(amountTax), day(saleTransDate), month(saleTransDate) " +
                    "FROM SaleTransEntity WHERE saleTransType = '89' " +
                    "group by saleTransDate order by saleTransDate asc";

            TypedQuery<Tuple> query2 = session.createQuery(sql, Tuple.class);
            List<Tuple> sum2 = query2.getResultList();
            String title = "Graph of amount tax";
            int count = 0;
            for (Tuple t2 : sum2) {
                System.out.println("Sum: " + t2.get(0) + " | Date: " + t2.get(1) + "/" + t2.get(2));
                dataset2.addValue((Double) t2.get(0), title , t2.get(1) + "/" + t2.get(2) );

                count++;
                if (count == 14) break;
            }
            return dataset2;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
