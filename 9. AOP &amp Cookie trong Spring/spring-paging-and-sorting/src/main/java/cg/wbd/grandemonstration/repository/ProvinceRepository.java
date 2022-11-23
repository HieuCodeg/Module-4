package cg.wbd.grandemonstration.repository;

import cg.wbd.grandemonstration.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends CrudRepository<Province, Long> {
}
