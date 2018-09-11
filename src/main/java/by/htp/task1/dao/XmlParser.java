package by.htp.task1.dao;

import by.htp.task1.entity.Catalog;
import by.htp.task1.exception.DAOException;

public interface XmlParser {

    Catalog readXml() throws DAOException;
    void saveXml(Catalog catalog) throws DAOException;
}
