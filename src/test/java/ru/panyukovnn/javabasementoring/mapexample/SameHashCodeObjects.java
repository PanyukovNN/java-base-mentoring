package ru.panyukovnn.javabasementoring.mapexample;

import java.util.Objects;
import java.util.UUID;

public class SameHashCodeObjects {

    private UUID id;

    public SameHashCodeObjects(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SameHashCodeObjects that = (SameHashCodeObjects) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "SameHashCodeObjects{" +
            "id=" + id +
            '}';
    }
}
