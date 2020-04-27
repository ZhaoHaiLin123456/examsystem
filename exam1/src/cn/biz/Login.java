package cn.biz;

import cn.bean.Manager;
import cn.bean.Student;
import cn.bean.Teacher;
import cn.dao.impl.ManagerDaoImpl;
import cn.dao.impl.StudentDaoImpl;
import cn.dao.impl.TeacherDaoImpl;

/**
 * 登陆
 */
public class Login {
	/**
	 * 登录验证
	 * 
	 * @param loginId
	 *            登录账号(工号或学号)
	 * @param loginPwd
	 *            登录密码
	 * @param status
	 *            身份
	 * @return 返回一个Object对象,该对象存储登录对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T validate(int loginId, String loginPwd, String status) {
		T obj = null;
		if (status.equals("学生")) {
			Student student = new StudentDaoImpl().findByStudentId(loginId);
			if (student != null) {
				if (student.getStudentPassword().equals(loginPwd)) {
					return (T) student;
				}
			}
		} else if (status.equals("老师")) {
			Teacher teacher = new TeacherDaoImpl().findTeacherById(loginId);
			if (teacher != null) {
				if (teacher.getTeacherPassword().equals(loginPwd)) {
					return (T) teacher;
				}
			}
		} else {
			Manager manager = new ManagerDaoImpl().findManagerById(loginId);
			if (manager != null) {
				if (manager.getManagerPassword().equals(loginPwd)) {
					return (T) manager;
				}
			}
		}
		return obj;
	}
}
