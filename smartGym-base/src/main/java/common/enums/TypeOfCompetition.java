package common.enums;

public enum TypeOfCompetition {

	//1-校运会 2-传统赛事 3-校外赛 4-教师活动 5-学院比赛
		 one(1, "校运会"), two(2, "传统赛事"), three(3, "校外赛"), four(4,"教师活动"), five(5,"学院比赛");

		private Integer type;
		private String typeName;

		TypeOfCompetition(Integer type, String typeName) {
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
			for (TypeOfCompetition i : TypeOfCompetition.values())
				if (i.getType() == type)
					return i.typeName;
			return null;
		}

		public static Integer getType(String typeName) {
			for (TypeOfCompetition i : TypeOfCompetition.values())
				if (i.getTypeName().equals(typeName))
					return i.type;
			return null;
		}
}
