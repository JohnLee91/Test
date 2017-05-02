package CollectionTest;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		SetTest test = new SetTest();
		Set<Student> mySet = new HashSet<Student>();
		Student s1 = test.new Student("s", 18);
		Student s2 = test.new Student("s", 18);
		
		mySet.add(s1);
		mySet.add(s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
		System.out.println(mySet.size());
		
	}
	
	class Student{
		private String name;
		private int age;
		
		public Student(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (obj instanceof Student) {
				Student s = (Student)obj;
				if (s.getAge()==this.getAge() && s.getName().equals(this.getName())) {
					return true;
				}
			}
			
			return false;
		}
		
		@Override
		public int hashCode() {
			return this.getName().hashCode()+this.getAge();
		}
	}
}
