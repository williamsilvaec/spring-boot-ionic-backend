package com.williamsilva.cursomc.cursomc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.williamsilva.cursomc.cursomc.model.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class PagamentoComBoleto extends Pagamento {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPagamento;

    @JsonFormat(pattern = "dd/MM/yyyy")
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
