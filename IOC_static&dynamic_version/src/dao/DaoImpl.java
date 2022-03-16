package dao;

public class DaoImpl implements IDao {

	@Override
	public double getData() {
		// BD
		System.out.println("******* Database Version ******** ");
		double data = Math.random()*40;
		return data;
	}

}
