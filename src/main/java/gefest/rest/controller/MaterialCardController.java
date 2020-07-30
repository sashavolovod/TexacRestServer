package gefest.rest.controller;

import gefest.rest.domain.MaterialCard;
import gefest.rest.domain.Order;
import gefest.rest.repo.MaterialCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/mat_card")
public class MaterialCardController {

    @Autowired
    private MaterialCardRepo materialCardRepo;

    @GetMapping
    public Iterable<MaterialCard> getList()
    {
        return materialCardRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<MaterialCard> getListByMaterialCardId(@PathVariable("id") long materialCardId)
    {
        return materialCardRepo.findById(materialCardId);
    }

    @PostMapping
    public MaterialCard saveEntity(@RequestBody MaterialCard m) {
        return materialCardRepo.save(m);  }

}
