package shampoo_company.core;

import shampoo_company.ingredients.AmmoniumChloride;
import shampoo_company.ingredients.BasicIngredient;
import shampoo_company.ingredients.Mint;
import shampoo_company.ingredients.Nettle;
import shampoo_company.labels.BasicLabel;
import shampoo_company.shampoos.BasicShampoo;
import shampoo_company.shampoos.FreshNuke;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("shampoo_company");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        BasicIngredient am = new AmmoniumChloride();
        BasicIngredient mint = new Mint();
        BasicIngredient nettle = new Nettle();

        BasicLabel label = new BasicLabel("Fresh Nuke Shampoo", "Contains ming and nettle");

        BasicShampoo shampoo = new FreshNuke(label);

        shampoo.getIngredients().add(mint);
        shampoo.getIngredients().add(nettle);
        shampoo.getIngredients().add(am);
        em.persist(shampoo);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
