/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.tracom.main;

/**
 *
 * @author kelvin * DB encapsulate some housekepping specific to Hibernate O/R
 * mapping engine
 */
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class DB {

    protected static SessionFactory sf;
    protected static SessionFactory sf_SQL;
    protected static Configuration cfg;
    protected static Configuration cfg_SQL;
    Session session;
    Session session_SQL;

    static {
        try {
            init();
        } catch (Exception e) {
            // now we're in deep trouble
            e.printStackTrace();
        }
    }

    public DB() {
        super();
    }

    private static void init() throws HibernateException {
        synchronized (DB.class) {
            if (cfg != null) {
                return;
            }

            cfg = new Configuration().configure("conf/hibernate.cfg.xml");

            sf = cfg.buildSessionFactory();
        }
    }

    /**
     * @return Hibernate's session factory
     */
    public SessionFactory getSessionFactory() {
        return sf;
    }

    /**
     * Creates database schema
     *
     * @param outputFile optional output file (may be null)
     * @param create true to actually issue the create statements
     */
    public void createSchema(String outputFile, boolean create)
            throws HibernateException {
        SchemaExport export = new SchemaExport(cfg);
        if (outputFile != null) {
            export.setOutputFile(outputFile);
            export.setDelimiter(";");
        }
        export.create(true, create);
    }

    /**
     * open a new HibernateSession if none exists
     *
     * @throws HibernateException
     * @return HibernateSession associated with this DB object
     */
    public synchronized Session open() throws HibernateException {
        if (session == null) {
            session = sf.openSession();
        }
        return session;
    }

    /**
     * close hibernate session
     *
     * @throws HibernateException
     */
    public synchronized void close() throws HibernateException {
        if (session != null) {
            session.close();
            session = null;
        }
    }

    /**
     * @return session hibernate Session
     */
    public Session session() {
        return session;
    }

    /**
     * handy method used to avoid having to call db.session().save (xxx)
     *
     * @param obj to save
     */
    public void save(Object obj) throws HibernateException {
        session.save(obj);
    }

    /**
     * @return newly created Transaction
     * @throws HibernateException
     */
    public synchronized Transaction beginTransaction()
            throws HibernateException {
        return session.beginTransaction();
    }

    /**
     * @param timeout in seconds
     * @return newly created Transaction
     * @throws HibernateException
     */
    public synchronized Transaction beginTransaction(int timeout)
            throws HibernateException {
        Transaction tx = session.beginTransaction();
        if (timeout > 0) {
            tx.setTimeout(timeout);
        }
        return tx;
    }
}
