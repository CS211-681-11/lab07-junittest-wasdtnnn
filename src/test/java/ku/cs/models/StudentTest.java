package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student;
    @BeforeEach
    void init() {
        student = new Student("67xxxxxxxx", "test");
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ")
    void testChangeName() {
        String newName = "newName";
        student.changeName(newName);
        assertEquals(newName, student.getName());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 40.1 คะแนน")
    void testAddScore() {
        student.addScore(40.1);
        assertEquals(40.1, student.getScore());
    }

    @Test
    @DisplayName("ทดสอบการคำรวณเกรด")
    void testCalculateGrade() {
        student.addScore(20);
        assertEquals("F", student.grade());
    }

    @Test
    @DisplayName("ทดสอบการตรวจสอบ id")
    void testIsId() {
        assertTrue(student.isId("67xxxxxxxx"));
    }

    @Test
    @DisplayName("ทดสอบการตรวจสอบส่วนของชื่อ")
    void testIsNameContains() {
        assertTrue(student.isNameContains("t"));
    }
}