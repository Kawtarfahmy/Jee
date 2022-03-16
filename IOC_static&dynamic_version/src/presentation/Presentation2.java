package presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.IDao;
import metier.IMetier;

public class Presentation2 {
       // Version Dynamic
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException 
	{
		Scanner sc = new Scanner(new File("config.txt"));
       	String daoClassName = sc.nextLine();
		Class cDao = Class.forName(daoClassName);
		IDao dao =(IDao)cDao.newInstance();
		//System.out.println("Result = "+dao.getData());
		
		String metierClassName = sc.nextLine();
		Class cMetier = Class.forName(metierClassName);
		IMetier metier =(IMetier)cMetier.newInstance();
		
		Method method = cMetier.getMethod("setDao", IDao.class);
		method.invoke(metier, dao);
		System.out.println("Result = "+metier.calcul());
	}
}
