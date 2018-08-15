package com.epam.training.tasks.task4.model.entity;

import java.util.List;
import java.util.Objects;

public class Leaf implements Component{
    private String string;

    public Leaf(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public Component getComponent(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Component> getComponnts() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leaf leaf = (Leaf) o;
        return Objects.equals(string, leaf.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "string='" + string + '\'' +
                '}';
    }
}
