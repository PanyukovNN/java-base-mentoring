package ru.panyukovnn.javabasementoring.serialization;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CreateShortLinkResponse implements Serializable {

    private String link;
    private LocalDateTime endTime;
    private String description;
    private Boolean active;

    public CreateShortLinkResponse() {
    }

    public CreateShortLinkResponse(String link, LocalDateTime endTime, String description, Boolean active) {
        this.link = link;
        this.endTime = endTime;
        this.description = description;
        this.active = active;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CreateShortLinkRequest{" +
            "link='" + link + '\'' +
            ", endTime=" + endTime +
            ", description='" + description + '\'' +
            ", active=" + active +
            '}';
    }
}
