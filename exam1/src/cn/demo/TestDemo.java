package cn.demo;
import org.junit.Test;
import cn.bean.Manager;
import cn.bean.Record;
import cn.bean.Teacher;
import cn.dao.ManagerDao;
import cn.dao.RecordDao;
import cn.dao.TeacherDao;
import cn.dao.impl.ManagerDaoImpl;
import cn.dao.impl.RecordDaoImpl;
import cn.dao.impl.TeacherDaoImpl;
import cn.dbc.BaseDao;

public class TestDemo {
	BaseDao bs = new BaseDao();
	ManagerDao mDao = new ManagerDaoImpl();
	RecordDao rDao = new RecordDaoImpl();
	TeacherDao tDao = new TeacherDaoImpl();

	@Test
	public void testManager() {
		Manager manager = null;
		int id = 1004;
		manager = mDao.findManagerById(id);
		if (manager != null) {
			System.out.println(
					manager.getManagerId() + "\t" + manager.getManagerName() + "\t" + manager.getManagerPassword());
		} else {
			System.out.println("管理员不存在");
		}
	}

	@Test
	public void testRecord() {
		Record record = null;
		record = rDao.findRecordByStuIdAndSerialId(3004, 1);
		if (record != null) {
			System.out.println(record.getRecordStudentId() + "\t" + record.getRecordTitleNumber()
					+ record.getRecordSerialId() + "\t" + record.getRecordAnswer());
		} else {
			System.out.println("无相关记录");
		}
	}
}
