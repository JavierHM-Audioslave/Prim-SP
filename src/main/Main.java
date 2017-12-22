package main;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		File archIn = new File("in2.txt");
		Scanner sc;
		Grafo grafo=null;		
		try
		{
			sc = new Scanner(archIn);
			grafo = new Grafo(sc.nextInt(), sc.nextInt());
			grafo.cargarGrafoNodirigido(sc);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}

		Prim prim = new Prim(grafo);
		String[] dev = prim.resolver();
		for(int i = 0; i<dev.length; i++)
		{
			System.out.println(dev[i]);
		}
	}

}
