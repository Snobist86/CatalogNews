package by.htp.task1.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Category", propOrder = {"subCategory"})
public class Category implements BaseEntity {

    protected List<SubCategory> subCategory;

    @XmlAttribute(name = "Name")
    private String name;

    public Category() {}

    public void setSubCategory(List<SubCategory> subCategory) {
        this.subCategory = subCategory;
    }

    public List<SubCategory> getSubCategory() {
        if (subCategory == null) {
            subCategory = new ArrayList<SubCategory>();
        }
        return this.subCategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Category category = (Category) o;
        return Objects.equals(subCategory, category.subCategory) &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + (subCategory == null ? 0 : subCategory.hashCode()) * result;
        result = result * 31 + (name == null ? 0 : name.hashCode()) * result;
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                ", subCategory=" + subCategory +
                ", name='" + name + '\'' +
                '}';
    }
}
