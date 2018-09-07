package by.htp.task1.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "News", propOrder = {"newsName", "author", "date", "newsBody"})
public class News implements BaseEntity {

    @XmlElement
    private String newsName;
    @XmlElement
    private String author;
    @XmlElement
    private String date;
    @XmlElement
    private String newsBody;

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNewsBody() {
        return newsBody;
    }

    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
    }

    public News() {
    }

    @Override
    public String getName() {
        return newsName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        News news = (News) o;
        return Objects.equals(newsName, news.newsName) &&
                Objects.equals(author, news.author) &&
                Objects.equals(date, news.date) &&
                Objects.equals(newsBody, news.newsBody);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + (newsName == null ? 0 : newsName.hashCode()) * result;
        result = result * 31 + (author == null ? 0 : author.hashCode()) * result;
        result = result * 31 + (date == null ? 0 : date.hashCode()) * result;
        result = result * 31 + (newsBody == null ? 0 : newsBody.hashCode()) * result;
        return result;
    }

    @Override
    public String toString() {
        return "<news Name=\"" + newsName  + "\" Author=\"" + author + "\" DateOfIssue="+ date + "\">" +
                "\n\t<NewsBody>" + "\n\t\t" + newsBody + "\n\t</NewsBody>\n</news>\n" ;
    }
}