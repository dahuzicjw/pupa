package com.github.db.mongodb;

import com.alibaba.fastjson2.JSON;
import com.github.db.mongodb.dao.Book;
import com.github.db.mongodb.dao.Student;
import com.github.db.mongodb.dao.StudentDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * Created by 大胡子Kevin on 2016/5/29.
 */
@Configuration
@ComponentScan
public class SpringMongoDBApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringMongoDBApplication.class);
//        ConfigurableListableBeanFactory factory = context.getBeanFactory();
//        System.out.println(factory);
        StudentDao bean = context.getBean(StudentDao.class);
        Student student = new Student();
//        student.setId(1);
//        student.setName("kev");
//        List<Book> bookList = new ArrayList<>();
//        bookList.add(new Book(1,"x1"));
//        bookList.add(new Book(2,"x2"));
//        student.setBookList(bookList);
//        bean.insert(student);

//        Student byId = bean.mongoTemplate.findById(1, Student.class);
//        System.out.println(byId);
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(1));
        Student one = bean.mongoTemplate.findOne(query, Student.class);
        System.out.println(JSON.toJSON(one));
        Update update = new Update();
        update.push("bookList", new Book(3,"x33"));
        bean.mongoTemplate.updateFirst(query,update, Student.class);
    }

}
