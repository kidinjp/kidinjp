package jp.webschool.java.chapter11;

/**
 * スーパークラス（親クラス）
 */
class ParentClass {
	public void a() {
		System.out.println("ParentClass#a()");
	}

	protected void b() {
		System.out.println("ParentClass#b()");
	}

	void c() {
		System.out.println("ParentClass#c()");
	}

	private void d() {
		System.out.println("ParentClass#d()");
	}

	public void execParent() {
		a();
		b();
		c();
		d();
	}

}

class ChildClass extends ParentClass {
	public void a() {
		System.out.println("ChildClass#a()");
	}

	protected void b() {
		System.out.println("ChildClass#b()");
	}

	// もしどちらかのクラスが異なるパッケージに属する場合オーバーライドされません
	void c() {
		System.out.println("ChildClass#c()");
	}

	private void d() {
		System.out.println("ChildClass#d()");
	}

	public void execChild() {
		a();
		b();
		c();
		d();
	}
}

public class Sample11_04 {

	/**
	 *  11_09
	 * @param args
	 */
	public static void main(String[] args) {
		ParentClass p = new ParentClass();
		ChildClass c = new ChildClass();
		System.out.println("結果 1. [ParentClass インスタンスの execParent() メソッド]");
		p.execParent();
		System.out.println("結果 2. [ChildClass インスタンスの execParent() メソッド]");
		c.execParent(); // d()はprivateなのでオーバーライドされていません
		System.out.println("結果 3. [ChildClass インスタンスの execChild() メソッド]");
		c.execChild();

	}

}
