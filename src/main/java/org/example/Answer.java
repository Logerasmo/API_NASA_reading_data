package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {
    public String copyright;
    public String date;
    public String explanation;
    public String hdurl;
    public String media_type;
    public String service_version;
    public String title;
    public String url;
    @JsonCreator
    public Answer(@JsonProperty("copyright") String copyright,
                  @JsonProperty("date") String date,
                  @JsonProperty("explanation") String explanation,
                  @JsonProperty("hdurl") String hdurl,
                  @JsonProperty("service_version") String service_version,
                  @JsonProperty("media_type") String media_type,
                  @JsonProperty("title") String title,
                  @JsonProperty("url") String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.service_version = service_version;
        this.media_type = media_type;
        this.title = title;
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMedia_type() {
        return media_type;
    }

    public String getService_version() {
        return service_version;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "\ncopyright=\n-------" + copyright + "-------" +
                "\ndate='" + date + '\'' +
                "\nexplanation='" + explanation + '\'' +
                "\nhdurl='" + hdurl + '\'' +
                "\nmedia_type='" + media_type + '\'' +
                "\nservice_version='" + service_version + '\'' +
                "\ntitle='" + title + '\'' +
                "\nurl='" + url + '\'' +
                '}';
    }
}
