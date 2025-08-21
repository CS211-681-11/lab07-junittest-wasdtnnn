package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList studentList;
    @BeforeEach
    void init() {
        studentList = new StudentList();
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนคนใหม่ในรายการ")
    void testAddNewStudent() {
        String id1 = "67xxxxxxx1";
        String name1 = "name1";
        studentList.addNewStudent(id1, name1);
        String id2 = "67xxxxxxx2";
        String name2 = "name2";
        double score = 49.75;
        studentList.addNewStudent(id2, name2, score);

        assertEquals(2, studentList.getStudents().size());
        assertEquals(id1, studentList.getStudents().get(0).getId());
        assertEquals(name1, studentList.getStudents().get(0).getName());
        assertEquals(id2, studentList.getStudents().get(1).getId());
        assertEquals(name2, studentList.getStudents().get(1).getName());
        assertEquals(score, studentList.getStudents().get(1).getScore());
    }

    @Test
    @DisplayName("ทดสอบการค้นหานักเรียนจาก id")
    void testFindStudentById() {
        String id = "6710000123";
        studentList.addNewStudent(id, "name1");
        assertSame(studentList.getStudents().get(0), studentList.findStudentById(id));
    }

    @Test
    @DisplayName("ทดสอบการกรองนักเรียนโดยใช้ชื่อ")
    void testFilterByName() {
        studentList.addNewStudent("67xxxxxxx1", "John Abc");
        studentList.addNewStudent("67xxxxxxx2", "John Def");
        studentList.addNewStudent("67xxxxxxx3", "John Ghi");
        studentList.addNewStudent("67xxxxxxx4", "Jill Abc");
        studentList.addNewStudent("67xxxxxxx5", "Jill Def");

        assertEquals(3, studentList.filterByName("John").getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนนโดยระบุ id")
    void testGiveScoreToId() {
        String id= "67xxxxxxx1";
        double score = 47.65;
        studentList.addNewStudent(id, "name1");

        studentList.giveScoreToId(id, score);
        assertEquals(score, studentList.getStudents().get(0).getScore());
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดโดยระบุ id")
    void viewGradeOfId() {
        String id = "67xxxxxxx1";
        studentList.addNewStudent(id, "name1", 55.75);
        assertEquals("D", studentList.getStudents().get(0).getGrade());
    }
}