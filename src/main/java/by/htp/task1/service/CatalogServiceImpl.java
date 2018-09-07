package by.htp.task1.service;

import by.htp.task1.criteria.Criteria;
import by.htp.task1.dao.CatalogDAO;
import by.htp.task1.dao.FactoryDAO;
import by.htp.task1.entity.News;
import by.htp.task1.exception.DAOException;
import by.htp.task1.exception.ServiceException;

import java.util.List;

public class CatalogServiceImpl implements CatalogService {

    @Override
    public List<News> find(Criteria criteria) throws ServiceException {
        if (!Validator.criteriaValidator(criteria)) {
            System.out.println("The entered data does not correspond to the format");
            return null;
        }

        FactoryDAO factory = FactoryDAO.getInstance();
        CatalogDAO catalogDAO = factory.getCatalogDAO();

        List<News> news = null;
        try {
            news = catalogDAO.find(criteria);
        } catch (DAOException e) {
            throw new ServiceException("Find operation in xml throw catalogDAO ending with Exception", e);
        }
        return news;
    }

    @Override
    public News add(Criteria criteria) throws ServiceException {
        if (!Validator.criteriaValidator(criteria)) {
            System.out.println("The entered data does not correspond to the format");
            return null;
        }
        FactoryDAO factory = FactoryDAO.getInstance();
        CatalogDAO catalogDAO = factory.getCatalogDAO();

        News news = null;
        try {
            news = catalogDAO.add(criteria);
        } catch (DAOException e) {
            throw new ServiceException("Add operation to xml throw catalogDAO ending with Exception", e);
        }
        if (news == null) {
            System.out.println("There are not enough criteria for a specific add-on");
            return null;
        }
        return news;
    }
}
