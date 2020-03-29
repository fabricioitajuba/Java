/* Trabalhando com data e hora
 * Eng. Fabricio de Lima Ribeiro
 * 25/02/2019
 */
package datahora;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataHora {

	public static void main(String[] args) {
		
		Date data = new Date();

		SimpleDateFormat formatar = new SimpleDateFormat();
		String dataFormatada = formatar.format(data);
		System.out.println(dataFormatada);
		
		SimpleDateFormat formatar1 = new SimpleDateFormat("y");
		String dataFormatada1 = formatar1.format(data);
		System.out.println(dataFormatada1);
		
		SimpleDateFormat formatar2 = new SimpleDateFormat("dd/MM/yy");
		String dataFormatada2 = formatar2.format(data);
		System.out.println(dataFormatada2);		

		SimpleDateFormat formatar3 = new SimpleDateFormat("hh:mm:ss");
		String dataFormatada3 = formatar3.format(data);
		System.out.println(dataFormatada3);
		
		SimpleDateFormat formatar4 = new SimpleDateFormat("dd/MMM/yyyy");
		String dataFormatada4 = formatar4.format(data);
		System.out.println(dataFormatada4);				
	}

}
