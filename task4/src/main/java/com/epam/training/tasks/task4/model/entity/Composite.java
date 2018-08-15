package com.epam.training.tasks.task4.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {

    private List<Component> components = new ArrayList<Component>();

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(int index) {
        if (index > 0 && index < components.size()) {
            components.remove(index);
        }
    }

    @Override
    public Component getComponent(int index) {
        if (index > 0 && index < components.size()) {
            return components.get(index);
        }
        return null;
    }

    @Override
    public List<Component> getComponnts() {
        return components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return Objects.equals(components, composite.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    @Override
    public String toString() {
        return "Composite{" +
                "components=" + components +
                '}';
    }
}
