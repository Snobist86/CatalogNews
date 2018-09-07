package by.htp.task1.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class XmlElementNewsFactory {

    private final static QName Catalog_QNAME = new QName("http://task1.htp.by", "catalog");

    public XmlElementNewsFactory() {
    }

    public Catalog createCatalog() {
        return new Catalog();
    }

    public Category createCategory() {
        return new Category();
    }

    public SubCategory createSubCategory() {
        return new SubCategory();
    }

    public News createNews() { return new News(); }

//    public Author createAuthor() { return new Author(); }



    @XmlElementDecl(namespace = "http://task1.htp.by", name = "catalog")
    public JAXBElement<Catalog> createCatalog(Catalog value) {
        return new JAXBElement<>(Catalog_QNAME, Catalog.class, null, value);
    }
}
