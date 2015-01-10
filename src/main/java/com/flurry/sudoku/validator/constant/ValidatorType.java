package com.flurry.sudoku.validator.constant;

public enum ValidatorType {
    SINGLE, MULTI;

    public static ValidatorType get(String type){
        ValidatorType validatorType = SINGLE;
        if(type!=null && !("").equals(type.trim())){
            type = type.trim();
            for(ValidatorType val:ValidatorType.values()){
                if(type.equalsIgnoreCase(val.toString())){
                    validatorType = val;
                    break;
                }
            }
        }
        return validatorType;
    }

    public static ValidatorType get(){
        return get(null);
    }

}
