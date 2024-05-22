package com.grzsoftware.demo;

import com.grzsoftware.demo.dao.StudentDAO;
import com.grzsoftware.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO) {
		return args -> {
//			createStudent(studentDAO);

//			createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

			queryForStudents(studentDAO);

//			queryForStudentByLastName(studentDAO);

//			updateStudent(studentDAO);

//			removeStudent(studentDAO);

//			removeAllStudents(studentDAO);
		};
	}

	private void removeAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");

		int count = studentDAO.deleteAll();

		System.out.println("Deleted " + count + " students");
	}

	private void removeStudent(StudentDAO studentDAO) {
		Long id = 1L;

		System.out.println("Deleting student with id " + id);

		studentDAO.delete(id);

		System.out.println("Deleted student with id " + id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1L);

		System.out.println("Getting student with id " + student.getId());

		student.setFirstName("John");

		System.out.println("Updating student with id " + student.getId());

		studentDAO.update(student);

		System.out.println("Student with id " + student.getId() + " updated. \n Student: " + student);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Michael");
		for (Student student : students) {
			System.out.println(student);
		}

		if (students.isEmpty()) {
			System.out.println("There are no students with this last name");
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student student : students) {
			System.out.println(student);
		}

		if (students.isEmpty()) {
			System.out.println("There are no students registered");
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating student");

		Student student = new Student("Maycon", "Silva", "maycon@gmail.com");

		studentDAO.save(student);

		student = studentDAO.findById(student.getId());

		System.out.println(student);

		if (student == null) {
			System.out.println("There are no students with this last name");
		}
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 students");

		Student student = new Student("Isac", "Grizante", "isacgrizante18@gmail.com");
		Student student2 = new Student("Mariana", "Oliveira", "marianaoliveira@gmail.com");
		Student student3 = new Student("James", "Silva", "jamessilva@gmail.com");

		System.out.println("Saving student");

		studentDAO.save(student);
		studentDAO.save(student2);
		studentDAO.save(student3);

		System.out.println("Students saved! Student ID: " + student.getId() +
							"\n Student2 ID: " + student2.getId() +
							"\n Student3 ID: " + student3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student");

		Student student = new Student("Isac", "Grizante", "isacgrizante18@gmail.com");

		System.out.println("Saving student");

		studentDAO.save(student);

		System.out.println("Student saved! Student ID: " + student.getId());
	}
}
