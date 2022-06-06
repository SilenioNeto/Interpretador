package me.silenio;

import java.util.Scanner;

public class Metodos {
	static Scanner sc = new Scanner(System.in);
	public static String command;
	public static String[] sendedCommand = new String[100];
	public static char[] chars = new char[100];

	public static String[] commands= {"SOME","SOMA","SOMAR","DIVIDIR","DIVIDA","SUBTRAIR","SUBTRAIA","MULTIPLICAR","MULTIPLIQUE","MATRIZ", "ORDENAR"};
	public static String[] scommand= {};

	public static String[] readCommand() {

		command = sc.nextLine();
		command = command.replaceAll("\\s+"," ");
		for(int x=0;x<command.length();x++) {
			command = uppercase(command);
			char charac = command.charAt(x);
			chars[x]=charac;
			System.out.println("["+chars[x]+"]");
		}
		System.out.println("Sended command:"+"["+command+"]");
		scommand = command.split(" ");
		return scommand;
	}

	public static void print() {
		for(String command : scommand) {
			System.out.println(command);

		}
	}

	public static String uppercase(String comamand) {
		String result="";

		for(char command1 : command.toCharArray()) {
			char letter = command1;
			if(letter>=97 && letter<=122) {
				letter -=32;
			}
			result +=letter;
		}

		return result;
	}


	public static void showCommands() {
		System.out.println("*=========================*");
		System.out.println("\s\s\s\sAccepted commands: ");
		for(String showCommands : commands) {
			System.out.println("\s\s\sº"+showCommands);
		}
		System.out.println("*=========================*");
		System.out.println("If send command Matriz use (colum,line,reason,first number of reason");
		System.out.println("*=========================*");
	}

	public static void validateCommand() {
		int z = 0;
		for(int x=0; x<commands.length; x++) {

			while(scommand[0].equals(commands[x])) {
				System.out.println("Solicited command:" + scommand[0]);
				z++;
				break;
			}			
		}
		if(z==0) {
			System.out.println("\r Command not found");
		}
	}

	public static void calculate() {
		int number1=0;
		int number2=0;
		int result=0;
		String calculate=scommand[0];
		switch(calculate) {

		case "SOMAR","SOME","SOMA":

			System.out.println("Selected addition operation.");
		int addition = 0;
		for(int x = 1;x<scommand.length;x++) {		
			int number = Integer.parseInt(scommand[x]);
			addition+=number;
		}
		System.out.println("Operation result: "+ addition);

		break;
		case "SUBTRAIR","SUBTRAIA":
			System.out.println("Selected subtraction operation.");

		number1= Integer.parseInt(scommand[1]);
		number2= Integer.parseInt(scommand[2]);
		result = number1 - number2;
		System.out.println("Operation result: " +result );

		break;
		case "DIVIDIR","DIVIDA":
			System.out.println("Selected division operation.");

		number1= Integer.parseInt(scommand[1]);
		number2= Integer.parseInt(scommand[2]);
		result  = number1/number2;
		System.out.println("Operation result: " +result );

		break;
		case "MULTIPLICAR","MULTIPLIQUE":
			System.out.println("Selected multiplication operation.");
		number1= Integer.parseInt(scommand[1]);
		number2= Integer.parseInt(scommand[2]);
		result  = number1 * number2;
		System.out.println("Operation result: " +result );
		break;
		case "MATRIZ":

			int nlinha = Integer.parseInt(scommand[1]);
			int ncoluna = Integer.parseInt(scommand[2]);
			int inicio = Integer.parseInt(scommand[3]);
			int razao = Integer.parseInt(scommand[4]);
			int[][] matriz = new int[nlinha][ncoluna];
			for(int linha=0;linha<nlinha;linha++){
				for(int coluna=0;coluna<ncoluna;coluna++){
					matriz[linha][coluna]=inicio;
					inicio+=razao;
				}
			}
			print(matriz);

			break;
 // PROBLEMAO AQUI
		case "ORDENAR":
			int scommandlenght = scommand.length;
			int[] vetor = new int[scommandlenght];
			for(int x=1; x< vetor.length;x++){
				for(int i = 0; i < vetor.length; i++){
					int number = Integer.parseInt(scommand[x]);
					vetor[i] = number;
					System.out.println(vetor[i]);
				}
			}
			//BUBBLE SORT O(N^2)
			int aux;
			for(int i = 0; i < vetor.length; i++){ // O(N)
				for(int j = i + 1; j < vetor.length; j++){ //O(N)
					if (vetor[i] > vetor[j]){
						aux = vetor[j];
						vetor[j] = vetor[i];
						vetor[i] = aux;
					}
				}
			}



			System.out.println("Vetor ordenado");
			for(int i = 0; i < vetor.length; i++){
				System.out.println(vetor[i]);
			}



			break;
		}
	}



	public static void print(int [][]matriz){
		for(int linha=0;linha<matriz.length;linha++){
			System.out.print(" [ ");
			for(int coluna=0;coluna<matriz[linha].length;coluna++){
				System.out.print(+matriz[linha][coluna]+" ");
			}
			System.out.println(" ] ");
		}
	}


	public static void exec() {
		showCommands();
		readCommand();
		validateCommand();
		calculate();
	}





}
