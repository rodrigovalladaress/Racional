
public class Racional {
	
	private Integer a;
	private Integer b;
	
	public String toString() {
		return get_a() + "/" + get_b();
	}
	
	public Racional suma(Racional b) {
		return new Racional(get_a() * b.get_b() + b.get_a() * get_b(), get_b() * b.get_b()).simplificar();
	}
	
	public Racional resta(Racional b) {
		return suma(new Racional(-b.get_a(), b.get_b())).simplificar();
	}
	
	public Racional producto(Racional b) {
		return new Racional(get_a() * b.get_a(), get_b() * b.get_b()).simplificar();
	}
	
	public Racional division(Racional b) {
		return new Racional(get_a() * b.get_b(), get_b() * b.get_a()).simplificar();
	}
	
	
	private Racional simplificar() {
		int i = 2;
		while((i < 100) && i <= get_a() && i <= get_b()) {
			if((get_a() % i == 0) && (get_b() % i == 0)) {
				set_a(get_a() / i);
				set_b(get_b() / i);
				i = 2;
			}
			else
				i++;
		}
		return this;
	}
	
	
	public void set_a(Integer a) {
		this.a = a;
	}
	public void set_b(Integer b) {
		this.b = b;
	}
	public int get_a() {
		return (int)a;
	}
	public int get_b() {
		return (int)b;
	}
	
	Racional(Integer a, Integer b) {
		this.a = a;
		if(b != 0)
			this.b = b;
		else {
			System.out.println("El denominador no puede ser 0");
			this.b = 4967;
		}
		Racional simplificado = simplificar();
		this.a = simplificado.get_a();
		this.b = simplificado.get_b();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Racional rac = new Racional(4,8);
		Racional rac2 = new Racional(4,5);
		System.out.println(rac.toString());
		System.out.println(rac.producto(rac2).toString());
		System.out.println(rac.suma(rac2).toString());

	}

}
