package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {

}

/*
* <JpaRepository>
* - 여기에서는 Posts 클래스로 Database를 접근하게 하는 역할
* - 보통 ibatis나 Mybatis 등에서 Dao라고 불리는 DB Layer 접근자
* - 인터페이스로 생성 후 JpaRepository<Entity 클래스, PK타입>를 상속하면 기본적인 CRUD 메소드가 자동 생성됨
* - 반드시 Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다. 기본 Repository 없이는 역할이 불가능하기 때문.
* - 추후 규모가 커져 도메인별로 프로젝트를 분리할 때 용이하기 위해. 도메인 패키지에서 함께 관리함
*/
