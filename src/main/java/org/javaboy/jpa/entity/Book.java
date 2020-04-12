package org.javaboy.jpa.entity;


import javax.persistence.*;

// 指明实体类与数据库表映射关系
// 默认创建的表名与实体类名一样 ,加上 name="表名" 后,创建的表名是t_book
@Entity(name = "t_book")
public class Book {

    // 指明id是主键
    @Id
    // id是自增长
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 定义字段的详细属性
    // @Column()
    private String name;
    private String author;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
