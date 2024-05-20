package test04_enumtest;

public class Surface {

	static double pi = 3.14;
	
	public static void main(String[] args) {
		
		Planet[] enumArr= Planet.values();
		System.out.println("태양계 행성의 반지름과 표면적");
		for(Planet a : enumArr) {
			long surface = (long) (4*pi*a.getData()*a.getData());
			System.out.print(a.name() + "의 지름: "+a.getData());
			System.out.println(", 표면적: " + surface);
		}
	}
}
