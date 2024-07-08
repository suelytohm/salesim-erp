package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Model.KPI;
import Model.Users;

public class ArquivoKPI {
	
	KPI k = new KPI();
	
	// Verifica se a pasta existe.
	public Boolean existePasta()
	{
		
		File pasta = new File("C://iqsistemas//salesim//");
		
		if(pasta.exists())
		{
			return true;
		}
		else
		{
			return false;
		}
	}	
	
	// Criar pasta
	public Boolean criarPasta()
	{
		if(existePasta())
		{
//			JOptionPane.showMessageDialog(null, "O caminho informado já existe!");
			return true;
		}
		else
		{
			new File("C://iqsistemas//salesim//").mkdir();
			JOptionPane.showMessageDialog(null, "A pasta foi criada com sucesso!");			
			return true;
		}
	}
	
	// Criar arquivo de configuração do KPI.
	public void criarKPI(int id_kpi, String name, double weight, double goal_daily, double goal_weekly, double goal_monthly, Boolean visibilidade, String date)
	{
		if(existePasta())
		{
			try
			{
				/* Início da gravação */
				FileOutputStream arquivo = new FileOutputStream("C://iqsistemas//salesim//config.csv");
				PrintWriter ar = new PrintWriter(arquivo);
						
				/* Dados a serem gravados */
				ar.println(id_kpi +";"+ name +";"+ weight +";"+ goal_daily +";"+ goal_weekly +";"+ goal_monthly +";"+ visibilidade +";"+ date);

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
		else
		{
			criarPasta();
			JOptionPane.showMessageDialog(null, "Os arquivos de configuração foram gerados, por favor tente novamente!");
		}
	}
	
	// Ler KPI separado
	public String lerKPI(int i)
	{
		if(existePasta()) 
		{
			File arquivoConfig = new File("C://iqsistemas//salesim//config.csv");	
			try 
			{
				String linhasArquivo = new String();
				Scanner leitor = new Scanner(arquivoConfig);			
				while(leitor.hasNext())
				{
					linhasArquivo = leitor.nextLine();
					String[] valoresKPI = linhasArquivo.split(";");				
					return(valoresKPI[i]);
				}
			}
			catch(FileNotFoundException ex)
			{
				JOptionPane.showMessageDialog(null, "Erro na leitura do Arquivo");
			}		
			return "Erro";
		}
		else
		{
			criarPasta();
			JOptionPane.showMessageDialog(null, "Os arquivos de configuração foram gerados, por favor tente novamente!");		
			return null;
		}		
	}
	
		
	public String lerKPIjunto()
	{
		if(existePasta()) 
		{
			File arquivoConfig = new File("C://iqsistemas//salesim//config.csv");	
			try 
			{
				String linhasArquivo = new String();
				Scanner leitor = new Scanner(arquivoConfig);			
				while(leitor.hasNext())
				{
					linhasArquivo = leitor.nextLine();
					return linhasArquivo;
				}
			}
			catch(FileNotFoundException ex)
			{
				JOptionPane.showMessageDialog(null, "Erro na leitura do Arquivo");
			}		
			return "Erro";
		}
		else
		{
			criarPasta();
			JOptionPane.showMessageDialog(null, "Os arquivos de configuração foram gerados, por favor tente novamente!");		
			return null;
		}		
	}	
	
}
