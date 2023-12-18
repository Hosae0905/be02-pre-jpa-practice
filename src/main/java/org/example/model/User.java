package org.example.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 쓸데없는 하이버네이트 시퀀스같은 테이블이 생성되지 않게 설정을 건다.
    private Integer id;

    private String name;


    /**
     * ManyToOne
     * ManyToMany
     * OneToOne
     * OneToMany
     */

    @ManyToOne
    @JoinColumn(name = "CategoryTest_id")
    private CategoryTest category;

    public CategoryTest getCategory() {
        return category;
    }

    public void setCategory(CategoryTest category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
