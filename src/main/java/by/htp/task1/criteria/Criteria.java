package by.htp.task1.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

        private Map<SearchNewsCriteria.News, Object> criteria = new HashMap<>();

        public Map<SearchNewsCriteria.News, Object> getCriteria() {
            return criteria;
        }

        public void addCriteria(SearchNewsCriteria.News searchCriteria, Object value) {
            criteria.put(searchCriteria, value);
        }

    public Criteria() {
    }
}