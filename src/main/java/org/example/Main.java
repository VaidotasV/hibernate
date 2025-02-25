package org.example;

import org.example.entity.Darbuotojas;
import org.example.entity.Projektas;
import org.example.entity.Skyrius;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = factory.openSession()) {
                Transaction tx = session.beginTransaction();

                long countDarbuotojai = (long) session.createQuery("SELECT COUNT(d) FROM Darbuotojas d").uniqueResult();
                long countProjektai = (long) session.createQuery("SELECT COUNT(p) FROM Projektas p").uniqueResult();
                long countSkyriai = (long) session.createQuery("SELECT COUNT(s) FROM Skyrius s").uniqueResult();

                if (countDarbuotojai <= 5) {
                    session.saveOrUpdate(new Darbuotojas(1, "Vaidotas", "Valančius", 1));
                    session.saveOrUpdate(new Darbuotojas(2, "Edmundas", "Ruškys", 2));
                    session.saveOrUpdate(new Darbuotojas(3, "Vytaras", "Zeicas", 3));
                    session.saveOrUpdate(new Darbuotojas(4, "Erikas", "Krasnauskas", 4));
                    session.saveOrUpdate(new Darbuotojas(5, "Marius", "Kunsmonas", 5));
                }

                if (countProjektai < 5) {
                    session.save(new Projektas(1, "CRM Sistemos kūrimas", 1));
                    session.save(new Projektas(2, "Marketingo analizė", 2));
                    session.save(new Projektas(3, "CRM testavimas", 3));
                    session.save(new Projektas(4, "Užsakymų CRM", 4));
                    session.save(new Projektas(5, "Procesų optimizavimas", 5));
                }

                if (countSkyriai < 5) {
                    session.save(new Skyrius(1, "IT"));
                    session.save(new Skyrius(2, "Finansai"));
                    session.save(new Skyrius(3, "Marketingas"));
                    session.save(new Skyrius(4, "Personalo skyrius"));
                    session.save(new Skyrius(5, "Pardavimai"));
                }

                tx.commit();
                System.out.println("Įrašai įtraukti");
                // Atnaujintas Hibernate kodas (testavimui)
            }
        }
    }
}
