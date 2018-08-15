package com.epam.training.tasks.task4.parser;

import com.epam.training.tasks.task4.model.entity.Component;

public class SentenceParser extends AbstractParser {

    private static final String REGEX = "(\\w+\\S+)[\\s|,|!|.]?";

    public Component parse(String text) {
        AbstractParser successor = getSuccessor();
        return makeParsing(successor, REGEX, text);
    }

    /**
     * private static final String REGEX = "([A-Z](|[^?!.(]|\\([^)]*\\))*[.?!])";
     *
     *     public Component parse(String text) {
     *         if (getSuccessor() != null) {
     *             getSuccessor().parse(text);
     *         }
     *         return null;
     *     }
     *
     *     public static void main(String[] args) {
     *         String text = "It has survived - not only j— centuries, but also the leap into 13i--+ electronic typesetting, \n" +
     *                 "remaining 35+ essentially 6934-*+ unchanged. It was popularised in the 49756-+* \n" +
            *"with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop \n"+
            *"publishing software like Aldus PageMaker including versions of Lorem Ipsum. ";
     *
    Pattern pattern = Pattern.compile(REGEX);
     *
    Matcher matcher = pattern.matcher(text);
     *
    List<String> listOfStrings = new LinkedList<>();
     *
    String partOfString;
     *
             *while(matcher.find())

    {
     *partOfString = matcher.group();
     *listOfStrings.add(partOfString);
     *System.out.println(partOfString + "\n");
     *}
     *
}
     */
}
