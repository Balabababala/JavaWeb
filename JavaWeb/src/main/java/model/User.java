package model;

import java.util.Map;

public class User {
	private String userName;
	private String gender;
	private Integer age;
	private Double height;
	private Double weight;
	private Double bmiValue;
	private String bmiResult;
	
	
	
	public User(String userName,String gender,String age,String height,String Weight) {
		this.userName=userName;
		this.gender=gender;
		this.age=Integer.parseInt(age);
		this.height=Double.parseDouble(height);
		this.weight=Double.parseDouble(Weight);
		//計算Bmi
		this.bmiValue=this.weight/Math.pow(this.height/100, 2);
		setBmiResult(gender,bmiValue);
		
	}
	
	public void setBmiResult(String gender,Double bmiValue) {
		if(gender.equals("男")) {
			if(bmiValue>23.3) {
				bmiResult="過胖";
			}else if(bmiValue>17.3) {
				bmiResult="正常";
			}else {
				bmiResult="過瘦";
			}
		}else{
			if(bmiValue>22.7) {
				bmiResult="過胖";
			}else if(bmiValue>17) {
				bmiResult="正常";
			}else {
				bmiResult="過瘦";
			}
		}
	}
	
	
	public String getUserName() {
		return userName;
	}
	public String getGender() {
		return gender;
	}
	public Integer getAge() {
		return age;
	}
	public Double getHeight() {
		return height;
	}
	public Double getWeight() {
		return weight;
	}
	public Double getBmiValue() {
		return bmiValue;
	}
	
	public String getBmiResult() {
		return bmiResult;
	}
	@Override
	public String toString() {
		return "User [username=" + userName + ", gender=" + gender + ", age=" + age + ", height=" + height + ", weight="
				+ weight + ", bmiValue=" + bmiValue + "]";
	}

	

	
	
}
