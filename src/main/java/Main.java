import cn.edu.sustech.cs307.config.Config;
import cn.edu.sustech.cs307.dto.*;
import cn.edu.sustech.cs307.dto.grade.Grade;
import cn.edu.sustech.cs307.dto.grade.HundredMarkGrade;
import cn.edu.sustech.cs307.dto.prerequisite.AndPrerequisite;
import cn.edu.sustech.cs307.dto.prerequisite.CoursePrerequisite;
import cn.edu.sustech.cs307.dto.prerequisite.OrPrerequisite;
import cn.edu.sustech.cs307.dto.prerequisite.Prerequisite;
import cn.edu.sustech.cs307.factory.*;
import cn.edu.sustech.cs307.service.*;
import cn.edu.sustech.cs307.serviceinstance.mymajor;

import java.sql.Date;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static cn.edu.sustech.cs307.dto.Course.CourseGrading.HUNDRED_MARK_SCORE;
import static cn.edu.sustech.cs307.dto.Course.CourseGrading.PASS_OR_FAIL;
import static cn.edu.sustech.cs307.dto.grade.PassOrFailGrade.FAIL;
import static cn.edu.sustech.cs307.dto.grade.PassOrFailGrade.PASS;

public class Main {
    public static void main(String[] args) throws Exception {
        ServiceFactory serviceFactory= Config.getServiceFactory();
        UserService userService=serviceFactory.createService(UserService.class);
        MajorService majorService=serviceFactory.createService(MajorService.class);
        InstructorService instructorService=serviceFactory.createService(InstructorService.class);
        CourseService courseService=serviceFactory.createService(CourseService.class);
        DepartmentService departmentService=serviceFactory.createService(DepartmentService.class);
        StudentService studentService=serviceFactory.createService(StudentService.class);
        SemesterService semesterService=serviceFactory.createService(SemesterService.class);

//        departmentService.addDepartment("CSE");//1
//        departmentService.addDepartment("MEE");//2
//        departmentService.addDepartment("ALE");//3
//        departmentService.addDepartment("WPE");//4
//        departmentService.addDepartment("LLE");//5
        //departmentService.removeDepartment("");

//        majorService.addMajor("CS", 5);//1
//        majorService.addMajor("IS", 5);//2
//        majorService.addMajor("RE", 6);//3
//        majorService.addMajor("ME", 6);//4
//        majorService.addMajor("AP", 7);//5
//        majorService.addMajor("AL", 7);//6
//        majorService.addMajor("WP", 8);//7
//        majorService.addMajor("EL", 9);//8
//        majorService.addMajor("SL", 9);//9
//
//        semesterService.addSemester("2021Spring", java.sql.Date.valueOf("2021-01-18"), java.sql.Date.valueOf("2021-06-13"));
//        semesterService.addSemester("2020Fall", java.sql.Date.valueOf("2020-9-6"), java.sql.Date.valueOf("2021-1-16"));
//        semesterService.addSemester("2020Spring", java.sql.Date.valueOf("2020-2-9"), java.sql.Date.valueOf("2021-5-31"));

//        studentService.addStudent(20191208, 4, "LONG", "yaya", java.sql.Date.valueOf("2019-08-15"));
//        studentService.addStudent(20190621, 3, "SAI", "xuxu", java.sql.Date.valueOf("2019-08-15"));
//        studentService.addStudent(20181023, 5, "LIN", "kai", java.sql.Date.valueOf("2018-08-15"));
//        studentService.addStudent(20200319, 5, "WANG", "see", java.sql.Date.valueOf("2020-08-15"));
//        studentService.addStudent(20210509, 8, "AI", "nin", java.sql.Date.valueOf("2021-08-15"));
//        studentService.addStudent(20221208, 7, "HAO", "de", java.sql.Date.valueOf("2022-08-15"));
//
//        instructorService.addInstructor(11912301, "hi", "Wor");
//        instructorService.addInstructor(11203453, "yihai", "WU");
//        instructorService.addInstructor(12003467, "yun", "CHEN");
//        instructorService.addInstructor(11507189, "yes", "AH");
//        instructorService.addInstructor(11602131, "wes", "OP");

        Prerequisite pre_1 = new CoursePrerequisite("CS102");
        Prerequisite pre_2 = new CoursePrerequisite("MA203");
        Prerequisite pre_3 = new CoursePrerequisite("MA101");
        Prerequisite pre_1_2 = new AndPrerequisite(new LinkedList<>() {{add(pre_1); add(pre_2);}});
        Prerequisite pre_4 = new CoursePrerequisite("LL103");
        Prerequisite pre_5 = new CoursePrerequisite("LL104");
        Prerequisite pre_4_5 = new OrPrerequisite(List.of(pre_4, pre_5));
        Prerequisite pre_4_5_wp = new AndPrerequisite(List.of(pre_4_5, pre_1));
        //courseService.addCourse("CS102", "JavaProgram", 3, 64, HUNDRED_MARK_SCORE, null);
        //courseService.addCourse("CS202", "C++Program", 3, 64, HUNDRED_MARK_SCORE, pre_1);
        //courseService.addCourse("LL103", "Language", 3, 64, HUNDRED_MARK_SCORE, null);
        //courseService.addCourse("WP908", "Entertainment", 1, 32, PASS_OR_FAIL, null);
        //courseService.addCourse("ME101", "MachineBasic", 4, 64, HUNDRED_MARK_SCORE, null);
        //courseService.addCourse("MA101", "Calculus", 4, 64, HUNDRED_MARK_SCORE, null);
        //courseService.addCourse("MA203", "GaiTong", 3, 64, HUNDRED_MARK_SCORE, pre_3);
        //courseService.addCourse("CS602", "DSAA", 3, 64, HUNDRED_MARK_SCORE, pre_1_2);
        //courseService.addCourse("LL104", "Lang", 3, 64, PASS_OR_FAIL, null);
        //courseService.addCourse("LL304", "Uage", 3, 64, HUNDRED_MARK_SCORE, pre_4_5);
        //courseService.addCourse("WP117", "Ana", 3, 64, HUNDRED_MARK_SCORE, pre_4_5_wp);
        //courseService.removeCourse("ME101");
        //courseService.removeCourse("ABC");
        //courseService.removeCourseSection(4);
        //courseService.removeCourseSectionClass(6);
        List<Course> dd = new ArrayList<>();
        //dd = courseService.getAllCourses();

        //List<User> uu = new ArrayList<>();
        //uu = userService.getAllUsers();
        //courseService.addCourseSection("CS202", 1, "Lecture", 80);
        //courseService.addCourseSection("CS202", 1, "Lab01", 40);
        //courseService.addCourseSection("CS202", 1, "Lab02", 40);
        //courseService.addCourseSection("WP908", 3, "Lecture", 100);
        //courseService.addCourseSection("WP908", 3, "Outdoor01", 50);
        //courseService.addCourseSection("WP908", 3, "Outdoor02", 50);
       // courseService.addCourseSection("MA203", 2, "Lecture", 80);
        //courseService.addCourseSection("LL304", 2, "Lecture", 65);
        //courseService.addCourseSection("ME101", 2, "Experiment", 45);
        //courseService.addCourseSection("WP117",1,"Lecture", 30);
        //courseService.addCourseSection("LL104",1,"Lecture", 37);


        List<Short> li = new LinkedList<>() {{add((short) 1); add((short) 2); add((short) 3); add((short) 4);}};
        //courseService.addCourseSectionClass(4, 11912301, DayOfWeek.THURSDAY, li, (short)10, (short)50, "LycheeHill");
       //courseService.addCourseSectionClass(3, 11507189, DayOfWeek.WEDNESDAY, li, (short)1, (short)51, "LycheeHill");
        //courseService.addCourseSectionClass(6, 11602131, DayOfWeek.MONDAY, li, (short)5, (short)55, "TeachingBuildingOne");
        //courseService.addCourseSectionClass(7, 12003467, DayOfWeek.MONDAY, li, (short)5, (short)55, "TeachingBuildingOne");

        HundredMarkGrade grade_1 = new HundredMarkGrade((short)96);
        HundredMarkGrade grade_2 = new HundredMarkGrade((short)84);
        HundredMarkGrade grade_3 = new HundredMarkGrade((short)92);
        //studentService.addEnrolledCourseWithGrade(20191208, 1, grade_1);
        //studentService.addEnrolledCourseWithGrade(20181023, 1, PASS);
        //studentService.addEnrolledCourseWithGrade(20210509, 5, PASS);
        //studentService.addEnrolledCourseWithGrade(20190621, 5, PASS);
        //studentService.addEnrolledCourseWithGrade(20221208, 1, PASS);
        //studentService.addEnrolledCourseWithGrade(20190621, 9, grade_2);
        //studentService.addEnrolledCourseWithGrade(20200319, 12, grade_2);
        //studentService.addEnrolledCourseWithGrade(20221208, 12, FAIL);
        //studentService.addEnrolledCourseWithGrade(20181023, 8, grade_3);
        //studentService.addEnrolledCourseWithGrade(20221208, 11, grade_3);

        //majorService.addMajorElectiveCourse(3, "CS202");
        //majorService.addMajorCompulsoryCourse(10, "LL103");
        //majorService.addMajorElectiveCourse(7, "WP908");
        //majorService.addMajorElectiveCourse(5, "ME101");



    }

}

