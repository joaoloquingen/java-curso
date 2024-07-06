package entities;

public class PessoaJuridica extends Contribuintes{

    private Integer nFuncionarios;

    public PessoaJuridica(Integer nFuncionarios) {
        this.nFuncionarios = nFuncionarios;
    }

    public PessoaJuridica(String nome, Double rendaAnual, Integer nFuncionarios) {
        super(nome, rendaAnual);
        this.nFuncionarios = nFuncionarios;
    }

    public Integer getnFuncionarios() {
        return nFuncionarios;
    }

    public void setnFuncionarios(Integer nFuncionarios) {
        this.nFuncionarios = nFuncionarios;
    }

    @Override
    public Double impostos() {
        if (nFuncionarios > 10) {
            return getRendaAnual() * 0.14;
        } else {
            return getRendaAnual() * 0.16;
        }
    }
}
