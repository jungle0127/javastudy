package com.ps.ehcache.pojo;

import java.io.Serializable;

public class Country implements Serializable {
    private final String code;
    private String alias;
    public Country(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Country country = (Country) o;

        return this.code.equals(country.code);
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }
}
