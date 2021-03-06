import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GestorRutas {

	Map<Ruta,List<Tramo>> ruta;
	
	private class Tramo {
		String start;
		String end;
		
		public Tramo(String start, String end){
			this.start = start;
			this.end = end;
		}
	}
	
	private class Ruta {
		String origen;
		String destino;
		
		public Ruta(String origen, String destino){
			this.origen = origen;
			this.destino = destino;
		}
		
		@Override
		public int hashCode(){
			return Objects.hash(this.origen,this.destino);
		}
	}
	
	public GestorRutas(){
		ruta = new HashMap<>();
	}
	
	
	public void insercionTramos(String[] paradas){
		assert paradas.length > 0 && paradas.length % 2 == 0 : "Se necesita al menos un tramo y paradas pares";
		Ruta aIncertar = new Ruta(paradas[0],paradas[1]);
		List<Tramo> tramos = new LinkedList<>();
		if(paradas.length == 2){ 
			tramos.add(new Tramo(paradas[0],paradas[1]));
			ruta.put(aIncertar, tramos);
		}else{
			String destino = paradas[1];
			for(int i =paradas.length-1; i>1;i++){
				String actual = paradas[i];
				tramos.add(new Tramo(actual,destino)); // La lista siempre tendrá el recorrido inverso
				destino = actual;
			}
			ruta.put(aIncertar, tramos);
		}
	}
	
	public List<String> paradasIntermedias (String origen, String destino){
		Ruta ruta = new Ruta(origen,destino);
		if(!this.ruta.containsKey(ruta) || this.ruta.get(ruta).size()==1){ 
			// Si no hay rutas o solo hay un vaje directo no hay intermedias
			return new ArrayList<>();
		}
		List<Tramo> tramos = this.ruta.get(ruta);
		List<String> intermedias = new ArrayList(tramos.size());
		Iterator<Tramo> it = tramos.iterator();
		while(it.hasNext()){
			Tramo next = it.next();
			if(next.start != origen)
				intermedias.add(next.start);
		}
		Collections.reverse(intermedias); //La lista está al revés
		return intermedias;		
	}
	
}
