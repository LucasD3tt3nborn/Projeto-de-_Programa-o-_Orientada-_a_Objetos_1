package trabalho_po1;

//Grupo do TRABALHO:
//Lucas Dettenborn -> M:48296;
//Daniel Pravitz -> M:48213;
//Vitor Macedo Silva -> M:54199;

//Realização das importações dos arquivos para que seja feita a manipulação dos dados:
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Manipulador_txt {

    public static void escritor(File patch, int contador_set, String dado_a_gravar) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(patch,true)); //patch seria o caminho do file, e ainda uso o true para poder continuar inserindo dados sem apagar o que lá já consta.
        buffWrite.append(dado_a_gravar + "\r\n"); //Ele então leva o dado e armazena ele no .txt
        buffWrite.close(); // encerra a ponte de ligação com o arquivo
    }

    public static void leitor(File patch) throws IOException {
        InputStream is = new FileInputStream(patch);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader buffRead = new BufferedReader(isr);
        String linha = " ";
        while (true) {
            if (linha != null) {
                System.out.println(linha);

            } else {
                break;
            }
            linha = buffRead.readLine();
        }
        buffRead.close(); // encerra a ponte de ligação com o arquivo
    }

}
