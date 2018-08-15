package com.epam.training.tasks.task4.model.entity;

import java.util.List;

public interface Component {

    void add(Component component);

    void remove(int index);

    Component getComponent(int index);

    List<Component> getComponnts();

}
