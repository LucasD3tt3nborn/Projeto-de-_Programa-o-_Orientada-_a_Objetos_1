package trabalho_po1;

//Grupo do TRABALHO:
//Lucas Dettenborn -> M:48296;
//Daniel Pravitz -> M:48213;
//Vitor Macedo Silva -> M:54199;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Trabalho_PO1 {

    public static void main(String[] args) throws IOException {

        System.out.println("\tPetShop 2.0\n==================================");
        //Cria os files sempre no inicio do programa já
        File patch_pets = new File("C:\\Users\\Lucas\\Documents\\NetBeansProjects\\Trabalho 1\\Trabalho_PO1\\Base_DADOS.txt");
        File patch_func = new File("C:\\Users\\Lucas\\Documents\\NetBeansProjects\\Trabalho 1\\Trabalho_PO1\\Base_FUNC.txt");
        File patch_emp = new File("C:\\Users\\Lucas\\Documents\\NetBeansProjects\\Trabalho 1\\Trabalho_PO1\\Dados_Empresa.txt");
        int fim_prog = 0, login_senha = 0, opcao_menu_gerente = 0, opcao_menu_atendente = 0;
        boolean testa_vazio, dados_emp = true, testa_vazio2 = false, testa_vazio3 = false, controle_func_exixte = false, aux_verific;
        String login_user = null;
        System.out.println("LEITURA DOS DADOS ARMAZENADOS\n+++++++++++++++++++++++++++++++++");
        //Aonde ele vai carregar os dados que estão armazenados no arquivo desde de a ultima execução do programa, e exibe na tela eles!
        System.out.println("\nArquivo de dados dos Pets\n+++++++++++++++++++++++++++++++++");
        Manipulador_txt.leitor(patch_pets); //PET 
        System.out.println("\nArquivo de dados dos Funcionários\n+++++++++++++++++++++++++++++++++");
        Manipulador_txt.leitor(patch_func); //FUNCIONARIO
        System.out.println("\nArquivo de dados da Empresa (MONITORAMENTO)\n+++++++++++++++++++++++++++++++++");
        Manipulador_txt.leitor(patch_emp); //EMPRESA
        System.out.println("\n");
        Gerente Contr_gerente = new Gerente();
        PetShop controle_pet = new PetShop();
        do { // Assim ele pode continuar fazendo as alterações que deseja no no uso do programa sem ter que carregar a cada laço os dados do .txt     
            if (dados_emp) {
                controle_pet.Insere_empresa();
                dados_emp = false;
            }
            testa_vazio = Contr_gerente.verifica_vazio();
            if (testa_vazio == true) {
                System.out.print("\nAinda não Existe Nenhum Atendente Cadastrado!\nTerá que cadastrar um novo para começar!\n");
                Contr_gerente.Adiconar_func(); //Adiciono o (1º)primeiro func
                System.out.println("\n\tAUTENTICADOR\n==================================\n");
                System.out.print("User: ");
                login_user = new Scanner(System.in).nextLine();
                System.out.print("Senha: ");
                login_senha = new Scanner(System.in).nextInt();
                System.out.println("\n==================================\n");
            } else { //Serve para ver se tem funcionários e entrar com a autenticação obrigatória, ai nem sempre a cada laço necessariamente o gerente terá que cadastrar um novo atendente
                System.out.println("\n\tAUTENTICADOR\n==================================\n");
                System.out.print("User: ");
                login_user = new Scanner(System.in).nextLine();
                System.out.print("Senha: ");
                login_senha = new Scanner(System.in).nextInt();
                System.out.println("\n==================================\n");
            }
            if ("admin".equals(login_user) && login_senha == 000) { //Testa se no menu autenticador é o gerente acessando
                System.out.print("\nMENU DO GERENTE\n=======================\n1->Adicionar Funcionário Novo\n2->Remover algum Funcionário\n3->Editar os dados\n4->Listar todos os Funcionários no Banco de Dados\n=====================================================\nSua Escolha: ");
                opcao_menu_gerente = new Scanner(System.in).nextInt();
                switch (opcao_menu_gerente) {
                    case 1: //Adicionar Funcionário
                        Contr_gerente.Adiconar_func();
                        break;
                    case 2: //Remover algum Funcionário
                        Contr_gerente.Remover_func();
                        break;
                    case 3: //Editar os dados
                        Contr_gerente.Editar_func();
                        break;
                    case 4: //Listar todos os funcionários no banco de dados
                        Contr_gerente.Listar_todos_atendentes();
                        break;
                }
            } else { //Testa se é o funcionário acessando e ja da a ele as suas funções (Opções limitas as funções dele próprio)
                controle_func_exixte = Contr_gerente.verificar_se_func_existe(login_user, login_senha); // Verifica se o funcionário existe no sistema para dai liberar o menu de atendente, caso a função retorne TRUE.
                if (controle_func_exixte == true) {
                    System.out.println("\nAcesso Permitido\n");
                    System.out.print("\nMENU DO ATENDENTE\n=======================\n1->Adicionar novo pet\n2->Remover pet\n3->Modificar Registro de pet\n4->Listar todos\n5->Listar por tipo\nSua Escolha: ");
                    opcao_menu_atendente = new Scanner(System.in).nextInt();
                    while (opcao_menu_atendente < 1 || opcao_menu_atendente > 5) {
                        System.out.print("\nOpção inválida\nTente novamente: ");
                        opcao_menu_atendente = new Scanner(System.in).nextInt();
                    }
                    switch (opcao_menu_atendente) {
                        case 1: //Adicionar um novo pet no sistema
                            controle_pet.adicionar_pet();
                            break;
                        case 2: //Remover um pet, caso que acontece quando ocorre a venda de um pet ou então quando algum morre
                            controle_pet.Remover_pet();
                            break;
                        case 3: //Editar os dados do pet 
                            controle_pet.Editar_dados_pet();
                            break;
                        case 4: //Listar todos os pet (todos pet inseridos no banco de dados sem qualquer tipo de filtragem) 
                            controle_pet.Imprimir_TODOS_pets();
                            break;
                        case 5: //Listar todos os pet (com um filtro, mostrando todos os animas de um tipo só, o qual o usuário que vai usar o programa vai necessitar) 
                            controle_pet.Imprimir_pets_PELOTIPO();
                            break;
                    }//Fim do menu escolha das opções do atendente
                } else {
                    System.out.println("Funcionário digitado, não está registrado no sistema\n\nAcesso Negado");
                }

            }
            fim_prog = controle_pet.controle_fim(); //Aqui o programa vai chamar a função que vai pedir ao user se ele que encerrar ou não o algoritmo 
            if (fim_prog == 0) { //Encerra o programa -> logo quando confirmado isso pelo user tem que realizar a gravação dos dados num arquivo, mesmo não sendo modificado.
                int j = 0;
                //Armazenamento dos dados dos pets
                testa_vazio2 = controle_pet.verifica_vazio_array();
                if (testa_vazio2 == true) {
                    System.out.println("\nNão foi realizada nenhuma alteração na base de dados dos pets");
                } else {
                    int tamanho_array_pets = controle_pet.tamanho_array();
                    //fazer um for pra armazenar conjunto de dados de 1 por 1
                    String dados_pet;
                    for (j = 0; j < tamanho_array_pets; j++) {
                        dados_pet = controle_pet.dados_pet(j);
                        Manipulador_txt.escritor(patch_pets, j, dados_pet);//grava os dados do array pet
                    }
                    System.out.println("\n\n");
                    Manipulador_txt.leitor(patch_pets); //para ler todos os arquivos que foram gravados durante a sessão
                }
                //Armazenamento dos dados dos Funcionários
                testa_vazio3 = Contr_gerente.verifica_vazio_array();
                if (testa_vazio3 == true) {
                    System.out.println("\nNão foi realizada nenhuma alteração na base de dados dos funcionários");
                } else {
                    int tamanho_array_func = Contr_gerente.tamanho_array();
                    //fazer um for pra armazenar conjunto de dados de 1 por 1
                    String dados_func;
                    for (j = 0; j < tamanho_array_func; j++) {
                        dados_func = Contr_gerente.dados_func(j);
                        Manipulador_txt.escritor(patch_func, j, dados_func);//grava os dados do array pet
                    }
                    System.out.println("\n\n");
                    Manipulador_txt.leitor(patch_func); //para ler todos os arquivos que foram gravados durante a sessão
                }
                //Armazenamento dos dados da Empresa no .txt
                String info_emp; // vai servir pra juntar todos os dados da empresa e armazenar alterações
                info_emp = controle_pet.dados_emp_retorna();
                System.out.println("\nFinal antes do fechamento do Programa\n--------------------------------------\n");
                Manipulador_txt.escritor(patch_emp, j, info_emp);
            }
        } while (fim_prog != 0);
    }
}
