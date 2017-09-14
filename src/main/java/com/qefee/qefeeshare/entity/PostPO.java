package com.qefee.qefeeshare.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "post")
public class PostPO {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String title;

    private String content;

    private String type;

    private String ip;

    // ** 数据库中是authorId,这里要写成authorid，不然报错提示找不到author_id。下面同理
    @Column(name = "authorid")
    private Integer authorId;

    // ** from是关键字,所以需要用`包围起来
    @Column(name = "`from`")
    private String from;

    // ** status是关键字,所以需要用`包围起来
    @Column(name = "`status`")
    private String status;

    @Column(name = "createat")
    private Timestamp createAt;

    @Column(name = "modifyat")
    private Timestamp modifyAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(Timestamp modifyAt) {
        this.modifyAt = modifyAt;
    }
}
