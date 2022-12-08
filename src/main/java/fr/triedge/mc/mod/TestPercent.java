package fr.triedge.mc.mod;

public class TestPercent {

	public static void main(String[] args) {
		System.out.println("Start");
		for (int y = 10; y > -20; --y) {
			float p = Utils.getPercent(10, -3, y);
			System.out.println(y+": "+p);
		}
	}
}
