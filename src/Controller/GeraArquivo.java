package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import Model.KPI;
import Model.Users;


public class GeraArquivo {

	
		/* Variáveis */
		private static final DateFormat sdf = new SimpleDateFormat("yyMMdd_HHmm");
		private String tipo;
		private String data;
		private String nome;
		private String caminho;
		private List<Users> Rusers;
		
		public GeraArquivo(String tipo, String data, String nome, String caminho)
		{
			super();
			this.tipo = tipo;
			this.data = data;
			this.nome = nome;
			this.caminho = caminho;
		}
	
		public static String setData() 
		{		
	        Calendar cal = Calendar.getInstance();
	        return sdf.format(cal.getTime());	
		}	
		
		
		/* Método para dar nome ao arquivo pegando a data/hora atual. */
		public static String getData() 
		{		
	        Calendar cal = Calendar.getInstance();
	        return sdf.format(cal.getTime());	
		}
		
		/* Método para definir o caminho a ser gravado. */
		public static String caminhoGravacao() 
		{	
			File pasta = new File("C://iqsistemas//salesim//files//");
			
			if(!pasta.exists())
			{
				new File("C://iqsistemas//salesim//files//").mkdir();
			}
			return "C://iqsistemas//salesim//files//";
		}
		
		// Método que retorna a inicial do arquivo
		public static String getNome(String tipo) 
		{		
			if(tipo == "USERS")
			{
				return "USERS_ " + getData() + ".csv";
			}
			else if(tipo == "KPI")
			{
				return "KPI_ " + getData() + ".csv";
			}
			else if(tipo == "KPI_USERS")
			{
				return "KPI_USERS_ " + getData() + ".csv";
			}		
			else
			{
				return "Erro";
			}
	        
		}		
		
		/* Método para realizar a gravação do arquivo, pegando seu TIPO, seu NOME(data) e as informações a serem gravadas. */
		public static void GravarArquivo(String tipoArquivo, String caminho, List<Users> users)//, dados, 
		{
			/* Bloco TRY tenta realizar a gravação do arquivo */
			try
			{
				/* Início da gravação */
				FileOutputStream arquivo = new FileOutputStream(caminho + getNome(tipoArquivo));
				PrintWriter ar = new PrintWriter(arquivo);
						
				/* Dados a serem gravados */

				/* USERS */
				if(tipoArquivo == "USERS")
				{
					
					for(Users u : users)
					{
						ar.println(u.getid_users() + ";" + 
						u.getUsername() + ";" + 
						u.getFullname() + ";" + 
						u.getEmail() + ";" + 
						u.getPhone() + ";" + 
						u.getType() + ";" + 
						u.getVisibilidade() + ";" + 
						u.getDate_time());
					}
				}
				
				else if(tipoArquivo == "KPI")
				{
					ArquivoKPI ak = new ArquivoKPI();
					ar.println(ak.lerKPIjunto());
				}

				else if(tipoArquivo == "KPI_USERS")
				{
					for(Users u : users)
					{
						ArquivoKPI ak = new ArquivoKPI();
						ar.println(u.getid_users() + ";" +
						ak.lerKPI(0) + ";" +
						// amount + ";" +
						ak.lerKPI(3) + ";" +
						ak.lerKPI(4) + ";" +
						ak.lerKPI(5) + ";" +
						u.getDate_time());
					}
				}
						
				/* Finaliza a gravação */
				ar.close();
				arquivo.close();
			}
			
			/* Bloco CATCH informa o ERRO durante a gravação do arquivo */
			catch(Exception e)
			{
				System.out.println("Erro na gravação do arquivo: " + e);
			}
		}
		
		public static void main(String[] args)
		{

			List<Users> resultados = new ArrayList<Users>();
  			UsersController uc = new UsersController();
  			resultados = uc.buscarUsers();
  			  			
			GravarArquivo("USERS", caminhoGravacao(), resultados);
			GravarArquivo("KPI", caminhoGravacao(), resultados);		 
//			GravarArquivo("KPI_USERS", caminhoGravacao(), resultados);
			
		
			
		}


	}