package by.htp.task1.service;

import by.htp.task1.dao.FactoryDAO;
import by.htp.task1.exception.DAOException;
import by.htp.task1.exception.ServiceException;
import by.htp.task1.dao.XmlParser;
import by.htp.task1.entity.Catalog;

public class XmlServiceImpl implements XmlService {

    @Override
    public Catalog readXml() throws ServiceException {
        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        XmlParser xmlParser = factoryDAO.getXmlParser();
        Catalog catalog = null;
        try {
            catalog = xmlParser.readXml();
        } catch (DAOException e) {
            throw new ServiceException("Read xml Jaxb Exception", e);
        }
        return catalog;
    }

    @Override
    public void saveXml(Catalog catalog) throws ServiceException {
        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        XmlParser jaxbDAO = factoryDAO.getXmlParser();
        try {
            jaxbDAO.saveXml(catalog);
            System.out.println("Changes in Catalog.xml saved");
        } catch (DAOException e) {
            throw new ServiceException("Save xml Jaxb Exception", e);
        }
    }
}
