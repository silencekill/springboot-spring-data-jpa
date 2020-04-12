package org.javaboy.jpa;

import org.javaboy.jpa.dao.BookDao;
import org.javaboy.jpa.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class JpaApplicationTests {
    @Autowired
    BookDao bookDao;
    @Test
    void contextLoads() {
        Book book = new Book();
        book.setName("资治通鉴");
        book.setAuthor("司马光");
        bookDao.save(book);
    }

    @Test
    void update(){
        Book book = new Book();
        book.setId(2);
        book.setName("资治通");
        book.setAuthor("司马");
        // 此方法如果数据库有这条数据(根据主键判断),就会进行更新,否则进行修改
        // 看控制台sql:先执行查询,根据结果再进行修改或者新增
        bookDao.saveAndFlush(book);
    }

    // 分页查询
    @Test
    void test1(){
        PageRequest pageable = PageRequest.of(0, 2);
        Page<Book> page = bookDao.findAll(pageable);
        // 总记录数
        page.getTotalElements();
        // 总页数
        page.getTotalPages();
        // 获取的数据库数据
        page.getContent();
        // 每页多少条
        page.getSize();
        // 当前页(从0开始)
        page.getNumber();
        // 当前页的数据条数
        page.getNumberOfElements();
        // 是否是第一页
        page.isFirst();
        // 是否是最后一页
        page.isLast();
    }

}
