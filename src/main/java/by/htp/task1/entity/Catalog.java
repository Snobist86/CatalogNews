package by.htp.task1.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Catalog", propOrder = {"category"})

public class Catalog {

    @XmlElement
    protected List<Category> category;

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public List<Category> getCategory() {
        if (category == null) {
            category = new ArrayList<Category>();
        }
            return this.category;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Catalog catalog = (Catalog) o;
            return Objects.equals(category, catalog.category);
        }

        @Override
        public int hashCode() {

            return Objects.hash(super.hashCode(), category);
        }
    }




