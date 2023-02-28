package arquivos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUDP {

	public List<File> listarArquivos(File diretorio) {
			
			List<File> listaArquivos = new ArrayList<>();
			
			try {
				
				for(File f : diretorio.listFiles()) {
					if(f.isDirectory()) {
						listaArquivos.add(f);
					}	
				}
				
			} catch (Exception  e) {
				System.out.println("O diretorio informado inexiste");
				e.printStackTrace();
			}
			
			return listaArquivos;
		}
	
	
	public static void EnviarArquivo(String pasta, String nomeArquivo) {
		
		
	}

	
	public void main(String[] args) {
        ArrayList<File> list = (ArrayList<File>) listarArquivos(new File("/Users/deborahcaroline"));
        for(File i : list) {
            System.out.println(i);
        }
    }
}
