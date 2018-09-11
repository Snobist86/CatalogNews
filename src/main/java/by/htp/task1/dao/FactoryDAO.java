package by.htp.task1.dao;

public final class FactoryDAO {

    private static final FactoryDAO instance = new FactoryDAO();

    private final CatalogDAO catalogDAO = new CatalogDAOImpl();

    private FactoryDAO() {}

    public static FactoryDAO getInstance() {
        return instance;
    }

    public CatalogDAO getCatalogDAO() {
        return catalogDAO;
    }

    private final XmlParser xmlParser = new XmlParserImpl();

    public XmlParser getXmlParser() {
        return xmlParser;
    }

}