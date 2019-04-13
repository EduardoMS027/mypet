package com.mypet.myPetApp.grupos;

public enum TipoGrupo {

    JURIDICA(1, "PETVET, PETSHOP"),
    FISICAJURIDICA(2, "PETWALKER, PETHOME"),
    CLIENTE(3, "PETCLIENT");


    private Integer cod;
    private String descricao;

    TipoGrupo (Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    /**
     * @return the cod
     */
    public Integer getCod() {
        return cod;
    }
    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }
    /**
     * @param cod the cod to set
     */
    public void setCod(Integer cod) {
        this.cod = cod;
    }
    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}