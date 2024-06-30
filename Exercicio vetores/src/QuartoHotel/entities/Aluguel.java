package QuartoHotel;

public class Aluguel {
    private String nome;
    private String email;

    public Aluguel(String name, String email) {
        this.nome = name;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "; " + "E-mail: " + email;
    }
}
