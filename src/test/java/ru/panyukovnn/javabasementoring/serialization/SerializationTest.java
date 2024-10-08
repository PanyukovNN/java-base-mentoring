package ru.panyukovnn.javabasementoring.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SerializationTest {

    @Test
    void serializable() throws IOException, ClassNotFoundException {
        // serialVersionUID - присваивается всем объектам при имплементации интерфейса Serializable
        // Serializable - требуется для встроенных механизмов java по сериализации/десериализации

        CreateShortLinkRequest request = createRequest();

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

            try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()))) {
                CreateShortLinkRequest fromByteArrayRequest = (CreateShortLinkRequest) objectInputStream.readObject();

                System.out.println(fromByteArrayRequest);
            }

        }

        // Попроубем десериализовать в другой объект
        // Благодаря serialVersionUID, мы не можем десериализовать объект в другой объект, поскольку он сериализуется вместе с классом и сравнивается при десериализации
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

            try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()))) {
                assertThrows(ClassCastException.class, () -> {
                    CreateShortLinkResponse fromByteArrayResponse = (CreateShortLinkResponse) objectInputStream.readObject();

                    System.out.println(fromByteArrayResponse);
                });
            }
        }

        // Использование интерфейса serializable в современной разработке пригождается, в случаях когда он требуется внутри библиотек, например Hibernate
        // На собеседованиях фактически не спрашивают
    }

    private ObjectMapper objectMapper = new ObjectMapper()
        .registerModule(new JavaTimeModule())
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    @Test
    void serializationDeserialization() throws IOException {
        CreateShortLinkRequest createShortLinkRequest = createRequest();

        String rawRequest = objectMapper.writeValueAsString(createShortLinkRequest);

        System.out.println(rawRequest);

        CreateShortLinkRequest fromStringRequest = objectMapper.readValue(rawRequest, CreateShortLinkRequest.class);
        CreateShortLinkResponse fromStringResponse = objectMapper.readValue(rawRequest, CreateShortLinkResponse.class);

        System.out.println(fromStringRequest);
        assertNotEquals(createShortLinkRequest, fromStringRequest);
    }

    private CreateShortLinkRequest createRequest() {
        return new CreateShortLinkRequest(
            "https://google.com",
            LocalDateTime.now().plusDays(1),
            "Гугл",
            true
        );
    }
}
