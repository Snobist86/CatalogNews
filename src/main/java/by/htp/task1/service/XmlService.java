package by.htp.task1.service;

import by.htp.task1.exception.ServiceException;
import by.htp.task1.entity.Catalog;

public interface XmlService {

    Catalog readXml() throws ServiceException;
    void saveXml(Catalog catalog) throws ServiceException;
}
