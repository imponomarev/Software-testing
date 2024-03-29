import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task3.Activity;
import task3.Dolphin;
import task3.Human;
import task3.Invention;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntellegenceTest {

    private Human human;
    private Dolphin dolphin;

    @BeforeEach
    void setUp() {
        human = new Human();
        dolphin = new Dolphin();
    }

    @Test
    void getTitleTest() {
        Invention invention = new Invention("Колесо");
        assertEquals("Колесо", invention.getTitle());
    }

    @Test
    void getDescriptionTest() {
        Activity activity = new Activity("Плескаться в воде");
        assertEquals("Плескаться в воде", activity.getDescription());
    }


    @Test
    void addInventionTest() {
        Invention invention = new Invention("Колесо");
        human.addInvention(invention);
        String inventions = human.listInventions();
        assertTrue(inventions.contains("Колесо"));
    }

    @Test
    void listInventionsTest() {
        human.addInvention(new Invention("Колесо"));
        human.addInvention(new Invention("Нью-Йорк"));
        String inventions = human.listInventions();
        assertTrue(inventions.contains("Колесо") && inventions.contains("Нью-Йорк"));
    }

    @Test
    void addActivityTest() {
        Activity activity = new Activity("Плескаться в воде");
        dolphin.addActivity(activity);
        String activities = dolphin.listActivities();
        assertTrue(activities.contains("Плескаться в воде"));
    }

    @Test
    void listActivitiesTest() {
        dolphin.addActivity(new Activity("Плескаться в воде"));
        dolphin.addActivity(new Activity("Развлекаться"));
        String activities = dolphin.listActivities();
        assertTrue(activities.contains("Плескаться в воде") && activities.contains("Развлекаться"));
    }

    @Test
    void CompareIntelligenceByHumanTest() {
        Human human = new Human();
        String expected = "Человек считает себя разумнее дельфина благодаря изобретениям.";
        Assertions.assertEquals(expected, human.compareIntelligence());
    }

    @Test
    void CompareIntelligenceByDolphinTest() {
        Dolphin dolphin = new Dolphin();
        String expected = "Дельфин считает себя разумнее человека, так как наслаждается жизнью.";
        Assertions.assertEquals(expected, dolphin.compareIntelligence());
    }

}
