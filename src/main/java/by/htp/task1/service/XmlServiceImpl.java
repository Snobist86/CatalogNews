package by.htp.task1.service;

import by.htp.task1.dao.FactoryDAO;
import by.htp.task1.exception.DAOException;
import by.htp.task1.exception.ServiceException;
import by.htp.task1.dao.XmlDAO;
import by.htp.task1.entity.Catalog;

public class XmlServiceImpl implements XmlService {

    @Override
    public Catalog readXml() throws ServiceException {
        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        XmlDAO xmlDAO = factoryDAO.getXmlDAO();
        Catalog catalog = null;
        try {
            catalog = xmlDAO.readXml();
        } catch (DAOException e) {
            throw new ServiceException("Read xml Jaxb Exception", e);
        }
        return catalog;
    }

    @Override
    public void saveXml(Catalog catalog) throws ServiceException {
        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        XmlDAO jaxbDAO = factoryDAO.getXmlDAO();
        try {
            jaxbDAO.saveXml(catalog);
            System.out.println("Changes in Catalog.xml saved");
        } catch (DAOException e) {
            throw new ServiceException("Save xml Jaxb Exception", e);
        }
    }
}
