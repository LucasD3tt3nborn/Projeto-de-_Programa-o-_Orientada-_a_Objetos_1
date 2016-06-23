package trabalho_po1;

//Grupo do TRABALHO:
//Lucas Dettenborn -> M:48296;
//Daniel Pravitz -> M:48213;
//Vitor Macedo Silva -> M:54199;

public class Funcionario {

    private String nome;
    private int senha;

    public Funcionario(String nome, int senha) {
        this.nome = nome;
        this.senha = senha;
    }

    
    public Funcionario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

}
