package by.htp.task1.dao;

import by.htp.task1.entity.Catalog;
import by.htp.task1.exception.DAOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class JAXBInstance {
    private static JAXBContext instance;

    public static JAXBContext getInstance() throws DAOException {
        if (instance == null) {
            try {
                instance = JAXBContext.newInstance(Catalog.class);
            } catch (JAXBException e) {
                throw new DAOException("JAXB instance error");
            }
        }
        return instance;
    }
}
