package entities;

import java.util.ArrayList;

public class NotaFiscal {
	
	private static char regimeIndiceSimplesNacional = 's';
	public static char getRISN() {
		return regimeIndiceSimplesNacional;
	}
	private static char regimeIndiceLucroPresumido = 'l';
	public static char getRILP() {
		return regimeIndiceLucroPresumido;
	}
	public static ArrayList<NotaFiscal> notasFiscais = new ArrayList<NotaFiscal>();
	public static ArrayList<NotaFiscal> notasFiscaisSN = new ArrayList<NotaFiscal>();
	public static ArrayList<NotaFiscal> notasFiscaisLP = new ArrayList<NotaFiscal>();
	
	public String razaoSocial;
	public String CNPJ;
	public char regime;
	public String email;
	public String numeroFiscal;
	public String dtEmissao;
	public String descricao;
	public double tributacao;
	public double valor;
	public double valorTotal;
	
	private static int countId; 
	private int id;
	
	public NotaFiscal(String razaoSocial, String cNPJ, char regime,  String email, String numeroFiscal, String dtEmissao,
			String descricao, double valor) {
		id = countId++;
		
		this.razaoSocial = razaoSocial;
		CNPJ = cNPJ;
		this.regime = regime;
		
		
		this.email = email;
		this.numeroFiscal = numeroFiscal;
		this.dtEmissao = dtEmissao;
		this.descricao = descricao;
		this.valor = valor;
		
		//CALCULAR IMPOSTO
		this.tributacao = calcImposto(this);
		this.valorTotal = valor + tributacao;
	}
	public NotaFiscal() {
	}
	
	//CRUD
 	public static void addNota( NotaFiscal nt ) 
	{
 		notasFiscais.add(nt);
 		//REGIME LISTA
 		if( nt.regime == regimeIndiceSimplesNacional ) {
			addNotaSN(nt);
		} else if( nt.regime == regimeIndiceLucroPresumido ) {
			addNotaLP(nt);
		}
	}
 	

 	public static void printNotas() 
 	{
 		for( NotaFiscal nt : notasFiscais ) 
 		{
 			printNota( nt );
 		}
 	}
 	public static void printNotasSN() 
 	{
 		for( NotaFiscal nt : notasFiscaisSN ) 
 		{
 			printNota( nt );
 		}
 	}
 	public static void printNotasLP() 
 	{
 		for( NotaFiscal nt : notasFiscaisLP ) 
 		{
 			printNota( nt );
 		}
 	}
 	public static void printNota( NotaFiscal nt )
 	{
 		System.out.println( ">Nota Fiscal ID: " + nt.id );
 		System.out.println( "  .razaoSocial: " + nt.razaoSocial );
 		System.out.println( "  .regime: " + nt.regime );
 		System.out.println( "  .descrição: " + nt.descricao );
 		System.out.println( "  .valor: " + nt.valor );
 		System.out.println( "  .tributação: " + nt.tributacao );
 		System.out.println( "  .valor total: " + nt.valorTotal );
 		
 	}
 	
 	private static void addNotaSN( NotaFiscal nt ) 	{
 		notasFiscaisSN.add(nt);
 	}
 	private static void addNotaLP( NotaFiscal nt ) {
 		notasFiscaisLP.add(nt);
 	}
 	
 	//FUNCIONALIDADES
 	private static double calcImposto( NotaFiscal nt ) {
 		double valorDoImposto;
 		
 		double impostoSN = 6.5 / 100;
 		double impostoLP = 12.0 / 100;
 		
 		//DECIDIR TIPO DE IMPOSTO
 		if( nt.regime == 's' ) 
 		{
 			valorDoImposto = nt.valor * impostoSN; 
 		} else {
 			valorDoImposto = nt.valor * impostoLP; 		
 		}
 		//CALCULAR
 		return valorDoImposto;
 	}
	
}
