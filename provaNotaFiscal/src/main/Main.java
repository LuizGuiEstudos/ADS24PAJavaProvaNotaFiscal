package main;

import java.util.Scanner;

import entities.NotaFiscal;

public class Main {

	private static Scanner scan = new Scanner( System.in );
	
	public static void main(String[] args) {
		addNota();
		addNota();
		addNota();
		addNota();
		
		printNotas();
		printNotasSN();
		printNotasLP();
	}
	
	
	
	//CRUD
	private static void addNota() 
	{
		NotaFiscal nt;
		//ENTRADA
		String razaoSocial;
		String CNPJ;
		char regime;
		String email;
		String numeroFiscal;
		String dtEmissao;
		String descricao;
		double valor;
		
		
		System.out.println( " ### CADASTRO DE NOTA FISCAL ### " );
		
		System.out.println( "-Razão Social: " );
		System.out.print( "< " );
		razaoSocial = scan.next();
		
		System.out.println( "-CNPJ: " );
		System.out.print( "< " );
		CNPJ = scan.next();
		
		//TODO - verificação de char valido
		do {
			System.out.println( "-Regime Tributário[S-Simples Nacional, L-Lucro Presumido]: " );
			System.out.print( "< " );
			regime = scan.next().charAt(0);
			
		} while ( regime != NotaFiscal.getRISN() && regime != NotaFiscal.getRILP() );
		
		System.out.println( "-Email : " );
		System.out.print( "< " );
		email = scan.next();
		
		System.out.println( "-Numero Fiscal : " );
		System.out.print( "< " );
		numeroFiscal = scan.next();
		
		System.out.println( "-Data Emissão : " );
		System.out.print( "< " );
		dtEmissao = scan.next();
		
		System.out.println( "-Descrição : " );
		System.out.print( "< " );
		descricao = scan.next();
		
		System.out.println( "-Valor: " );
		System.out.print( "< " );
		valor = scan.nextInt();
		//ADD
		nt = new NotaFiscal(razaoSocial, CNPJ, regime, email, numeroFiscal, dtEmissao, descricao, valor);
		NotaFiscal.addNota(nt);
		
		System.out.println();
		
		System.out.println( ">A seguinte nota fiscal foi registrada: " );
		NotaFiscal.printNota(nt);
	}
	
	
	
	private static void printNotas() 
	{
		System.out.println( " ### PRINTANDO NOTAS FISCAIS ### " );
		NotaFiscal.printNotas();
	}
	private static void printNotasSN() {
		System.out.println( " ### PRINTANDO NOTAS FISCAIS - SIMPLES NACIONAL ### " );
		NotaFiscal.printNotasSN();
	}
	private static void printNotasLP() {
		System.out.println( " ### PRINTANDO NOTAS FISCAIS - LUCRO PRESUMIDO ### " );
		NotaFiscal.printNotasLP();
	}
	
	
}
