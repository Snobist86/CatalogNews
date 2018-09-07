package by.htp.task1.dao;

import by.htp.task1.criteria.Criteria;
import by.htp.task1.entity.News;
import by.htp.task1.exception.DAOException;

import java.util.List;

public interface CatalogDAO {

    List<News> find(Criteria criteria) throws DAOException;
    News add(Criteria criteria) throws DAOException;
}
