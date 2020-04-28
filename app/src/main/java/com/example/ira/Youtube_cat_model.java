package com.example.ira;

public class Youtube_cat_model
{
    private String channelTitle;
    private String id;
    private String name;
    private String timing;
    private String title;
    private String url;

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String str)
    {
        this.title = str;
    }

    public String getChannelTitle()
    {
        return this.channelTitle;
    }

    public void setChannelTitle(String str)
    {
        this.channelTitle = str;
    }

    public String getUrl()
    {
        return this.url;
    }

    public void setUrl(String str)
    {
        this.url = str;
    }

    public String getTiming()
    {
        return this.timing;
    }

    public void setTiming(String str)
    {
        this.timing = str;
    }

    public Youtube_cat_model(String str, String str2)
    {
        this.name = str;
        this.id = str2;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String str)
    {
        this.name = str;
    }

    public String getId()
    {
        return this.id;
    }

    public void setId(String str)
    {
        this.id = str;
    }
}
