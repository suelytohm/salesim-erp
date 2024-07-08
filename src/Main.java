import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class Main {
	
	/* Variáveis */
	private static final DateFormat sdf = new SimpleDateFormat("yyMMdd_HHmm");
	String tipo;
	String data;
	String nome;
	String caminho;
	
	
	public Main(String tipo, String data, String nome, String caminho) {
		super();
		this.tipo = tipo;
		this.data = data;
		this.nome = nome;
		this.caminho = caminho;
	}

	/* Método para dar nome ao arquivo pegando a data/hora atual. */
	public static String data() 
	{		
        Calendar cal = Calendar.getInstance();
        return sdf.format(cal.getTime());	
	}
	
	/* Método para definir o caminho a ser gravado. */
	public static String caminhoGravacao() 
	{		
        return "C://iqsistemas//salesim//";	
	}	
	
	public static String getNome(String tipo) 
	{		
		if(tipo == "USERS")
		{
			return "USERS_ " + data() + ".csv";
		}
		else if(tipo == "KPI")
		{
			return "KPI_ " + data() + ".csv";
		}
		else if(tipo == "KPI_USERS")
		{
			return "KPI_USERS_ " + data() + ".csv";
		}		
		else
		{
			return "Erro";
		}
        
	}		
	
	/* Método para realizar a gravação do arquivo, pegando seu TIPO, seu NOME(data) e as informações a serem gravadas. */
	public static void GravarArquivo(String tipoArquivo, String caminho)//, dados, 
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
				for(int i = 0; i < 10; i++)
				{
					ar.println("ID_USERS ; USERNAME ; FULL_NAME ; EMAIL ; PHONE ; TYPE ; VISIBLE ; DATE_TIME");
				}	

			}
			
			/* KPI */
			else if(tipoArquivo == "KPI")
			{
				for(int i = 0; i < 10; i++)
				{
					ar.println("ID_KPI ; NAME ; WEIGHT ; GOAL_DAILY ; GOAL_WEEKLY ; GOAL_MONTHLY ; VISIBLE ; DATE_TIME");
				}					
			}
			
			else if(tipoArquivo == "KPI_USERS")
			{
				for(int i = 0; i < 10; i++)
				{
					ar.println("ID_KPI ; ID_USERS ; AMOUNT ; DATE_TIME");
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
		GravarArquivo("USERS", caminhoGravacao());	
		GravarArquivo("KPI", caminhoGravacao());		 
		GravarArquivo("KPI_USERS", caminhoGravacao());
		
		JOptionPane.showMessageDialog(null, "Arquivos Gerados Com Sucesso!");
	}
	
}