package com.smile.po;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Table(name = "tb_blog")
public class Blog implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String content;
  private String firstPicture;
  private String flag;
  private Integer views;
  private Boolean appreciation;
  private Boolean shareStatement;
  private Boolean commnetable;
  private Boolean published;
  private Boolean recommend;
  private Date createTime;
  private Date updateTime;
  private Long typeId;
  private Long userId;
  private String description;
  
  @Transient
  private List<Tag> tagList;
  @Transient
  private String tagStr;
  @Transient
  private Long[] tags;
  @Transient
  private User user;
  @Transient
  private Type type;
  @Transient
  private List<Comment> commentList;
  
  
  
  public String getTagStr() {
    return tagStr;
  }
  
  public void setTagStr(String tagStr) {
    this.tagStr = tagStr;
  }
  
  public Long getUserId() {
      return userId;
  }
  
  public void setUserId(Long userId) {
      this.userId = userId;
  }
  
  public List<Tag> getTagList() {
    return tagList;
  }
  
  public void setTagList(List<Tag> tagList) {
    this.tagList = tagList;
  }
  
  public User getUser() {
    return user;
  }
  
  public void setUser(User user) {
    this.user = user;
  }
  
  public Long[] getTags() {
    return tags;
  }
  
  public void setTags(Long[] tags) {
    this.tags = tags;
  }
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getContent() {
    return content;
  }
  
  public void setContent(String content) {
    this.content = content;
  }
  
  public String getFirstPicture() {
    return firstPicture;
  }
  
  public void setFirstPicture(String firstPicture) {
    this.firstPicture = firstPicture;
  }
  
  public String getFlag() {
    return flag;
  }
  
  public void setFlag(String flag) {
    this.flag = flag;
  }
  
  public Integer getViews() {
    return views;
  }
  
  public void setViews(Integer views) {
    this.views = views;
  }
  
  public Boolean getAppreciation() {
    return appreciation;
  }
  
  public void setAppreciation(Boolean appreciation) {
    this.appreciation = appreciation;
  }
  
  public Boolean getShareStatement() {
    return shareStatement;
  }
  
  public void setShareStatement(Boolean shareStatement) {
    this.shareStatement = shareStatement;
  }
  
  public Boolean getCommnetable() {
    return commnetable;
  }
  
  public void setCommnetable(Boolean commnetable) {
    this.commnetable = commnetable;
  }
  
  public Boolean getPublished() {
    return published;
  }
  
  public void setPublished(Boolean published) {
    this.published = published;
  }
  
  public Boolean getRecommend() {
    return recommend;
  }
  
  public void setRecommend(Boolean recommend) {
    this.recommend = recommend;
  }
  
  public Date getCreateTime() {
    return createTime;
  }
  
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
  
  public Date getUpdateTime() {
    return updateTime;
  }
  
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
  
  public Long getTypeId() {
    return typeId;
  }
  
  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }
  
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  
  public Type getType() {
    return type;
  }
  
  public void setType(Type type) {
    this.type = type;
  }
  
  

}
