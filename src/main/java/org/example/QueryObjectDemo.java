package org.example;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.example.HibernateUtils;
import org.example.entities.Client;

public class QueryObjectDemo {

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            // All the action with DB via Hibernate
            // must be located in one transaction.
            // Start Transaction.
            session.getTransaction().begin();

            // Create an HQL statement, query the object.
            // Equivalent to the SQL statement:
            // Select e.* from EMPLOYEE e order by e.EMP_NAME, e.EMP_NO
            String sql = "Select c.* from " + Client.class.getName() + " c "
                    + " order by c.CLI_NOM, c.CLI_NOM ";

            // Create Query object.
            Query<Client> query = session.createQuery(sql);

            // Execute query.
            List<Client> clients = query.getResultList();

            for (Client cli : clients) {
                System.out.println("Cli: " + cli.getNom() + " : "
                        + cli.getPrenom());
            }
            // Commit data.
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }

}