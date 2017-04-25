package EnumTest;

import java.text.DateFormat;
import java.util.Date;

public enum CSM {
	DATE_TIME{
		String getInfo(){
			return DateFormat.getDateInstance().format(new Date());
		}
	},
	CLASSPATH{
		String getInfo(){
			return System.getenv("CLASSPATH");
		}
	},
	VERSION{
		String getInfo(){
			return System.getProperty("java.version");
		}
	};
	abstract String getInfo();
	public static void main(String[] args) {
		for(CSM csm : values()){
			System.out.println(csm.getInfo());
		}
	}
}
