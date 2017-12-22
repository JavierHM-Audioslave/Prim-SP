package main;

public class VectorNodosSolucionados {
	
	private String[] vecSolucionados;
	private Integer posicion;
	
	public VectorNodosSolucionados(Integer cantNodos)
	{
		vecSolucionados = new String[cantNodos];
		posicion = 0;
	}
	
	public void agregarNodo(String nodo)
	{
		vecSolucionados[posicion] = nodo;
		posicion++;
	}
	
	public boolean perteneceASolucion(String nodo)
	{
		for(int i = 0; i<posicion; i++)
		{
			if(vecSolucionados[i].equals(nodo))
			{
				return true;
			}
		}
		
		return false;
	}

	
	public Integer tamañoDeVectorSolucionados()
	{
		return vecSolucionados.length;
	}
	
	public Integer cantNodosAgregados()
	{
		Integer cant = 0;
		for(int i=0; i<vecSolucionados.length && vecSolucionados[i]!=null; i++)
		{
			cant++;
		}
		return cant;
	}
	
	
	public void resetearAtributos()
	{
		for(int i = 0; i<vecSolucionados.length; i++)
		{
			vecSolucionados[i] = "";
		}
		
		posicion = 0;
	}	
	
	public int getPosicion()
	{
		return posicion;
	}
	
	public Integer obtenerElSolucionadoDeLaPosicion(int j)
	{
		return Integer.parseInt(vecSolucionados[j]);
	}
}
