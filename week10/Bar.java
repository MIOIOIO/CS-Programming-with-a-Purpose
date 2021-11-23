import java.util.Arrays;

public class Bar implements Comparable<Bar> {
    private final String name;
    private final String category;
    private final int value;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        if (name == null || value < 0 || category == null) throw new IllegalArgumentException();
        this.name = name;
        this.category = category;
        this.value = value;
    }

    // Returns the name of this bar.
    public String getName() {
        return this.name;
    }

    // Returns the value of this bar.
    public int getValue() {
        return this.value;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return this.category;
    }

    // Compare two bars by value.
    public int compareTo(Bar that) {
        if (that == null) throw new NullPointerException();
        return Integer.compare(this.value, that.value);
    }

    // Sample client (see below).
    public static void main(String[] args) {
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Mexico", 130262216, "North America");
        bars[1] = new Bar("China", 1444216107, "East Asia");
        bars[2] = new Bar("Russia", 145912025, "Northern Asia/Northern Asia");
        bars[3] = new Bar("United States", 332129757, "North America");
        bars[4] = new Bar("Bangladesh", 166303498, "South Asia");
        bars[5] = new Bar("Indonesia", 276361783, "Southeast Asia/Southeast Asia");
        bars[6] = new Bar("Nigeria", 211400708, "West Africa");
        bars[7] = new Bar("Pakistan", 225199937, "South Asia");
        bars[8] = new Bar("Brazil", 213993437, "South America");
        bars[9] = new Bar("India", 1393409038, "South Asia");

        Arrays.sort(bars);
        for (Bar bar : bars) {
            System.out.println(bar.getName() + " (" + bar.getCategory() + "): " + bar.getValue());
        }
    }
}
