package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    
	private IDao dao;
	
	//Injection des dependances en utilisant des constructeurs
	/*public MetierImpl() {
	}

	public MetierImpl(IDao dao) {
		this.dao = dao;
	}*/

	@Override
	public double calcul() {
		double data = dao.getData();
		double result = data*2*Math.cos(data);
		return result;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

}
