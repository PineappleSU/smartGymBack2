package common.enums;

public enum TypeOfWorker {
	//0-普通（默认） 1-裁判 2-赛事临时管理员 3-管理员
	 judge(1, "裁判"), admintemp(2, "临时管理员"), admin(3, "管理员");

	private Integer type;
	private String typeName;

	TypeOfWorker(Integer type, String typeName) {
		this.type = type;
		this.typeName = typeName;
	}

	public Integer getType() {
		return this.type;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public static String getTypeName(Integer type) {
		for (TypeOfWorker i : TypeOfWorker.values())
			if (i.getType() == type)
				return i.typeName;
		return null;
	}

	public static Integer getType(String typeName) {
		for (TypeOfWorker i : TypeOfWorker.values())
			if (i.getTypeName().equals(typeName))
				return i.type;
		return null;
	}
}
