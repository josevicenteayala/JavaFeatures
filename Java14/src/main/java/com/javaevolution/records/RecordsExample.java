package com.javaevolution.records;

/**
 * Demonstrates Records introduced in Java 14 (Preview) and standardized in Java 16.
 * Records provide a compact syntax for declaring classes that are transparent holders for data.
 */
public class RecordsExample {

    // Simple record
    public record Person(String name, int age) {}

    // Record with validation
    public record Email(String address) {
        public Email {
            if (address == null || !address.contains("@")) {
                throw new IllegalArgumentException("Invalid email address");
            }
        }
    }

    // Record with additional methods
    public record Point(int x, int y) {
        public double distanceFromOrigin() {
            return Math.sqrt(x * x + y * y);
        }

        public Point translate(int dx, int dy) {
            return new Point(x + dx, y + dy);
        }
    }

    // Record with static methods
    public record Rectangle(double width, double height) {
        public static Rectangle square(double side) {
            return new Rectangle(side, side);
        }

        public double area() {
            return width * height;
        }

        public double perimeter() {
            return 2 * (width + height);
        }
    }

    // Record implementing an interface
    public interface Drawable {
        void draw();
    }

    public record Circle(double radius) implements Drawable {
        @Override
        public void draw() {
            System.out.println("Drawing circle with radius: " + radius);
        }

        public double area() {
            return Math.PI * radius * radius;
        }
    }

    /**
     * Creating and using records
     */
    public Person createPerson(String name, int age) {
        return new Person(name, age);
    }

    /**
     * Records automatically provide equals, hashCode, and toString
     */
    public boolean comparePeople(Person p1, Person p2) {
        return p1.equals(p2);
    }

    /**
     * Using record with pattern matching
     */
    public String describePoint(Object obj) {
        if (obj instanceof Point p) {
            return "Point at (" + p.x() + ", " + p.y() + ")";
        }
        return "Not a point";
    }

    /**
     * Record in collections
     */
    public Person findOldest(java.util.List<Person> people) {
        return people.stream()
                .max((p1, p2) -> Integer.compare(p1.age(), p2.age()))
                .orElse(null);
    }
}
