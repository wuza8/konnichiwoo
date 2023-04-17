package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.ArtAddDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("art")
@RestController
@AllArgsConstructor
class ArtsController {

    private ArtsFacade facade;

    @PostMapping("add")
    private void addArt(@RequestBody ArtAddDto art){
        facade.addNewArt(art);
    }
}
