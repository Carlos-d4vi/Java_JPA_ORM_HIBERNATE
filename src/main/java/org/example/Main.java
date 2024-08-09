package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.model.Produto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Iniciar uma transação
        Transaction transaction = session.beginTransaction();


        Produto produto = new Produto();
        produto.setNome("Arroz");
        produto.setPreco(8.99);

        // Salvar o usuário no banco de dados
        session.save(produto);

        // Confirmar a transação
        transaction.commit();

        // Fechar a sessão
        session.close();

        // Fechar o SessionFactory
        sessionFactory.close();

        System.out.println("Produto salvo!");


    }
}