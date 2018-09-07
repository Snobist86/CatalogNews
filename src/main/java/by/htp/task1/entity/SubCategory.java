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
@XmlType(name = "SubCategory", propOrder = {"news"})
public class SubCategory implements BaseEntity {

    protected List<News> news;

    @XmlAttribute(name = "Name")
    private String name;

    public List<News> getNews() {
        if (news == null) {
            news = new ArrayList<News>();
        }
        return this.news;
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
        SubCategory subCategory = (SubCategory) o;
        return Objects.equals(news, subCategory.news) &&
                Objects.equals(name, subCategory.name);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + (name == null ? 0 : name.hashCode()) * result;
        result = result * 31 + (news == null ? 0 : news.hashCode()) * result;
        return result;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                ", news=" + news +
                ", name='" + name + '\'' +
                '}';
    }
}
