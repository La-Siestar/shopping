package com.siesta.modern.infrastructure.outbound.persistence.repository;

import com.siesta.modern.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    // Custom query methods can be defined here if needed
}
