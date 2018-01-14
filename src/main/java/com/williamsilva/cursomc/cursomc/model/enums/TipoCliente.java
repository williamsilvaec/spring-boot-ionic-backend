package com.williamsilva.cursomc.cursomc.model.enums;

public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa física"),
    PESSOAJURIDICA(2, "Pessoa jurídica");

    private Integer codigo;
    private String descricao;

    TipoCliente(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (TipoCliente tp: TipoCliente.values()) {
            if (tp.getCodigo().equals(codigo)) {
                return tp;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
