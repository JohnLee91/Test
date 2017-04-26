package ThreadTest;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {
	/**
	 * 打印类的信息，获取public成员函数信息
	 * @param obj 该对象所属类的信息
	 */
	public static void printMethodMessage(Object obj){
		//要获取类的信息 首先要获取类的类类型
		Class c = obj.getClass();//传递的是哪个子类的对象，c就是该子类的类类型
		//获取类的名称
		System.out.println("类的名称是："+c.getName());
		/*
		 * Method类，方法对象
		 * 一个成员方法就是一个Method对象
		 * getMethods()方法获取的是所有的public的函数，包括父类继承而来的
		 * getDeclaredMethods()获取的是所有该类自己声明的方法，不问访问权限
		 */
		Method[] ms = c.getMethods();//c.getDeclaredMethods();
		for(int i = 0; i < ms.length; i++){
			//得到方法的返回值类型的类类型
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getSimpleName()+" ");
			//得到方法的名称
			System.out.print(ms[i].getName()+"(");
			//获取参数类型 --> 得到的是参数列表的类型的类类型
			Class[] paramTypes = ms[i].getParameterTypes();
			for(int j = 0; j< paramTypes.length; j++){
				if(paramTypes.length-1==j){
					System.out.print(paramTypes[j].getSimpleName());
				}else{
					System.out.print(paramTypes[j].getSimpleName()+",");
				}
			}
			System.out.println(")");
		}
	}

	/**
	 * 获取成员变量的信息
	 * @param obj
	 */
	public static void printFieldMessage(Object obj) {
		Class c = obj.getClass();
		/*
		 * 成员变量也是对象
		 * java.lang.reflect.Field
		 * Field类封装了关于成员变量的操作
		 * getFields()方法获取的是所有的public的成员变量的信息
		 * getDeclaredFields()方法获取的是该类自己声明的成员变量的信息
		 * */
		//Field[] fs = c.getFields();
		Field[] fs = c.getDeclaredFields();
		for(Field field:fs){
			//得到成员变量的类型的类类型
			Class fieldType = field.getType();
			String typeName = fieldType.getSimpleName();
			//得到成员变量的名称
			String fieldName = field.getName();
			System.out.println(typeName+" "+fieldName);
		}
	}
	
	/**
	 * 打印对象的构造函数的信息
	 * @param obj
	 */
	public static void printConMessage(Object obj) {
		Class c = obj.getClass();
		/*
		 * 构造函数也是对象
		 * java.lang.Constructor中封装了构造函数的信息
		 * getConstructors()获取所有的public的构造函数
		 * getDeclaredConstructors()获取所有声明的构造函数
		 */
		//Constructor[] cs = c.getConstructors();
		Constructor[] cs = c.getDeclaredConstructors();
		for(Constructor constructor:cs){
			System.out.print(constructor.getName()+"(");
			//获取构造函数的参数列表 --> 获取参数列表的类类型
			Class[] paramTypes = constructor.getParameterTypes();
			for(int j = 0; j< paramTypes.length; j++){
				if(paramTypes.length-1==j){
					System.out.print(paramTypes[j].getSimpleName());
				}else{
					System.out.print(paramTypes[j].getSimpleName()+",");
				}
			}
			System.out.println(")");
		}
	}
	
	public static void main(String[] args) {
		printMethodMessage(new Object());
		printFieldMessage(new Object());
		printConMessage(new Object());
		String s = "Hello";
		printMethodMessage(s);
		printFieldMessage(s);
		printConMessage(s);
		Integer n = 1;
		printMethodMessage(n);
		printFieldMessage(n);
		printConMessage(n);
	}
}
