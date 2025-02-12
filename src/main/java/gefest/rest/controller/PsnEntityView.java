package gefest.rest.controller;

import gefest.rest.domain.Psn;
import gefest.rest.repo.PsnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class PsnEntityView {

    @Autowired
    PsnRepo psnRepo;
    @GetMapping
    public Iterable<Psn> getList()
    {
        return psnRepo.findAll();
    }
}
