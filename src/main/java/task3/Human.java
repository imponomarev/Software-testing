package task3;

import java.util.ArrayList;
import java.util.List;

public class Human implements IntelligenceComparator {
    private List<Invention> inventions = new ArrayList<>();

    public void addInvention(Invention invention) {
        inventions.add(invention);
    }

    public String listInventions() {
        StringBuilder sb = new StringBuilder("Изобретения человека: ");
        for (Invention invention : inventions) {
            sb.append(invention.getTitle()).append(", ");
        }
        return sb.toString();
    }

    @Override
    public String compareIntelligence() {
        return "Человек считает себя разумнее дельфина благодаря изобретениям.";
    }
}