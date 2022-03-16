package extension;

import dao.IDao;

public class DaoImpl2 implements IDao{
	
	@Override
	public double getData() {
		// BD
		System.out.println("******* Capteurs Version ******** ");
		double data = Math.random()*40;
		return data;
	}
}
