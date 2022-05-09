package com.example.project;

import java.util.Scanner;

public class Exercise1 {

	public static void main(final String[] args) {

		Exercise1 obj = new Exercise1();
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			System.out.println(obj.convertirBaseGabriel(n));			
		}
	}

	public String convertirBaseGabriel(int numero) {

		int num_decimal = 0, digito, contador = 1, n; 
		int es_gabriel = 1, min_significativo = 0; //Nao = 0 - Sim = 1	
	
		//Avaliando que seja numero en base gabriel
		while(numero > 0)
		{
			digito = numero % 10;
			
			//Revisamos se o digito e diferente de 0 e 1
			if(digito != 0 && digito != 1 && !(digito == 2 && min_significativo == 0))
			{				
				es_gabriel = 0;
			}

			//Se ja foi achado um digito 1, ja se tem o digito menos significativo diferente de 0
			if(digito == 1)
			{
				min_significativo = 1;
			}
			
			int tmp = (int) Math.pow(2, contador);
			num_decimal = num_decimal + digito * (tmp - 1);
			contador = contador + 1;			
			
			numero = numero / 10;
		}
		
		//imprimindo a saida
		if(es_gabriel == 1)
			return "" + num_decimal;	
		else
			return "El numero proporcionado no esta en base Gabriel.";
	}
}
