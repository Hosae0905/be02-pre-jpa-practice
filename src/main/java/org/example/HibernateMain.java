package org.example;

import org.example.model.CategoryTest;
import org.example.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateMain {
    public static void main(String[] args) {
        
        // 설정한 파일에서 유닛 이름을 찾아 설정해준다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateproject");

        // 엔티티 매니저 생성 --> 원리를 이해하는데 얘가 제일 중요함
        EntityManager em = emf.createEntityManager();
        
        // 트랜잭션을 실행할 수 있다. CRUD를 할 수 있음
        EntityTransaction et = em.getTransaction();

        et.begin();

//        for (int i = 0; i < 10; i++) {
//            CategoryTest category = new CategoryTest();
//            category.setType("카테고리" + (i + 1));
//            for (int j = 1; j <= 10; j++) {
//                User user = new User();
//                user.setName("test" + (i * 10 + j));
//                user.setCategory(category);
//                em.persist(user);
//            }
//            em.persist(category);
//        }



        // select
        /*User user = em.find(User.class, 2);     // sql 실행
        System.out.println("user.getId() = " + user.getId());
        System.out.println("user.getName() = " + user.getName());*/

        // update
        /*User user = em.find(User.class, 2);       // update 실행
        user.setName("test200");*/

        // delete
//        User user = em.find(User.class, 1);
//        em.remove(user);


        User user = em.find(User.class, 1);
        System.out.println(user.getCategory().getType());

        CategoryTest category = em.find(CategoryTest.class, 1);

        // 양방향일 때 주인을 설정하지 않으면 외래키가 어디있는지 모르게 되서 출력 값이 없다.
        for (User userList : category.getUserList()) {
            System.out.println(category.getType() + " " + userList.getName());
        }


        et.commit();
    }
}
