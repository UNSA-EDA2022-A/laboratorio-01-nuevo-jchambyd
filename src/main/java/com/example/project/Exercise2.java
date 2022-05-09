package com.example.project;

import java.util.Scanner;

public class Exercise2 {

	public static void main(final String[] args) {

		Exercise2 obj = new Exercise2();
		Scanner sc = new Scanner(System.in);
		while (true) {

            int a [] = new int [7];
            for(int i = 0; i < 7; i++){
                int n = sc.nextInt();
                a[i] = n;
            }
			
			System.out.println(obj.getMenorNumeroSaltos(a));			
		}
	}

	public Integer getMenorNumeroSaltos(int a []) {

		int NUM_PEDRAS = 7, MAX_SALTO = 50;

		int saltos[], i;
		saltos = new int[NUM_PEDRAS + 1];

		saltos[0] =0;
		for (i = 1; i <= NUM_PEDRAS; i++)
			saltos[i] = a[i - 1];

		int num_saltos = 0, // Numero de saltos que o coelho ja deu
				ultima_pos = 0; // Ultima posicao na qual o coelho saltou

		for (i = 1; i <= NUM_PEDRAS; i++) {
			// Revisamos se o coelho consegue chegar a seguinte pedra (desde sua ultima
			// posicao)
			if (saltos[i] - saltos[ultima_pos] <= MAX_SALTO) {
				// Se ja chegou a ultima pedra, entao conseguiu chegar ao outro lado do rio
				if (i == NUM_PEDRAS) {
					// Tem que dar o salto final
					num_saltos++;
				} else {
					// Revisamos se o coelho poderia saltar ate a seguinte pedra
					if (saltos[i + 1] - saltos[ultima_pos] > MAX_SALTO) {
						// Se nao consegue, obrigatoriamente tem que saltar a posicao atual
						ultima_pos = i;
						num_saltos++;
					}
				}
			} else {
				// Como o coelho nao consegue chegar a seguinte pedra, entao nao podera cruzar o
				// rio
				num_saltos = -1;
			}
		}

		return num_saltos;
	}
}
