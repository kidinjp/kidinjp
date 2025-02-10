package jp.webschool.java.chapter10;

/**
 * 
 * 【課題１】 カプセル化
 * クラスのカプセル化を行います。
 * 現在の Actor クラスはカプセル化されていない状態です。
 * そこで、このクラスをカプセル化されたクラスになるように修正してください。
 * カプセル化といえば、「情報の隠蔽」と「アクセサ」ですね！
 * 
 * 役者クラス
 */
public class Actor {
	/** 名前 */
	private String name;
	/** 年齢 */
	private int age;
	/** 身長 */
	private double height;
	/** 体重 */
	private double weight;

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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	/*
	 * 【課題２】 コンストラクタ
	 * 課題内容
	 * Actor クラスにコンストラクタを定義します。
	 * 以下のコンストラクタを定義してください。
	 * ・引数なしのコンストラクタ
	 * ・引数２つで「String、int」のコンストラクタ
	 * ・引数４つで「String、int、double、double」のコンストラクタ
	 */

	/**
	 * 引数なしのコンストラクタ
	 */
	public Actor() {
		name = "匿名";
		age = 20;
		height = 170;
		weight = 62;
	}

	/**
	 * 引数２つで「String、int」のコンストラクタ
	 */
	public Actor(String name, int age) {
		this.name = name;
		this.age = age;
		height = 170;
		weight = 62;
	}

	/**
	 * 引数４つで「String、int、double、double」のコンストラクタ
	 */
	public Actor(String name, int age, double height, double weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
}