package by.htp.task1.service;

import by.htp.task1.criteria.Criteria;
import by.htp.task1.criteria.SearchNewsCriteria;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean criteriaValidator(Criteria criteria) {
        String regex;
        for (Map.Entry<SearchNewsCriteria.News, Object> c :
                criteria.getCriteria().entrySet()) {
            switch (c.getKey()) {
                case NAME:
                    regex = "([A-Za-zА-Яа-яЁё\\w\\s\\p{P}\\p{S}]+)";
                    if (!reg(regex, (String) c.getValue())) {
                        return false;
                    }
                    break;
                case AUTHOR:
                    regex = "([A-Za-zА-Яа-яЁё\\s.-]+)";
                    if (!reg(regex, (String) c.getValue())) {
                        return false;
                    }
                    break;
                case NEWS_BODY:
                    regex = "([A-Za-zА-Яа-яЁё\\w\\s\\p{P}\\p{S}]+)";
                    if (!reg(regex, (String) c.getValue())) {
                        return false;
                    }
                    break;
                case DATE_OF_ISSUE:
                    //нужна серьезная проверка на 1-31 (1-31, 1-28, 1-29), 1-12 + не заднее число
                    regex = "(\\d{4}[.|-]\\d{2}[|.-]\\d{2})";
                    if (!reg(regex, (String) c.getValue())) {
                        return false;
                    }
                    break;
                case CATEGORY_NAME:
                    regex = "([A-Za-zА-Яа-яЁё\\s]+)";
                    if (!reg(regex, (String) c.getValue())) {
                        return false;
                    }
                    break;
                case SUBCATEGORY_NAME:
                    regex = "([A-Za-zА-Яа-яЁё\\s]+)";
                    if (!reg(regex, (String) c.getValue())) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }

        return true;

    }

    public static boolean reg(String regex, String parameter) {
        return (parameter.matches(regex));
    }
}