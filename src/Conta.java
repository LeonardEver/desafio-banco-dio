import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Conta implements ContaInterface {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    protected double taxa;


    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    // IMPLEMENTACAO DE TAXA VIA TRANSFERENCIA TED
    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.taxa = valor / 25;
        this.sacar(valor + taxa);
        System.out.println(valor);
        contaDestino.depositar(valor);
    }

    // TRANSFERENCIA SEM TAXA VIA PIX
    @Override
    public void transferirPIX(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
             System.out.println(String.format("Titular: %s", this.cliente.getNome()));
            System.out.println(String.format("Agencia: %d", this.agencia));
            System.out.println(String.format("Numero: %d", this.numero));
            System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
