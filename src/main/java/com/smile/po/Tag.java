package com.smile.po;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: smile
 * @Date: 2020/1/20
 */
@Table(name = "tb_tag")
public class Tag {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @Transient
    private List<Blog> blogs;
    
    public List<Blog> getBlogs() {
        return blogs;
    }
    
    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
    
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
    
    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
