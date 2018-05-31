package modelo.acceso;

import java.io.File;
import java.io.FileOutputStream;

public class AlmacenRutas<T> {

	// La ruta comun a todos los archivos
	private StringBuilder pathComun = new StringBuilder("./data/");

	// Directorio se refiere a la carpeta de un determinado grupo de valores
	public AlmacenRutas(String directorio) {
		super();
		pathComun.append(directorio);
		File file = new File(pathComun.toString());
		if (!file.exists()) {
			file.mkdirs();
		}
	}

//	public T obtener(String claveElemento,String claveGrupo) {
//		//TODO
//	};

	public boolean grabar(T t,String claveElemento,String claveGrupo) {
		boolean retorno=false;
		pathComun.append("/"+claveGrupo);
		String ruta=pathComun.toString();
		pathComun.append("/"+claveElemento+".data");
		File elemento=new File(ruta);
		if(!elemento.exists()){
			retorno=elemento.mkdirs();
		}
		if(retorno)
			retorno=new DAO<>().grabar(pathComun.toString(), t);
		return retorno;
	};

}
