public class Pessoa {
    String nome, cpf;
    Pessoa() {}
    Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    String getCpf() {
        return cpf;
    }
    String getNome() {
        return nome;
    }
}
