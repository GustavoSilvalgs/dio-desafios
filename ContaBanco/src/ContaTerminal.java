import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<ContaBanco> contas = new ArrayList<>();

        System.out.println("*** AGENCIA BANCÁRIA ***");
        System.out.println("1 - Cadastrar Usuário");
        System.out.println("2 - Deletar Usuário");
        System.out.println("3 - Listar Usuários");
        System.out.println("0 - Sair da Aplicação");
        int opcao = sc.nextInt();

        while (opcao != 0) {
            if (opcao == 1) {
                cadastrarUsuario(sc, contas);
            } else if (opcao == 2) {
                deletarUsuario(sc, contas);
            } else if (opcao == 3) {
                listarUsuarios(contas);
            } else {
                System.out.println("Opção inválida!");
            }

            System.out.print("\n1 - Para cadastrar usuário: ");
            System.out.print("\n2 - Para deletar usuário: ");
            System.out.print("\n3 - Para listar usuários: ");
            System.out.print("\n0 - Para sair da aplicação: ");
            opcao = sc.nextInt();
        }
    }

    private static void cadastrarUsuario(Scanner sc, List<ContaBanco> contas) {
        System.out.println("Cadastro de Usuário:");

        System.out.print("Digite o número da Conta: ");
        int numero = sc.nextInt();

        System.out.print("Digite o número da Agência: ");
        String agencia = sc.next();
        sc.nextLine();

        System.out.print("Digite o nome do Cliente: ");
        String nomeCliente = sc.nextLine();

        System.out.print("Digite o saldo: ");
        double saldo = sc.nextDouble();

        ContaBanco conta = new ContaBanco(numero, agencia, nomeCliente, saldo);

        contas.add(conta);

        System.out.println(
                "Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco.");
                System.out.println("Sua agência é " + agencia + ", conta "
                + numero + " e seu saldo é " + saldo + " já está disponível para saque.");
    }

    private static void deletarUsuario(Scanner sc, List<ContaBanco> contas) {
        System.out.print("Digite o número da Conta a ser deletada: ");
        int numeroConta = sc.nextInt();

        boolean removido = false;

        for (ContaBanco conta : contas) {
            if (conta.getNumero() == numeroConta) {
                contas.remove(conta);
                removido = true;
                System.out.println("Usuário com número de conta " + numeroConta + " removido com sucesso.");
                break;
            }
        }

        if (!removido) {
            System.out.println("Usuário com número de conta " + numeroConta + " não encontrado.");
        }
    }

    private static void listarUsuarios(List<ContaBanco> contas) {
        if(contas.isEmpty()) {
            System.out.println("Não há usuários cadastrados");
        } else {
            System.out.println("Lista de Usuários:");
            for (ContaBanco conta : contas) {
                System.out.println("Número da Conta: " + conta.getNumero());
                System.out.println("Agência: " + conta.getAgencia());
                System.out.println("Nome do Cliente: " + conta.getNomeCliente());
                System.out.println("Saldo: " + conta.getSaldo());
                System.out.println("---------------");
            }
        }
    }
}
