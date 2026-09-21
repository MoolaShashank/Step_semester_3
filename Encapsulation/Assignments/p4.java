public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED"; 
    }

    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else if (color.equals("YELLOW")) {
            color = "RED";
        }
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }
}
