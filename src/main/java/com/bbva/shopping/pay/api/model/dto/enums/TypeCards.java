package com.bbva.shopping.pay.api.model.dto.enums;

public enum TypeCards {

    CARD_DEBITO(Boolean.FALSE), CARD_CREDITO(Boolean.FALSE);
    
    private Boolean isPoint;
    
    TypeCards(Boolean isPoint){
        this.isPoint = isPoint;
    }

    public Boolean getPoint() {
        return isPoint;
    }
}
