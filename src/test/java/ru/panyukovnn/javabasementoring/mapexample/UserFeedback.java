package ru.panyukovnn.javabasementoring.mapexample;

import java.util.Objects;

public class UserFeedback {

    private String id;
    private Integer rating;
    private String text;

    public UserFeedback(String id, Integer rating, String text) {
        this.id = id;
        this.rating = rating;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFeedback that = (UserFeedback) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "UserFeedback{" +
            "id=" + id +
            ", rating=" + rating +
            ", text='" + text + '\'' +
            '}';
    }
}
