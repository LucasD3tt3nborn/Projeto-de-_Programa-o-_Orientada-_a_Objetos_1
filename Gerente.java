package trabalho_po1;

//Grupo do TRABALHO:
//Lucas Dettenborn -> M:48296;
//Daniel Pravitz -> M:48213;
//Vitor Macedo Silva -> M:54199;

import java.util.ArrayList;
import java.util.Scanner;

public class Gerente extends Funcionario {

    ArrayList<Funcionario> array_func; // Armazena o Numero de funcionarios e seus dados
    Scanner limpar_buffer = new Scanner (System.in); //Criada no escopo global para cada vez que dentro dessa classe tiver problemas com a leitura dos dados, eles possam ser lidos normalmente
    
    public Gerente() {
        array_func = new ArrayList(); //Inicialização do array assim que for chamado o construtor atravéz do instanciamento da classe
    }

    public boolean verifica_vazio() { //Verifca se o array que contém dados dos funcionários está vazio
        boolean vazio;
        if (array_func.isEmpty()) {
            vazio = true;
        } else {
            vazio = false;
        }
        return vazio;
    }

    public boolean verificar_se_func_existe(String nome, int senha_log) {
        boolean controle = false;
        if (array_func.isEmpty()) {
            System.out.println("Banco de Dados da Loja ta vazio (Sem funcionários Registrados)");
        } else {
            System.out.println("\nProcurando Funç....");
            for (int i = 0; i < array_func.size(); i++) {
                if (nome.equals(array_func.get(i).getNome()) && senha_log == (array_func.get(i).getSenha())) {
                    controle = true;
                }
            }
        }
        return (controle);
    }

    public String dados_func(int posicao_set) { // Retorna uma String com todos os dados inseridos pelo usuário + cabeçalho das variáveis
        String tot_dados; // Aonde vai agrupar todos os dados referente ao pet concatenadon numa String Só!
        tot_dados = ("NOME=> " + array_func.get(posicao_set).getNome() + " Senha_log.: " + array_func.get(posicao_set).getSenha());
        System.out.println(tot_dados);
        return tot_dados;
    }

    public void Adiconar_func() {//Adicona um novo funcionario com os dois tipos de dados nome e senha (para autenticar mais tarde)
        limpar_buffer.nextLine();
        System.out.print("\nInsira o Nome: ");
        String nome = new Scanner(System.in).nextLine();
        System.out.print("Insira a nova Senha: ");
        int senha = new Scanner(System.in).nextInt();
        Funcionario func = new Funcionario(nome, senha);
        array_func.add(func);
    }

    public void Remover_func() {//Remove um funcionario a partir da busca pelo nome do mesmo
        System.out.print("Informe o Nome do funcionário que deseja demitir: ");
        String Func_alvo = new Scanner(System.in).nextLine();
        boolean controle = false;
        if (array_func.isEmpty()) {
            System.out.println("Banco de Dados da Loja ta vazio (Sem funcionários Registrados)");
        } else {
            System.out.println("Procurando Funç....");
            for (int i = 0; i < array_func.size(); i++) {
                if (Func_alvo.equals(array_func.get(i).getNome())) {
                    controle = true;
                    Funcionario f = array_func.get(i);
                    array_func.remove(f);
                }
            }
            if (controle) {
                System.out.println("Funcionário e seus dados foram removidos com sucesso!");
            } else {
                System.out.println("Funcionário com o nome de: " + Func_alvo + "não consta armazenado no Banco de Dados!");
            }
        }
    }

    public void Editar_func() {//Edita os dados do Funcionário a partir da busca pelo nome do mesmo
        if (array_func.isEmpty()) {
            System.out.println("NÃO TEM MAIS DADOS ARMAZENADOS!");
        } else {
            System.out.println("\nListas de Funcionários: \n===================================================");
            for (int i = 0; i < array_func.size(); i++) {
                System.out.println("\n");
                System.out.println("F nº:" + i + "NOME=> " + array_func.get(i).getNome() + "\nSenha: " + array_func.get(i).getSenha());
            }
            System.out.print("Informe a Posição que deseja excluir no registro: ");
            int posicao_alt = new Scanner(System.in).nextInt();
            while (posicao_alt > array_func.size()-1 || posicao_alt < 0) {
                System.out.print("\nPOSIÇÃO ESCOLHIDA NÃO TEM NA LISTA\n\n Novamente a posição que correspondente ao funcionário que deseja modificar: ");
                posicao_alt = new Scanner(System.in).nextInt();

            }
            System.out.println("Informe os novos dados\n======================\n");
            System.out.print("Informe o NOME:");
            String nome_alvo_modific = new Scanner(System.in).nextLine();
            System.out.println("Informe a SENHA:");
            int senha_alvo_modific = new Scanner(System.in).nextInt();
            Funcionario modific_FUNC = new Funcionario(nome_alvo_modific, senha_alvo_modific);
            array_func.set(posicao_alt, modific_FUNC); //A partir da posição informada o sistema substitui novos dados
        }
    }

    public void Listar_todos_atendentes() { // Lista todos os funcionários armazenador no Array caso tenha algum    
        if (array_func.isEmpty()) {
            System.out.println("Banco de Dados não contém nunhum funcionário ativo");
        } else {
            System.out.println("Listas de Funcionários: \n===================================================");
            for (int i = 0; i < array_func.size(); i++) {
                System.out.println("\n");
                System.out.println("NOME=> " + array_func.get(i).getNome() + "\nSenha: " + array_func.get(i).getSenha());
            }
        }
    }

    public boolean verifica_vazio_array() { //Verifica se o array não está vazio
        boolean controle_vazio = false;
        if (array_func.isEmpty()) {
            return controle_vazio = true;
        } else {
            return controle_vazio;
        }
    }

    public int tamanho_array() {//Vai me retornar apenas o tamanho total do array assim que o algoritmo parar de executar as funções de modificação ou alguma alteração dos dados
        return (array_func.size());
    }

}
