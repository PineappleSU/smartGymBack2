package common.enums;

public enum TypeOfProcessState {

	all(0,"所有反馈"), unchecked(1,"未回复/未处理"), checked(2,"已回复/已处理");

	private Integer type;
	private String typeName;

	
	TypeOfProcessState(Integer type, String typeName) {
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
		for (TypeOfProcessState i : TypeOfProcessState.values())
			if (i.getType() == type)
				return i.typeName;
		return null;
	}

	public static Integer getType(String typeName) {
		for (TypeOfProcessState i : TypeOfProcessState.values())
			if (i.getTypeName().equals(typeName))
				return i.type;
		return null;
	}

}
