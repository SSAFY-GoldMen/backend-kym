package com.goldmen.cheolbuji.domain.realEstate.building.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BuildingType {
    APT("아파트"), OFFICETEL("오피스텔");

    public final String type;
}
