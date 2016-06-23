package trabalho_po1;

//Grupo do TRABALHO:
//Lucas Dettenborn -> M:48296;
//Daniel Pravitz -> M:48213;
//Vitor Macedo Silva -> M:54199;
import java.util.ArrayList;
import java.util.Scanner;

public class PetShop extends PetDados { //Guarda funções gerais do programa...

    //Armazenamento de variáveis que vão guardar os dados da nossa empresa.
    private String Nome;
    private String Endereco;
    private String cnpj;
    private double Faturamento;

    private ArrayList<PetDados> quant_pets;

    public PetShop() {
        super(null, null, null, 0);
        quant_pets = new ArrayList(); // Aonde vai ser armazenado todos os bichos que estiverem disponíveis na loja
    }

    public void Insere_empresa() {
        System.out.print("Informe o Nome da empresa: ");
        this.Nome = new Scanner(System.in).nextLine();
        System.out.print("Informe o Endereço da empresa: ");
        this.Endereco = new Scanner(System.in).nextLine();
        System.out.print("Informe o CNPJ da empresa: ");
        this.cnpj = new Scanner(System.in).nextLine();
        System.out.print("Informe o faturamento que a empresa teve: ");
        this.Faturamento = new Scanner(System.in).nextDouble();
        System.out.println(" ");
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getFaturamento() {
        return Faturamento;
    }

    public void setFaturamento(double Faturamento) {
        this.Faturamento = Faturamento;
    }

    //Funções de movimentação referentes ao funcionaro perante a loja
    public void adicionar_pet() { //Adicionar novos pets
        System.out.println("Informe os dados do PET:\n===============================\n");
        System.out.print("Nome=> ");
        String nome_pet = new Scanner(System.in).nextLine();
        System.out.print("Tipo Animal=> ");
        String tipo_pet = new Scanner(System.in).nextLine();
        System.out.print("Nome da Raça=> ");
        String nomeRaca_pet = new Scanner(System.in).nextLine();
        System.out.print("Preço=> ");
        double preco_pet = new Scanner(System.in).nextDouble();
        PetDados insere_pet = new PetDados(nome_pet, tipo_pet, nomeRaca_pet, preco_pet);
        quant_pets.add(insere_pet);
    }

    public void Imprimir_TODOS_pets() {//Imprime todos os pets disponíveis a venda
        if (quant_pets.isEmpty()) {
            System.out.println("Banco de Dados do Pet ta vazio");
        } else {
            System.out.println("Banco de Dados do Pet: \n===================================================");
            for (int i = 0; i < quant_pets.size(); i++) {
                System.out.println("\n");
                System.out.println("NOME=> " + quant_pets.get(i).getNome() + "\nTipo Animal: " + quant_pets.get(i).getTipo() + "\nRaça: " + quant_pets.get(i).getRaça() + "\nPreço: " + quant_pets.get(i).getPreco());
            }
        }
    }

    public void Imprimir_pets_PELOTIPO() {//Imprime todos os pets disponíveis a venda (Filtro pelo tipo do pet)
        boolean verific_filtro = false;
        if (quant_pets.isEmpty()) {
            System.out.println("Banco de Dados do Pet ta vazio");
        } else {
            System.out.print("Informe o tipo do pet que deseja buscar nos registro (ex.: gato, cavalo, cachorro)\nSua escolha: ");
            String tipo_pet_filtro = new Scanner(System.in).nextLine();
            System.out.println("Banco de Dados do Pet: \n===================================================");
            for (int i = 0; i < quant_pets.size(); i++) {
                if (tipo_pet_filtro.equals(quant_pets.get(i).getTipo())) {
                    System.out.println("\n");
                    System.out.println("NOME=> " + quant_pets.get(i).getNome() + "\nTipo Animal: " + quant_pets.get(i).getTipo() + "\nRaça: " + quant_pets.get(i).getRaça() + "\nPreço: " + quant_pets.get(i).getPreco());
                    verific_filtro = true;
                }
            }
            if (verific_filtro == false) {
                System.out.println("Não tem nenhum animal no banco de dados do pet, de acordo ao filtro de tipo fornecido por você!");
            }
        }
    }

    public void Editar_dados_pet() {//Edita os dados do Funcionário a partir da busca pelo nome do mesmo
        if (quant_pets.isEmpty()) {
            System.out.println("NÃO TEM MAIS DADOS ARMAZENADOS!");
        } else {
            System.out.println("\nBanco de Dados do Pet: \n===================================================");
            for (int i = 0; i < quant_pets.size(); i++) {
                System.out.println("\n");
                System.out.println("NOME=> " + quant_pets.get(i).getNome() + "\nTipo Animal: " + quant_pets.get(i).getTipo() + "\nRaça: " + quant_pets.get(i).getRaça() + "\nPreço: " + quant_pets.get(i).getPreco());
            }
            System.out.print("Informe a Posição que deseja excluir no registro: ");
            int posicao_alt = new Scanner(System.in).nextInt(); //Controle para verificar se a posição que ele deseja excluir de fato existe
            while (posicao_alt > quant_pets.size()-1 || posicao_alt < 0) {
                System.out.print("\nPOSIÇÃO ESCOLHIDA NÃO TEM NA LISTA\n\nNovamente a posição que correspondente ao PET que deseja modificar: ");
                posicao_alt = new Scanner(System.in).nextInt();

            }
            System.out.println("Informe os novos dados\n======================\n");
            System.out.print("Informe o NOME: ");
            String nome_alvo_modific = new Scanner(System.in).nextLine();
            System.out.print("\nInforme a TIPO ANIMAL: ");
            String tipo_alvo_modific = new Scanner(System.in).nextLine();
            System.out.print("\nInforme a RAÇA: ");
            String raca_alvo_modific = new Scanner(System.in).nextLine();
            System.out.print("\nInforme o NOVO PREÇO: ");
            Double preco_alvo_modific = new Scanner(System.in).nextDouble();
            PetDados modific_PET = new PetDados(nome_alvo_modific, tipo_alvo_modific, raca_alvo_modific, preco_alvo_modific);
            quant_pets.set(posicao_alt, modific_PET); //A partir da posição informada o sistema substitui novos dados
        }
    }

    public void Remover_pet() {//Remove um pet qualquer através da busca pelo nome do pet
        System.out.print("Informe o Nome do funcionário que deseja demitir: ");
        String Func_alvo = new Scanner(System.in).nextLine();
        boolean controle = false;
        if (quant_pets.isEmpty()) {
            System.out.println("Banco de Dados do Pet ta vazio (Sem Animais Registrados)");
        } else {
            System.out.println("Procurando Pet....");
            for (int i = 0; i < quant_pets.size(); i++) {
                if (Func_alvo.equals(quant_pets.get(i).getNome())) {
                    controle = true;
                    PetDados pet = quant_pets.get(i);
                    quant_pets.remove(pet);
                }
            }
            if (controle) {
                System.out.println("Pet e seus dados foram removidos com sucesso!");
            } else {
                System.out.println("Pet com o nome de: " + Func_alvo + "não consta armazenado no Banco de Dados!");
            }
        }
    }

    public boolean verifica_vazio_array() { //Verifica se o array que guarda os dados do pet não ta vazio 
        boolean controle_vazio = false;
        if (quant_pets.isEmpty()) {
            return controle_vazio = true;
        } else {
            return controle_vazio;
        }
    }

    public int tamanho_array() {//Vai me retornar apenas o tamanho total do array assim que o algoritmo parar de executar as funções de modificação ou alguma alteração dos dados
        return (quant_pets.size());
    }

    public String dados_pet(int posicao_set) { // Retorna uma String com todos os dados inseridos pelo usuário + cabeçalho das variáveis (na posição que estiver no for, dentro do acesso no programa principal)
        String tot_dados; // Aonde vai agrupar todos os dados referente ao pet concatenadon numa String Só!
        tot_dados = ("NOME=> " + quant_pets.get(posicao_set).getNome() + " Tipo Animal: " + quant_pets.get(posicao_set).getTipo() + " Raça: " + quant_pets.get(posicao_set).getRaça() + " Preço: " + quant_pets.get(posicao_set).getPreco());
        System.out.println(tot_dados);
        return tot_dados;
    }

    public String dados_emp_retorna() { // Retorna uma String com todos os dados inseridos pelo usuário + cabeçalho das variáveis
        String tot_dados; // Aonde vai agrupar todos os dados referente ao pet concatenadon numa String Só!
        tot_dados = ("NOME=> " + getNome() + "  Endereço: " + getEndereco() + "  CNPJ: " + getCnpj() + "  Faturamento: " + getFaturamento());
        System.out.println(tot_dados);
        return tot_dados;
    }

    public int controle_fim() {
        System.out.println("\nDeseja Continuar com o Sistema Ligado (1=Sim | 0=Não)");
        int fim_prog = new Scanner(System.in).nextInt();
        while (fim_prog < 0 || fim_prog > 1) {
            System.out.println("Inválido Digite de novo o código de controle\n(1=Sim | 0=Não)");
            fim_prog = new Scanner(System.in).nextInt();
        }
        return fim_prog;
    }

}
