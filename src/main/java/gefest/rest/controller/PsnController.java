package gefest.rest.controller;

import gefest.rest.domain.Psn;
import gefest.rest.repo.PsnRepo;
import gefest.rest.repo.PsnViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/psn_entities")
public class PsnController {

    @Autowired
    PsnRepo psnRepo;
    @GetMapping
    public Iterable<Psn> getList()
    {
        return psnRepo.findAll();
    }

    @PostMapping()
    public Psn addEmployee(@RequestBody Psn psn) throws Exception {
        return psnRepo.save(psn);
    }
}
