package by.htp.task1.dao;

import by.htp.task1.exception.DAOException;
import by.htp.task1.entity.Catalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class XmlDAOImpl implements XmlDAO {

    @Override
    public Catalog readXml() throws DAOException {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Catalog.class);
        } catch (JAXBException e) {
            throw new DAOException("JAXBContext exception", e);
        }
        String xmlSource = System.getProperty("user.dir") + "/src/main/resources/Catalog.xml";
        Catalog catalog = null;
        Unmarshaller unmarshaller;
        try {
            unmarshaller = jaxbContext.createUnmarshaller();
            catalog = (Catalog) unmarshaller.unmarshal(new File(xmlSource));
        } catch (JAXBException e) {
            throw new DAOException("Unmarshaller error", e);
        }
        return catalog;
    }

    @Override
    public void saveXml(Catalog catalog) throws DAOException {
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(Catalog.class);
        } catch (JAXBException e) {
            throw new DAOException("JAXBContext exception", e);
        }
        String xmlTarget = System.getProperty("user.dir") + "/src/main/resources/Catalog.xml";
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            try (OutputStream outputStream = new FileOutputStream(xmlTarget)) {
                marshaller.marshal(catalog, outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            throw new DAOException("Marshaller error", e);
        }
    }
}