package entity;

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
}
