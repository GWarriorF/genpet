package cadastro.modelo;

import java.util.ArrayList;
import java.util.List;

public class CadastroAnimalGato extends CadastroAnimal {

	private String pelo;
	private static List<String> tipoPelo;
	private String raca;
	private static List<String> racas;
	private static List<String> vacinasG;


	public CadastroAnimalGato(String nomeDono, String endereco, String cpf, String especie, String nomeAnimal,
			String cor, String sexo, String idade, Double peso, ArrayList<String> procedimentos,
			ArrayList<Double> valores, String pelo, String raca) {
		super(nomeDono, endereco, cpf, especie, nomeAnimal, cor, sexo, idade, peso, procedimentos, valores);
		this.pelo = pelo;
		this.raca = raca;
	}

	public String getPelo() {
		return pelo;
	}

	public void setPelo(String pelo) {
		this.pelo = pelo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public static List <String> getRacas() {
		racas = new ArrayList<>();
		racas.add("SRD (Sem Raça Definida)");
		racas.add("Abissínio");
		racas.add("Bengal");
		racas.add("Birmanês");
		racas.add("British Shorthair");
		racas.add("Burmês");
		racas.add("Chartreux");
		racas.add("Maine Coon");
		racas.add("Persa");
		racas.add("Ragdoll");
		racas.add("Siamês");
		racas.add("Sphynx");
		racas.add("Somali");
		racas.add("Savannah");
		racas.add("Scottish Fold");
		racas.add("Siberiano");
		racas.add("Tonquinês");
		racas.add("Van Turco");
		racas.add("Oriental");
		racas.add("Exótico");
		racas.add("Norueguês da Floresta");
		return racas;
		// Adicionar outras raças de gatos conforme necessário
	}

	public static void setRacas(List<String> racas) {
		CadastroAnimalGato.racas = racas;
	}

	public static List<String> getTipoPelo() {
		tipoPelo = new ArrayList<>();
		tipoPelo.add("Curto");
		tipoPelo.add("Médio");
		tipoPelo.add("Longo");
		tipoPelo.add("Sem Pelos");
		return tipoPelo;
	}

	public static void setTipoPelo(List<String> tipoPelo) {
		CadastroAnimalGato.tipoPelo = tipoPelo;
	}
	
	public static List<String> getVacinasG() {
		vacinasG = new ArrayList<>();
		vacinasG.add("V5");
		vacinasG.add("V4");
		vacinasG.add("V3");
		vacinasG.add("Antirrábica");
		return vacinasG;
	}

	public static void setVacinasG(List<String> vacinasG) {
		CadastroAnimalGato.vacinasG = vacinasG;
	}
      

	public void visualizargato() {
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println("Dados do Pet:");
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println("Nome do Pet: " + this.getNomeAnimal());
		System.out.println("Raça: " + this.getRaca());
		System.out.println("Cor: " + this.getCor());
		System.out.println("Sexo: " + this.getSexo());
		System.out.println("Idade: " + this.getIdade());
		System.out.println("Peso: " + this.getPeso());
		System.out.println("Tipo do Pelo: " + getTipoPelo());

	}

}
