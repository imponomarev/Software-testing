package task3;

import java.util.ArrayList;
import java.util.List;

public class Dolphin implements IntelligenceComparator {
    private List<Activity> activities = new ArrayList<>();

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public String listActivities() {
        StringBuilder sb = new StringBuilder("Деятельность дельфинов: ");
        for (Activity activity : activities) {
            sb.append(activity.getDescription()).append(", ");
        }
        return sb.toString();
    }

    @Override
    public String compareIntelligence() {
        return "Дельфин считает себя разумнее человека, так как наслаждается жизнью.";
    }
}
