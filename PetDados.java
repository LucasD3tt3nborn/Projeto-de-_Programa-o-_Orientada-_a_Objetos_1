package trabalho_po1;

//Grupo do TRABALHO:
//Lucas Dettenborn -> M:48296;
//Daniel Pravitz -> M:48213;
//Vitor Macedo Silva -> M:54199;

public class PetDados {
    private String Nome;
    private String Tipo;
    private String Raça;
    private double Preco;

    public PetDados(String Nome, String Tipo, String Raça, double Preco) {
        this.Nome = Nome;
        this.Tipo = Tipo;
        this.Raça = Raça;
        this.Preco = Preco;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getRaça() {
        return Raça;
    }

    public void setRaça(String Raça) {
        this.Raça = Raça;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double Preco) {
        this.Preco = Preco;
    }
    
    
}
