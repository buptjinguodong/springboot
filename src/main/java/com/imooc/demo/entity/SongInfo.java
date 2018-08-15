package com.imooc.demo.entity;

import java.util.Date;

public class SongInfo {

    private Integer songId;

    private Integer songerId;

    private String songWord;

    private Date createTime;

    private Date updateTime;

    private String songTitle;

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getSongerId() {
        return songerId;
    }

    public void setSongerId(Integer songerId) {
        this.songerId = songerId;
    }

    public String getSongWord() {
        return songWord;
    }

    public void setSongWord(String songWord) {
        this.songWord = songWord;
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
}
