package prZoologicoDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Animal a = new Animal ("Ardilla", "Bosque", 0.1);
		//AnimalDAO.insertAnimal(a);
		//AnimalDAO.deleteAnimal();
		//Animal b = new Animal ("kakapoo", "Bosque", 5);
		//AnimalDAO.insertAnimal(b);
		//AnimalDAO.deleteAnimalByNombre("ardilla");
		Animal a = AnimalDAO.findById(3);
		System.out.println(a);
	}

}
