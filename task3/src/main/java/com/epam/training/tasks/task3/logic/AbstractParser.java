package com.epam.training.tasks.task3.logic;

import com.epam.training.tasks.task3.model.entity.Flower;

import java.util.List;

public abstract class AbstractParser {
    public abstract List<Flower> parse(String fileName);
}
