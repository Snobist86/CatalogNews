package by.htp.task1.service;

public final class FactoryService {

    private static final FactoryService instance = new FactoryService();

    private final CatalogService catalogService = new CatalogServiceImpl();

    private FactoryService() {
    }

    public CatalogService getCatalogService() {
        return catalogService;
    }

    public static FactoryService getInstance() {
        return instance;
    }

    private final XmlService xmlService = new XmlServiceImpl();

    public XmlService getXmlService() {return xmlService;}
}


