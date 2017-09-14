package com.qefee.qefeeshare.entity.dobj;

import com.qefee.qefeeshare.entity.PostPO;

public class PostDO {
    private Integer id;

    private String title;

    private String content;

    private String type;

    private Integer authorId;

    private String from;

    private String status;

    public PostDO(PostPO po) {
        this.id = po.getId();
        this.title = po.getTitle();
        this.content = po.getContent();
        this.type = po.getType();
        this.authorId = po.getAuthorId();
        this.from = po.getFrom();
        this.status = po.getStatus();
    }

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
}
