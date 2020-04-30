package com.example.mvptest.entity;

/**
 * @author WangXiangDong
 * @date :2020/4/29
 */
public class PoetryEntity
{
    private String content;//诗歌内容
    private String origin;//来源
    private String author;//作者
    private String category;//分类

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getOrigin()
    {
        return origin;
    }

    public void setOrigin(String origin)
    {
        this.origin = origin;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }
}
