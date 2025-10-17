package com.javaevolution.records;

import com.javaevolution.records.RecordsExample.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecordsExampleTest {

    private final RecordsExample example = new RecordsExample();

    @Test
    void createPerson_shouldCreatePersonRecord() {
        Person person = example.createPerson("Alice", 30);
        assertEquals("Alice", person.name());
        assertEquals(30, person.age());
    }

    @Test
    void person_shouldHaveWorkingEquals() {
        Person p1 = new Person("Bob", 25);
        Person p2 = new Person("Bob", 25);
        Person p3 = new Person("Charlie", 25);
        
        assertEquals(p1, p2);
        assertNotEquals(p1, p3);
    }

    @Test
    void person_shouldHaveWorkingHashCode() {
        Person p1 = new Person("Bob", 25);
        Person p2 = new Person("Bob", 25);
        
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void person_shouldHaveWorkingToString() {
        Person person = new Person("Alice", 30);
        String str = person.toString();
        assertTrue(str.contains("Alice"));
        assertTrue(str.contains("30"));
    }

    @Test
    void email_shouldValidateAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email("invalid"));
        assertDoesNotThrow(() -> new Email("test@example.com"));
    }

    @Test
    void point_distanceFromOrigin_shouldCalculateCorrectly() {
        Point point = new Point(3, 4);
        assertEquals(5.0, point.distanceFromOrigin(), 0.001);
    }

    @Test
    void point_translate_shouldReturnNewPoint() {
        Point p1 = new Point(1, 2);
        Point p2 = p1.translate(3, 4);
        
        assertEquals(4, p2.x());
        assertEquals(6, p2.y());
        assertEquals(1, p1.x()); // Original unchanged
    }

    @Test
    void rectangle_square_shouldCreateSquare() {
        Rectangle square = Rectangle.square(5);
        assertEquals(5, square.width());
        assertEquals(5, square.height());
    }

    @Test
    void rectangle_area_shouldCalculateCorrectly() {
        Rectangle rect = new Rectangle(4, 5);
        assertEquals(20, rect.area());
    }

    @Test
    void rectangle_perimeter_shouldCalculateCorrectly() {
        Rectangle rect = new Rectangle(4, 5);
        assertEquals(18, rect.perimeter());
    }

    @Test
    void circle_area_shouldCalculateCorrectly() {
        Circle circle = new Circle(5);
        assertEquals(Math.PI * 25, circle.area(), 0.001);
    }

    @Test
    void circle_draw_shouldNotThrowException() {
        Circle circle = new Circle(5);
        assertDoesNotThrow(circle::draw);
    }

    @Test
    void comparePeople_shouldCompareCorrectly() {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30);
        Person p3 = new Person("Bob", 25);
        
        assertTrue(example.comparePeople(p1, p2));
        assertFalse(example.comparePeople(p1, p3));
    }

    @Test
    void describePoint_shouldDescribeCorrectly() {
        Point point = new Point(5, 10);
        String description = example.describePoint(point);
        assertTrue(description.contains("5"));
        assertTrue(description.contains("10"));
    }

    @Test
    void describePoint_givenNonPoint_shouldReturnNotAPoint() {
        String description = example.describePoint("not a point");
        assertEquals("Not a point", description);
    }

    @Test
    void findOldest_shouldReturnOldestPerson() {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 35),
            new Person("Charlie", 25)
        );
        
        Person oldest = example.findOldest(people);
        assertEquals("Bob", oldest.name());
        assertEquals(35, oldest.age());
    }
}
