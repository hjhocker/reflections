package com.harrison.ai.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.harrison.enums.IrisEnumConverter;
import com.harrison.enums.IrisSpeciesEnum;

@Entity
@Table(name = "iris")
public class IrisEntity implements Serializable {

    private static final long serialVersionUID = -5395050540314952959L;

    @Id
    private Long id;
    
    @Column(name = "sepal_length")
    private Float sepalLength;
    
    @Column(name = "sepal_width")
    private Float sepalWidth;
    
    @Column(name = "petal_length")
    private Float petalLength;
    
    @Column(name = "petal_width")
    private Float petalWidth;
    
    @Column(name = "species")
    @Convert(converter = IrisEnumConverter.class)
    private IrisSpeciesEnum species;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getSepalLength() {
        return sepalLength;
    }

    public void setSepalLength(Float sepalLength) {
        this.sepalLength = sepalLength;
    }

    public Float getSepalWidth() {
        return sepalWidth;
    }

    public void setSepalWidth(Float sepalWidth) {
        this.sepalWidth = sepalWidth;
    }

    public Float getPetalLength() {
        return petalLength;
    }

    public void setPetalLength(Float petalLength) {
        this.petalLength = petalLength;
    }

    public Float getPetalWidth() {
        return petalWidth;
    }

    public void setPetalWidth(Float petalWidth) {
        this.petalWidth = petalWidth;
    }

    public IrisSpeciesEnum getSpecies() {
        return species;
    }

    public void setSpecies(IrisSpeciesEnum species) {
        this.species = species;
    }
    
    
}
