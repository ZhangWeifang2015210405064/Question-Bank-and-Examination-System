package justdj.top.dao;

import justdj.top.pojo.Clazz;
import justdj.top.pojo.Course;
import justdj.top.pojo.Knowledge;
import justdj.top.pojo.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.math.BigInteger;
import java.util.List;

public interface CourseMapper {
	
	@Select("select id,teacher_id,name,introduce from course where teacher_id = #{teacherId}")
	@Results({
			@Result(id = true,column = "id",property = "id"),
			@Result(column = "teacher_id",property = "teacherId"),
			@Result(column = "name",property = "name"),
			@Result(column = "introduce",property = "introduce")
	})
	List<Course> selectCourseByTeacherId(BigInteger teacherId);
	
	@Select("select course.id,teacher_id,course.name,course.introduce\n" +
			"from user inner join class_student inner join class inner join course\n" +
			"on user.id = student_id and class_id = class.id and course_id = course.id\n" +
			"where user.id = #{studentId}")
	@Results({
			@Result(id = true,column = "id",property = "id"),
			@Result(column = "teacher_id",property = "teacherId"),
			@Result(column = "name",property = "name"),
			@Result(column = "introduce",property = "introduce")
	})
	List<Course> selectCourseByStudentId(BigInteger studentId);
	
	@Select("select id,teacher_id,name,introduce from course where id = #{courseId}")
	@Results({
			@Result(id = true,column = "id",property = "id"),
			@Result(column = "teacher_id",property = "teacherId"),
			@Result(column = "name",property = "name"),
			@Result(column = "introduce",property = "introduce"),
			@Result(column = "id",property = "knowledgeList",
			many = @Many(select = "justdj.top.dao.CourseMapper.selectKnowledgeByCourseId",fetchType = FetchType.EAGER)),
			@Result(column = "id",property = "clazzList",
			many = @Many(select = "justdj.top.dao.CourseMapper.selectClazzByCourseId",fetchType = FetchType.EAGER))
	})
	Course selectCourseByCourseId(BigInteger courseId);
	
	
//	知识点
	@Select("select id,course_id,name,introduce from knowledge where course_id = #{courseId}")
	List<Knowledge> selectKnowledgeByCourseId(BigInteger courseId);
	
//	班级
	@Select("select id,course_id,name from class where course_id = #{courseId}")
	@Results({
			@Result(id = true,column = "id",property = "id"),
			@Result (column = "name",property = "name"),
			@Result(column = "id",property = "userList",
					many = @Many(select = "justdj.top.dao.CourseMapper.selectStudentByClassId",fetchType =  FetchType.EAGER))
	})
	List<Clazz> selectClazzByCourseId(BigInteger courseId);
	
	
	@Select("select user.id,account,password,salt,name,age,sex from class_student join user \n" +
			"where student_id = user.id " +
			"and class_id = #{classId};\n")
	List<User> selectStudentByClassId(BigInteger classId);
}
