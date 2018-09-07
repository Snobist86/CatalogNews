package by.htp.task1.dao;

public final class FactoryDAO {

    private static final FactoryDAO instance = new FactoryDAO();

    private final CatalogDAO catalogDAO = new CatalogDAOImpl();

    private FactoryDAO() {}

    public CatalogDAO getCatalogDAO() {
        return catalogDAO;
    }

    public static FactoryDAO getInstance() {
        return instance;
    }

    private final XmlDAO xmlDAO = new XmlDAOImpl();

    public XmlDAO getXmlDAO() {
        return xmlDAO;
    }

}
