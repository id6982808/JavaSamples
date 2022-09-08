// https://qiita.com/b150005/items/7a378a0b7ccb0fc08e44
import java.util.Random;

class StaticInitializer {
	private static int staticCounter;
	private static int instanceCounter = 0;
	
	private int staticId;
	private int instanceId;
	
	static {
		Random rand = new Random();
		staticCounter = rand.nextInt(10)* 100;
	}
	
	{
		instanceId = ++instanceCounter;
	}
	
	public StaticInitializer() {
		staticId = ++staticCounter;
	}
	
	public int getStaticId() {
		return staticId;
	}
	
	public int getInstanceId() {
		return instanceId;
	}
	
	class Main {
		public static void main(String[] args) {
			StaticInitializer a = new StaticInitializer();
			StaticInitializer b = new StaticInitializer();
			StaticInitializer c = new StaticInitializer();
			
			System.out.println("StaticId a: " + a.getStaticId() + ", InstanceId a: " + a.getInstanceId());
			System.out.println("StaticId b: " + b.getStaticId() + ", InstanceId b: " + b.getInstanceId());
			System.out.println("StaticId c: " + c.getStaticId() + ", InstanceId c: " + c.getInstanceId());
		}
	}
}
