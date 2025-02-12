package gefest.rest.controller;

import gefest.rest.domain.Psn;
import gefest.rest.repo.PsnViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/psn_entities_view")
public class PsnViewController {
    @Autowired
    PsnViewRepo psnViewRepo;

    @GetMapping()
    public List<Psn> getListDistinct()
    {
        return psnViewRepo.findAllPsnWithSpecificFields();
    }
}
