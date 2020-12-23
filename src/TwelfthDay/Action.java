package TwelfthDay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Action {
    private String direction;
    private int distance;

    public Action(String action) {
        Pattern p = Pattern.compile("(\\w)(\\d+)");
        Matcher m = p.matcher(action);
        if (m.find()) {
            distance = Integer.parseInt(m.group(2));
            direction = m.group(1);
        }
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Action{" +
                "direction='" + direction + '\'' +
                ", distance=" + distance +
                '}';
    }
}
