package by.htp.task1.service;

import by.htp.task1.criteria.Criteria;
import by.htp.task1.entity.News;
import by.htp.task1.exception.ServiceException;

import java.util.List;

public interface CatalogService {

    List<News> find(Criteria criteria) throws ServiceException;
    News add(Criteria criteria) throws ServiceException;
}
