package entity;

import java.util.Objects;

public class Author {
    private String id;
    private String name;
    private char sex = 'M' | 'F';

    public Author(String id, String name, char sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    };

    public String getId() {
        return this.id;
    };

    public void setId(String id) {
        this.id = id;
    };

    public String getName() {
        return this.name;
    };

    public void setName(String name) {
        this.name = name;
    };

    public char getSex() {
        return this.sex;
    };

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString(){
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }

    @Override
     public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(sex, author.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex);
    }

}
