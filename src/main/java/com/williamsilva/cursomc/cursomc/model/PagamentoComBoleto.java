package com.williamsilva.cursomc.cursomc.model;

import com.williamsilva.cursomc.cursomc.model.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class PagamentoComBoleto extends Pagamento {

    private LocalDate dataPagamento;
    private LocalDate dataVencimento;

    public PagamentoComBoleto() {}

    public PagamentoComBoleto(EstadoPagamento estado, Pedido pedido, LocalDate dataPagamento, LocalDate dataVencimento) {
        super(estado, pedido);
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
