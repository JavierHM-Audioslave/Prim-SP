package main;

public class Prim {
	
	private VectorNodosSolucionados solucionados;
	private Grafo grafo;
	
	public Prim(Grafo grafo)
	{
		this.grafo = grafo;
		solucionados = new VectorNodosSolucionados(grafo.obtenerCantNodos());
	}
	
	public String[] resolver()
	{
		String[] dev = new String[grafo.obtenerCantNodos()];
		
		solucionados.agregarNodo("1"); // Cambiar ese 1 poro una variable que representa a un cierto nodo desde el cual quiero empezar si lo que busco es que se resuelva el Prim desde un nodo en concreto. //
		Integer costoAux;
		Integer costoTotal = 0;
		String nodoATomar;
		String nodoTomado;
		Integer i=null;
		
		for(i = 0; i<grafo.obtenerCantNodos(); i++)
		{
			String[] devDeMetodoBuscarAdyacenteMenor = buscarAdyacenteMenor();
			costoAux = Integer.parseInt(devDeMetodoBuscarAdyacenteMenor[0]);
			nodoATomar = devDeMetodoBuscarAdyacenteMenor[1];
			nodoTomado = devDeMetodoBuscarAdyacenteMenor[2];
			
			
			if(costoAux!=1000000)
			{
				dev[i] = nodoTomado+"-"+nodoATomar+"  Costo: "+costoAux;
				costoTotal += costoAux;
				if(solucionados.perteneceASolucion(nodoATomar))
				{
					solucionados.agregarNodo(nodoTomado);
				}
				else
				{
					solucionados.agregarNodo(nodoATomar);
				}
			}			
		}
		
		dev[i-1] = "Costo total: "+costoTotal;
		return dev;
	}
	
	
	private String[] buscarAdyacenteMenor()
	{		
		Integer costoAux = 1000000;
		String nodoATomar = null;
		String nodoTomado = null;
		for(int j = 0; j<solucionados.getPosicion(); j++)
		{
			int fila = solucionados.obtenerElSolucionadoDeLaPosicion(j)-1;
			for(int z = 0; z<grafo.obtenerCantNodos(); z++)
			{
				if(grafo.esDistintoA1000000(fila, z) && grafo.obtenerValor(fila, z)<costoAux && (!solucionados.perteneceASolucion(String.valueOf(fila+1)) || !solucionados.perteneceASolucion(String.valueOf(z+1))))
				{
					costoAux = grafo.obtenerValor(fila, z);
					if(solucionados.perteneceASolucion(String.valueOf(fila+1)))
					{
						nodoTomado = String.valueOf(fila+1);
						nodoATomar = String.valueOf(z+1);
					}
					else
					{
						nodoTomado = String.valueOf(z+1);
						nodoATomar = String.valueOf(fila+1);
					}					
				}
			}
		}
		
		String[] dev = new String[3];
		dev[0] = String.valueOf(costoAux);
		dev[1] = nodoTomado;
		dev[2] = nodoATomar;
		return dev;
	}

}
