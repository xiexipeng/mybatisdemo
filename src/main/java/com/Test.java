package com;

import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mapper.CollegeMapper;
import com.mapper.StudentMapper;
import com.model.College;
import com.model.Student;
import com.model.StudentExample;
import com.model.Teacher;

public class Test {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	private static ApplicationContext ctx;

//	static {
//		ctx = new ClassPathXmlApplicationContext("application.xml");
//	}

	static {
		try {
			reader = Resources.getResourceAsReader("mybatis_Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			List<Student> students = sqlSession.selectList("sql.StudentMapper.selectAllStudent");
			for (Student student : students) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
				String birthday = simpleDateFormat.format(student.getBirthday());
				System.out.println(
						"id=" + student.getId() + "; " + "name=" + student.getName() + "; " + "birhtday=" + birthday);
			}

			// StudentMapper studentMapper =
			// sqlSession.getMapper(StudentMapper.class);
			// Student student = studentMapper.selectStudentByID(1);
			// System.out.println(student.getName());

			// StudentMapper studentMapper =
			// sqlSession.getMapper(StudentMapper.class);
			// Student student = new Student();
			// student.setName("dd");
			// student.setAge(3);
			// student.setBirthday(new Date());
			// studentMapper.addStudent(student);
			// sqlSession.commit();

			// StudentMapper studentMapper =
			// sqlSession.getMapper(StudentMapper.class);
			// Student student = studentMapper.selectStudentByID(9);
			// student.setName("zxc");
			// student.setAge(4);
			// student.setBirthday(new Date());
			// studentMapper.updateStudent(student);
			// sqlSession.commit();

			// StudentMapper studentMapper =
			// sqlSession.getMapper(StudentMapper.class);
			// studentMapper.deleteStudent(9);
			// sqlSession.commit();

			// StudentMapper studentMapper =
			// sqlSession.getMapper(StudentMapper.class);
			// List<Student> students = studentMapper.getStudentCollege(1);

			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy-mm-dd");
			// for (Student student : students) {
			// String birthday = simpleDateFormat.format(student.getBirthday());
			// System.out.println("id=" + student.getId() + "; " + "name=" +
			// student.getName() + "; " + "birhtday="
			// + birthday);
			// }

			// CollegeMapper collegeMapper =
			// sqlSession.getMapper(CollegeMapper.class);
			// College college = collegeMapper.getCollegeById(1);
			// System.out.println(college.getTeacher().getName());

			// CollegeMapper collegeMapper =
			// sqlSession.getMapper(CollegeMapper.class);
			// College college = collegeMapper.getCollegeById(1);
			// List<Student> students = college.getStudents();
			// for(Student student : students){
			// System.out.println(student.getName());
			// }

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		// StudentMapper studentMapper = (StudentMapper)
		// ctx.getBean("studentMapper");
		// Test test = new Test();
		// Map<String, Integer> page = test.page(1, 3);
		// List<Student> students = studentMapper.selectStudentsByPage(page);
		// for (Student student : students) {
		// System.out.println(student.getName());
		// }

		// Test test = new Test();
		// List<Student> students = test.getStudentByName("x");
		// for(Student student : students){
		// System.out.println(student.getName());
		// }
		// System.out.println(new Date());
	}

	public List<Student> getStudentByName(String name) {
		StudentExample studentExample = new StudentExample();
		studentExample.createCriteria().andNameLike("%" + name + "%");
		studentExample.setOrderByClause("id desc");
		StudentMapper studentMapper = (StudentMapper) ctx.getBean("studentMapper");
		List<Student> students = studentMapper.selectByExample(studentExample);
		return students;
	}

	public Student selectOne(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Student student = null;
		try {
			student = sqlSession.selectOne("StudentMapper.selectStudentByID", 1);
			System.out.println(student.getName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return student;
	}

	public Map<String, Integer> page(int pageNo, int pageSize) {
		int index = (pageNo - 1) * pageSize;
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("index", index);
		page.put("pageSize", pageSize);
		return page;
	}

	public List<Student> selectAllStudent() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Student> students = null;
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
