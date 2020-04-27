package cn.biz;

import cn.bean.Manager;
import cn.bean.Student;
import cn.bean.Teacher;
import cn.dao.impl.ManagerDaoImpl;
import cn.dao.impl.StudentDaoImpl;
import cn.dao.impl.TeacherDaoImpl;

/**
 * ��½
 */
public class Login {
	/**
	 * ��¼��֤
	 * 
	 * @param loginId
	 *            ��¼�˺�(���Ż�ѧ��)
	 * @param loginPwd
	 *            ��¼����
	 * @param status
	 *            ���
	 * @return ����һ��Object����,�ö���洢��¼����
	 */
	@SuppressWarnings("unchecked")
	public static <T> T validate(int loginId, String loginPwd, String status) {
		T obj = null;
		if (status.equals("ѧ��")) {
			Student student = new StudentDaoImpl().findByStudentId(loginId);
			if (student != null) {
				if (student.getStudentPassword().equals(loginPwd)) {
					return (T) student;
				}
			}
		} else if (status.equals("��ʦ")) {
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
