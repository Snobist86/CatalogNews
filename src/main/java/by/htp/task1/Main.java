package by.htp.task1;


import by.htp.task1.criteria.Criteria;
import by.htp.task1.criteria.SearchNewsCriteria;

import by.htp.task1.entity.Catalog;
import by.htp.task1.entity.News;
import by.htp.task1.exception.ServiceException;
import by.htp.task1.service.CatalogService;
import by.htp.task1.service.FactoryService;
import by.htp.task1.service.XmlService;
import by.htp.task1.util.PrintNews;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //чтение/запись XML с помощью JAXB
        FactoryService factory = FactoryService.getInstance();
        XmlService xmlService = factory.getXmlService();
        Catalog catalog;
        try {
            catalog = xmlService.readXml();
            xmlService.saveXml(catalog);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

        CatalogService catalogService = factory.getCatalogService();

        //поиск по 2м критериям
        Criteria criteria = new Criteria();
        criteria.addCriteria(SearchNewsCriteria.News.NAME, "release of the video \"My Iceland\"");
        criteria.addCriteria(SearchNewsCriteria.News.AUTHOR, "Pankov Nikolas");
        List<News> news = null;
        try {
            news = catalogService.find(criteria);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        PrintNews.print(news);
        System.out.println();

        //поиск по категории
        Criteria criteria2 = new Criteria();
        criteria2.addCriteria(SearchNewsCriteria.News.CATEGORY_NAME, "Movie");
        List<News> news2 = null;
        try {
            news2 = catalogService.find(criteria2);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        PrintNews.print(news2);
        System.out.println();


        //добавление новости
        Criteria addNews = new Criteria();
        addNews.addCriteria(SearchNewsCriteria.News.NAME, "Something name");
        addNews.addCriteria(SearchNewsCriteria.News.AUTHOR, "Arnold S.");
        addNews.addCriteria(SearchNewsCriteria.News.DATE_OF_ISSUE, "2018-05-09");
        addNews.addCriteria(SearchNewsCriteria.News.NEWS_BODY, "I'll be back");
        addNews.addCriteria(SearchNewsCriteria.News.CATEGORY_NAME, "Movie");
        addNews.addCriteria(SearchNewsCriteria.News.SUBCATEGORY_NAME, "amateur");
        try {
            catalogService.add(addNews);
        } catch (ServiceException e) {
            throw new RuntimeException("Add news failed", e);
        }
        System.out.println("________________________________________________________________________________________");

        //добавление новости с "некорректной" категорией, категории добавлять нельзя (согласно условию таска)
        Criteria addNews2 = new Criteria();
        addNews2.addCriteria(SearchNewsCriteria.News.NAME, "Something name");
        addNews2.addCriteria(SearchNewsCriteria.News.AUTHOR, "Arnold S.");
        addNews2.addCriteria(SearchNewsCriteria.News.DATE_OF_ISSUE, "15.12.2018");
        addNews2.addCriteria(SearchNewsCriteria.News.NEWS_BODY, "I'll be back");
        addNews2.addCriteria(SearchNewsCriteria.News.CATEGORY_NAME, "Moviqqqqe");
        addNews2.addCriteria(SearchNewsCriteria.News.SUBCATEGORY_NAME, "amateur");
        try {
            catalogService.add(addNews2);
        } catch (ServiceException e) {
            throw new RuntimeException("Add news failed", e);
        }
    }
}