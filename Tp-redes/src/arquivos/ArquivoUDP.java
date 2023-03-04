package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUDP {

	public List<File> listarArquivos(File diretorio) {
		List<File> listaArquivos = new ArrayList<>();
		try {
			for (File f : diretorio.listFiles()) {
				if (f.isDirectory()) {
					listaArquivos.add(f);
				}
			}
		} catch (Exception e) {
			System.out.println("O diretorio informado inexiste");
			e.printStackTrace();
		}
		return listaArquivos;
	}

	public static void uploadFile(String localFilePath, String serverUrl) throws IOException {
		File file = new File(localFilePath);
		URL url = new URL(serverUrl);
		URLConnection conn = url.openConnection();

		// Configura a conexão HTTP para permitir carregar dados
		conn.setDoOutput(true);

		// Obtenha o fluxo de saída da conexão HTTP
		OutputStream out = conn.getOutputStream();

		// Cria um fluxo de entrada do arquivo local
		FileInputStream in = new FileInputStream(file);

		// Copia o conteúdo do arquivo local para o fluxo de saída da conexão HTTP
		byte[] buffer = new byte[1024];
		int bytesRead = -1;
		while ((bytesRead = in.read(buffer)) != -1) {
			out.write(buffer, 0, bytesRead);
		}

		// Fecha os fluxos de entrada e saída
		in.close();
		out.close();
	}

	public static void downloadFile(String serverUrl, String localFilePath) throws IOException {
		URL url = new URL(serverUrl);
		URLConnection conn = url.openConnection();

		// Obtenha o tamanho do arquivo para monitorar o progresso do download
		int fileSize = conn.getContentLength();

		// Obtenha o fluxo de entrada da conexão HTTP
		InputStream in = conn.getInputStream();

		// Crie um fluxo de saída do arquivo local
		FileOutputStream out = new FileOutputStream(localFilePath);

		// Copia o conteúdo do fluxo de entrada HTTP para o arquivo local
		byte[] buffer = new byte[1024];
		int bytesRead = -1;
		int totalBytesRead = 0;
		while ((bytesRead = in.read(buffer)) != -1) {
			out.write(buffer, 0, bytesRead);
			totalBytesRead += bytesRead;
			System.out.println("Downloaded " + totalBytesRead + " of " + fileSize + " bytes.");
		}

		// Fecha os fluxos de entrada e saída
		in.close();
		out.close();
	}
}