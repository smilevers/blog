package com.smile.po;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Author: smile
 * @Date: 2020/1/20
 */
@Table(name = "tb_comment")
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String email;
    /**
     * 头像
     */
    private String avatar;
    private String content;
    private Date createTime;
    private Long parentId;
    private Long blogId;
    private Boolean admin;
    
   
    @Transient
    private List<Comment> subComents;
    @Transient
    private Comment parentComment;
    
    
    public Boolean getAdmin() {
        return admin;
    }
    
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    
    public Long getParentId() {
        return parentId;
    }
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    public Long getBlogId() {
        return blogId;
    }
    
    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
    
    public List<Comment> getSubComents() {
        return subComents;
    }
    
    public void setSubComents(List<Comment> subComents) {
        this.subComents = subComents;
    }
    
    public Comment getParentComment() {
        return parentComment;
    }
    
    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNickname() {
        return nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAvatar() {
        return avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    
    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", parentId=" + parentId +
                ", blogId=" + blogId +
                ", admin=" + admin +
                ", subComents=" + subComents +
                ", parentComment=" + parentComment +
                '}';
    }
}
