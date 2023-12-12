package com.example.practice.repository;

import com.example.practice.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * id를 기준으로 Member를 가져오고 이떄, 권한정보(authorities)도 같이 가져옵니다.
 * @EntityGraph: query가 수행 될 때 Lazy 조회가 아닌 Eager 조회로 authorities 정보를 가져옵니다.
 */
public interface MemberRepository extends JpaRepository<Member, Long> {


    Optional<Member> findMemberById(String username);

    boolean existsById(String id);

    boolean existsMemberById(String id);
    boolean existsMemberByEmail(String email);




}
