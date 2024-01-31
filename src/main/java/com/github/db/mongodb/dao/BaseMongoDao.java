package com.github.db.mongodb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by Kevin on 2016/5/29.
 */
public class BaseMongoDao<T> {

    @Autowired
    public MongoTemplate mongoTemplate;

    /**
     * 保存一个对象
     *
     * @author <a href='mailto:dennisit@163.com'>Cn.苏若年(En.dennisit)</a> Copy Right since 2013-10-13 下午03:37:28
     *
     * @param t
     * @return
     */
    public void save(T t){
        this.mongoTemplate.save(t);
    }

    public void insert(T t) {
        mongoTemplate.insert(t);
    }


}
