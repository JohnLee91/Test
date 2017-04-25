package EnumTest;

public enum OzWitch {
		WEST("W"),
		NORTH("N"),
		EAST("E"),
		SOUTH("S");
		
		private String desc;
		
		private OzWitch(String desc){
			this.desc = desc;
		}
		
		public String getDesc(){
			return this.desc;
		}
		
		public String toString(){
			String id = name();
			String lower = id.substring(1).toLowerCase();
			return id.charAt(0)+lower;
		}
		
		public static void main(String[] args) {
			for (OzWitch o : OzWitch.values()) {
				System.out.println(o+":"+o.getDesc());
			}
		}
}
