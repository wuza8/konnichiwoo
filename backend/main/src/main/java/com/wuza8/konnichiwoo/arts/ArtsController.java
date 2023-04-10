package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.ArtAddDto;
import com.wuza8.konnichiwoo.arts.dto.ArtPreviewDto;
import com.wuza8.konnichiwoo.arts.dto.ArtQueryDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("art")
@RestController
@AllArgsConstructor
class ArtsController {

    private ArtsFacade facade;

    @PostMapping("add")
    private void addArt(@RequestBody ArtAddDto art){
        facade.addNewArt(art);
    }

    @PostMapping("search")
    private List<ArtPreviewDto> searchArtPreviews(@RequestBody ArtQueryDto query){
        return facade.getArtPreviews(query);
    }
}
