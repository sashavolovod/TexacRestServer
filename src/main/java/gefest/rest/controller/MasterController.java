package gefest.rest.controller;

import gefest.rest.domain.Detail;
import gefest.rest.domain.Master;
import gefest.rest.repo.MasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterRepo masterRepo;

    @GetMapping
    public Iterable<Master> getMessageList()
    {
        return masterRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Master> getMaster(@PathVariable("id") long masterId)
    {
        return masterRepo.findById(masterId);
    }

    @PostMapping
    public Master addMaster(@RequestBody Master master) {

        for (Detail d : master.getDetails()) {
            d.setMaster(master);
        }

        return masterRepo.save(master);
    }

    @PutMapping("/{id}")
    public Master addMaster(@PathVariable("id") long masterId, @RequestBody Master master) {


        for (Detail d : master.getDetails()) {
            d.setMaster(master);
        }

        return masterRepo.save(master);
    }
}
