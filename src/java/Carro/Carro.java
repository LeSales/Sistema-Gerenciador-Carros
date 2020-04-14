
package Carro;

import java.util.Date;
import java.util.Objects;

public class Carro {
    
    private Integer seqCarro;
    private String modelo;
    private String fabricante;
    private String cor;
    private Date ano;

    public Integer getSeqCarro() {
        return seqCarro;
    }

    public void setSeqCarro(Integer seqCarro) {
        this.seqCarro = seqCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.seqCarro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.seqCarro, other.seqCarro)) {
            return false;
        }
        return true;
    }
    
}
