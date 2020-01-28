package com.smile.po;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: smile
 * @Date: 2020/1/20
 */
@Table(name = "tb_type")
public class Type {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 分类名称校验
     */
    private String name;
    
    @Transient
    private List<Blog> blogs;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<Blog> getBlogs() {
        return blogs;
    }
    
    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
    
    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}
