package case03;

public class PhoneTest {

	public static void main(String[] args) {
		PhonePlan phonePlan =new PhonePlan(8000.0,10.0);
		System.out.printf("%s:%s",phonePlan.getPhoneType(),phonePlan.getPhonePrice());
	}

}
