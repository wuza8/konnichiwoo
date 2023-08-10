package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.ArtAddDto;
import com.wuza8.konnichiwoo.arts.dto.SentenceDto;
import com.wuza8.konnichiwoo.arts.dto.SentenceUpdateDto;
import lombok.AllArgsConstructor;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
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

    @GetMapping("sentences/all")
    private List<SentenceDto> getAllSentences(){
        return facade.getAllSentences();
    }

    @PostMapping("sentences/update")
    private void updateSentence(@RequestBody SentenceUpdateDto updateDto){
        facade.updateSentence(updateDto);
    }
}
