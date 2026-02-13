package com.project.cadastroninja.Ninjas;

import com.project.cadastroninja.Ninjas.Model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
