package shampoo_company.ingredients;

import shampoo_company.shampoos.BasicShampoo;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

@Entity
public abstract class BasicChemicalIngredient extends BasicIngredient implements ChemicalIngredient {

    @Column(name = "chemical_formula")
    private String chemicalFormula;

    protected BasicChemicalIngredient() {
    }

    public BasicChemicalIngredient(String name, BigDecimal price, String chemicalFormula) {
        super(name, price);
        this.setChemicalFormula(chemicalFormula);
    }

    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }

    public String getChemicalFormula() {
        return this.chemicalFormula;
    }

    public void setId(long id) {
        super.setId(id);
    }

    public void setShampoos(List<BasicShampoo> shampoos) {
        super.setShampoos(shampoos);
    }
}
