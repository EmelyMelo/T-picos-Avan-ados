package lambda;

public class Main {
	public static void main(String[] args) {
		Soma soma = (n1,n2)-> n1+n2;
		System.out.println(soma.calcular(10,15));
		
		Fatorial fatorial = numero -> {
			if (numero < 0) {
				throw new IllegalArgumentException("numero < 0");
			}
			
			int resultado = 1;
			
			for (int i = 1; i <= numero; i++) {
				resultado *= i;
			}
			
			return resultado;
		};
		System.out.println(fatorial.calcular(5));
		System.out.println(fatorial.calcular(7));
		
		Primo primo = numero -> {
			int divisiveis = 0;
			
			for (int i = 1; i <= numero; i++) {
				if (numero % i == 0) {
					divisiveis++;
				}
			}
			
			return divisiveis == 2;
		};
		System.out.println(primo.calcular(13));
		System.out.println(primo.calcular(14));
		
		InteiroValido inteiroValido = texto -> texto.matches("-?\\d+");
		System.out.println(inteiroValido.calcular("157"));
		System.out.println(inteiroValido.calcular("15a7"));
		
		CalcularMedia calcularMedia = vetor -> {
			if (vetor.length == 0) {
				throw new IllegalArgumentException("vetor.length == 0");
			}
			double s = 0;	//s = "soma" 		
			for (double valor : vetor) {
				s += valor;
			}			
			return s / vetor.length;
		};		
		double[] array1 = { 1, 10, 6.5, 189.5 };
		System.out.println(calcularMedia.calcular(array1));
		
		double[] array2 = { 10, 58.9, 6.5, 18 };
		System.out.println(calcularMedia.calcular(array2));

		ImprimirMaiorNumero imprimirMaiorNumero = vetor -> {
			if (vetor.length == 0) {
				throw new IllegalArgumentException("vetor.length == 0");
			}
			
			double maiorNumero = vetor[0];
			
			for (int i = 1; i < vetor.length; i++) {
				if (vetor[i] > maiorNumero) {
					maiorNumero = vetor[i];
				}
			}
			
			System.out.println("Maior número = " + maiorNumero);
		};
		imprimirMaiorNumero.calcular(array1);
		imprimirMaiorNumero.calcular(array2);
		
		
	}
}
