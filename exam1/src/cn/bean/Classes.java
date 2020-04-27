package cn.bean;

/**
 * 班级信息
 */
public class Classes {
	/** 班级编号 */
	private int classId;
	/** 班级名字 */
	private String className;

	public Classes() {
		super();
	}

	public Classes(String className) {
		super();
		this.className = className;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", className=" + className + "]";
	}

}
