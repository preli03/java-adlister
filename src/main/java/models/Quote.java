package models;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.TypeVariable;

public class Quote {
    private int id;
    private String content;
    private Author author;

    // Getters and setters
    // ...

    @Override
    public String toString() {
        return "Quote [id=" + id + ", content=" + content + ", author=" + author + "]";
    }

    public void setId(int i) {

    }

    public void setAuthor(Author author1) {

    }

    public void setContent(String s) {

    }

    public String getContent() {
        return null;
    }

    public TypeVariable<GenericDeclaration> getAuthor() {
        return null;
    }
}
