package ru.panyukovnn.javabasementoring.classes;

import java.util.List;
import java.util.Objects;

public class UserDto {

    private String firstname;
    private Integer age;
    private List<FeedbackDto> feedbacks;

    public UserDto() {
    }

    public UserDto(String firstname, Integer age) {
        this.firstname = firstname;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<FeedbackDto> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<FeedbackDto> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(firstname, userDto.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstname);
    }

    @Override
    public String toString() {
        return "UserDto{" +
            "firstname='" + firstname + '\'' +
            ", age=" + age +
            ", feedbacks=" + feedbacks +
            '}';
    }

    public static class FeedbackDto {

        private Integer rating;
        private String text;

        public FeedbackDto(Integer rating, String text) {
            this.rating = rating;
            this.text = text;
        }
    }

    /*
     {
        "user": {
            "firstname": "string",
            "age": "int",
            "feedbacks": [
                {
                    "rating": "int",
                    "text": "string"
                }
            ]
        }
     }
     */
}
