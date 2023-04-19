public class Banco {
    String cliente;
    int numero_Conta;
    double saldo;
    Banco() {}
    Banco(int numero_Conta, double saldo, String cliente) {
        this.cliente = cliente;
        this.numero_Conta = numero_Conta;
        this.saldo = saldo;
    }
    double getSaldo() {
        return saldo;
    }
    double sacarDinheiro(double valorSaque) {
        return saldo -= valorSaque;
    }
    double depositar(double valorDeposito) {
        return saldo += valorDeposito;
    }
}