package lambda;


public class Main {
	ProcedimentoSoma soma = (n1, n2)-> n1 + n2; 	

	Fatorial fatorial = (numero)-> {
		if (numero < 0) {
			throw new IllegalArgumentException("numero < 0");
		}
		
		int resultado = 1;
		
		for (int i = 1; i <= numero; i++) {
			resultado *= i;
		}
		
		return resultado;
	};

	Primo isPrimo = (numero)->{
		int divisiveis = 0;
		
		for (int i = 1; i <= numero; i++) {
			if (numero % i == 0) {
				divisiveis++;
			}
		}
		
		return divisiveis == 2;
	};
	
	InteiroValido isInteiroValido = (texto)-> texto.matches("-?\\d+");
	
	CalcularMedia calcularMedia = (vetor)->{
		if (vetor.length == 0) {
			throw new IllegalArgumentException("vetor.length == 0");
		}
		
		double soma = 0;
		
		for (double valor : vetor) {
			soma += valor;
		}
		
		return soma / vetor.length;
	};
	
	ImprimirMaiorNumero imprimirMaiorNumero = (vetor) -> {
		if (vetor.length == 0) {
			throw new IllegalArgumentException("vetor.length == 0");
		}
		
		double maiorNumero = vetor[0];
		
		for (int i = 1; i < vetor.length; i++) {
			if (vetor[i] > maiorNumero) {
				maiorNumero = vetor[i];
			}
		}
		
		System.out.println("Maior n�mero = " + maiorNumero);
	};
	
	
public static void main(String[] args) {
		System.out.println(soma.calcular(10, 15));
		System.out.println(soma.calcular(187, 18));
				
		System.out.println(fatorial.calcular(5));
		System.out.println(fatorial.calcular(7));
		
		
		System.out.println(isPrimo.calcular(13));
		System.out.println(isPrimo.calcular(14));
		
		System.out.println(isInteiroValido("157"));
		System.out.println(isInteiroValido("15a7"));
		
		double[] array1 = { 1, 10, 6.5, 189.5 };
		System.out.println(calcularMedia(array1));
		
		double[] array2 = { 10, 58.9, 6.5, 18 };
		System.out.println(calcularMedia(array2));

		imprimirMaiorNumero(array1);
		imprimirMaiorNumero(array2);
	}
}
