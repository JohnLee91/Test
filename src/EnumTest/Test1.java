package EnumTest;

enum Search { HITHER, YOU }

public class Test1 {
	public static void main(String[] args) {
		//Search[] vals = Search.values();
		Enum e = Search.HITHER;//向上转型
		//e.values();//Enum中没有values()方法
		for(Enum en : e.getClass().getEnumConstants()){
			System.out.println(en);
		}
	}
}
