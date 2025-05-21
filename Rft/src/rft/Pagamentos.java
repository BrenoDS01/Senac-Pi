
package rft;


public class Pagamentos {
    
    private String nome;
    private String tipoplano;
    private int valor;
    private String pago;
   

    
    public Pagamentos() {
    }

    public Pagamentos(String nome, String tipoplano, int valor, String pago) {
        this.nome = nome;
        this.tipoplano = tipoplano;
        this.valor = valor;
        this.pago = pago;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoplano() {
        return tipoplano;
    }

    public void setTipoplano(String tipoplano) {
        this.tipoplano = tipoplano;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

   
    
}
