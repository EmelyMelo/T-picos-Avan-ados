package br.edu.ifpe.java8.ex3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import br.edu.ifpe.java8.entidades.Aluno;

/**
 * Esta classe é responsável pela leitura de todos os alunos de um arquivo de entrada 
 * (alunos.txt) e gerar um relatório.
 * 
 * 3 Opções de relatórios estão disponíveis: 
 * 		1 - A média geral da turma;
 *		2 - A quantidade de alunos acima da média;
 *		3 - A quantidade de alunos abaixo da média.
 * 
 * Logo, o seu trabalho é basicamente, utilizando programação funcional, implementar 
 * o mecanismo de geração de relatórios evitando ifs e switchs ao longo do método abaixo.
 * 
 * @author Victor Lira
 *
 */
public class RelatorioAlunos3 {

	private static final String SEPARADOR = "#";
	private static final double MEDIA_APROVACAO = 6;

	private static final Map<TipoRelatorio3, Function<ArrayList<Aluno>, Double>> FUNCAO;

	static double media = 0;
	static double qtdeAlunos = 0;

	static{
		FUNCAO = new HashMap<>();
		FUNCAO.put(TipoRelatorio3.MEDIA_GERAL, alunos -> {
			alunos.forEach(aluno -> media += aluno.getMedia());
			return (media/alunos.size());
		});
		FUNCAO.put(TipoRelatorio3.ALUNOS_ACIMA_DA_MEDIA, alunos->{
			alunos.parallelStream().filter(aluno -> aluno.getMedia() > MEDIA_APROVACAO).forEach(f -> {
				qtdeAlunos++;
			});;
			return qtdeAlunos;
		});
		FUNCAO.put(TipoRelatorio3.ALUNOS_ABAIXO_DA_MEDIA, alunos -> {
			alunos.parallelStream().filter(aluno -> aluno.getMedia() < MEDIA_APROVACAO).forEach(f -> {
				qtdeAlunos++;
			});;
			return	qtdeAlunos;
		});

		
	}

	public static void gerar(TipoRelatorio3 opcao) {

		File arquivoEntrada = new File("alunos.txt");
		File arquivoSaida = new File("relatorio.txt");
		Scanner leitor = null;
		PrintWriter escritor = null;
		ArrayList<Aluno> alunos = new ArrayList<>();

		try {
			leitor = new Scanner(arquivoEntrada);
			escritor = new PrintWriter(arquivoSaida);

			while (leitor.hasNextLine()) {
				String linha = leitor.nextLine();
				String[] valores = linha.split(SEPARADOR);
				Aluno aluno = new Aluno();
				aluno.setNome(valores[0]);
				aluno.setMatricula(valores[1]);
				aluno.setMedia(Double.parseDouble(valores[2]));
				alunos.add(aluno);
			}
			
			escritor.print(FUNCAO.get(opcao).apply(alunos));
			
		} catch (IOException e) {
			/* DO NOTHING */
		} finally {
			if (leitor != null) {
				leitor.close();
			}
			if (escritor != null) {
				escritor.close();
			}
		}
	}
}