// Arthur Mendes Rodrigues 30896886
// Gabriel Ferreira Dantas 31253733

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        Pessoa p = new Pessoa();
        Banco b = new Banco();
        ArrayList<Banco> contas = new ArrayList<Banco>();
        ArrayList<Pessoa> clientes = new ArrayList<Pessoa>();
        String result= "";
        String titular = null;
        int funcoes;
        int numero_Conta;
        double saldoInicial;
        while(!result.equalsIgnoreCase("Sair")) {
            System.out.println("\n1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Conta");
            System.out.println("3 - Consultar Saldo");
            System.out.println("4 - Exibir Todas as Contas Cadastradas");
            System.out.println("5 - Sacar Dinheiro");
            System.out.println("6 - Depositar Dinheiro");
            System.out.println("7 - Sair\n");
            funcoes = leia.nextInt();
            switch(funcoes) {


                //Cadastrar um novo cliente
                case 1:
                    System.out.println("Digite o seu nome: ");
                    p.nome = leia.next();
                    System.out.println("Digite o seu CPF: ");
                    p.cpf = leia.next();
                    clientes.add(new Pessoa(p.nome, p.cpf));
                    break;


                //Cadastra uma nova conta no banco
                case 2:
                    System.out.println("Crie um número para sua conta");
                    b.numero_Conta = leia.nextInt();
                    if (b.numero_Conta == 0) {
                        System.out.println("Digite o numero da conta acima de 0");
                        return;
                    }
                    System.out.println("Digite o saldo inicial da sua conta");
                    b.saldo = leia.nextDouble();
                    System.out.println("Digite o CPF do titular da conta");
                    titular = leia.next();
                    if (!titular.equals(p.getCpf())) {
                        System.out.println("ERRO: o CPF do titular deve ser igual ao do cadastrado!!!!");
                        return;
                    }
                    contas.add(new Banco(b.numero_Conta, b.saldo, p.getCpf()));
                    break;


                //Consultar saldo da conta informada
                case 3:
                    System.out.println("Digite o numero da conta para ser consultada: ");
                    int conta_Consultada = leia.nextInt();
                    if (conta_Consultada == b.numero_Conta) {
                        System.out.println("Você Possuí: R$" + b.getSaldo() + " de saldo");
                    } else {
                        System.out.println("A conta informada não existe");
                        return;
                    }
                    break;


                //Exibe todas as contas cadastradas
                case 4:
                    for(Banco c : contas) {
                        System.out.println("");
                        System.out.println("Numero da Conta: " + c.numero_Conta);
                        System.out.println("Voce Possui: R$" + c.saldo + " na sua conta!");
                        System.out.println("CPF do Titular: " + c.cliente);
                        System.out.println("------------------------------------------------");
                    }
                    break;


                //Realiza o saque de uma das contas cadastradas
                case 5:
                    System.out.println("Digite o número da conta para sacar: ");
                    int conta_Saque = leia.nextInt();
                    if (conta_Saque == b.numero_Conta) {
                        System.out.println("Você Possuí: R$" + b.getSaldo() + " na conta!");
                    } else {
                        System.out.println("A conta informada não existe!!");
                        return;
                    }
                    System.out.println("Digite o quanto deseja sacar:");
                    int valorSaque = leia.nextInt();
                    if (valorSaque > b.getSaldo()) {
                        System.out.println("Saldo insuficiente!");
                        return;
                    }
                    b.sacarDinheiro(valorSaque);
                    System.out.println("Foi sacado: R$" + valorSaque + " da sua conta,\n restando: R$" + b.saldo);
                    break;


                //Deposita dinheiro em alguma conta cadastrada
                case 6:
                    System.out.println("Digite o numero da conta para despositar: ");
                    int contaDeposito = leia.nextInt();
                    if (contaDeposito == b.numero_Conta) {
                        System.out.println("Digite o quanto deseja depositar:");
                        double valorDeposito = leia.nextDouble();
                        b.depositar(valorDeposito);
                        System.out.println("Foi depositado: R$" + valorDeposito + " e, seu novo saldo é de: R$" + b.saldo);
                    } else {
                        System.out.println("A conta informada não existe!!");
                        return;
                    }
                    break;


                //Encerra o sistema
                case 7:
                    result = "Sair";
                    System.out.println("Obrigado por utilizar nosso sistema\n");
                    break;
            }
        }
    }
}