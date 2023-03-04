package arquivos;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArquivoUDP arquivoUDP = new ArquivoUDP();

	    // listar diretórios
	    List<File> listaDiretorios = arquivoUDP.listarArquivos(new File("/Users/deborahcaroline/"));
	    for (File diretorio : listaDiretorios) {
	        System.out.println(diretorio.getName());
	    }

	    // enviar arquivo
	    try {
	        arquivoUDP.uploadFile("/caminho/do/arquivo/local", "http://endereco/do/servidor");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // baixar arquivo
	    try {
	        arquivoUDP.downloadFile("http://endereco/do/arquivo/remoto", "/caminho/do/arquivo/local");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}


