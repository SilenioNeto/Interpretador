package me.silenio;

import java.util.Scanner;

public class Metodos {
	static Scanner sc = new Scanner(System.in);
	public static String command;
	public static String[] sendedCommand = new String[100];
	public static char[] chars = new char[100];

	public static String[] commands= {"SOME","SOMAR","DIVIDIR","DIVIDA","SUBTRAIR","SUBTRAIA","MULTIPLICAR","MULTIPLIQUE","MATRIZ"};

	public static String readCommand() {

		command = sc.nextLine();
		command = command.replaceAll("\\s+"," ");
		for(int x=0;x<command.length();x++) {
			command = uppercase(command);
			char charac = command.charAt(x);
			chars[x]=charac;
			System.out.println("["+chars[x]+"]");
		}
		System.out.println("Sended command:"+"["+command+"]");
		return command;
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
	}

	public static void validateCommand() {
		int z = 0;
		for(int x=0; x<commands.length; x++) {
			
			while(command.equals(commands[x])) {
				System.out.println("Solicited command:" + command);
				z++;
				break;
			}			
		}
		if(z==0) {
		System.out.println("\r Command not found");
		}
	}

	public static void calculate() {
		String calculate=command;
		switch(calculate) {
			
		case "SOMAR","SOME":
			System.out.println("Selected addition operation.");
			break;
		case "SUBTRAIR","SUBTRAIA":
			System.out.println("Selected subtraction operation.");
			break;
		case "DIVIDIR","DIVIDA":
			System.out.println("Selected division operation.");
			break;
		case "MULTIPLICAR","MULTIPLIQUE":
			System.out.println("Selected multiplication operation.");
			break;
		case "MATRIZ":
			criarMatriz();
			break;
		}
	}
			public static int[][] criarMatriz(){
		        Scanner scan = new Scanner(System.in);
		        System.out.print("Informe o nº de linhas da matriz: ");
		        int nlinha = scan.nextInt();
		        System.out.print("Informe o nº de colunas da matriz: ");
		        int ncoluna = scan.nextInt();
		        System.out.println("Informe o elemento inicial: ");
		        int inicio = scan.nextInt();
		        System.out.println("Informe a razão da progressão aritmética: ");
		        int razao = scan.nextInt();
		        scan.close();
		        int[][] matriz = new int[nlinha][ncoluna];

		        for(int linha=0;linha<nlinha;linha++){
		            for(int coluna=0;coluna<ncoluna;coluna++){
		                matriz[linha][coluna]=inicio;
		                inicio+=razao;
		            }
		        }
		        print(matriz);
		        return matriz;
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
