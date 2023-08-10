package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
class ArtsService {

    private ArtsRepository artsRepository;
    private SentencesRepository sentencesRepository;

    public String addNewArt(ArtAddDto artAddDto) {

        //Firstly we add new sentences
        for(SentenceAddWithArtDto newSentence : artAddDto.addedSentences){
            SentenceAddDto sentenceAddDto = new SentenceAddDto();

            sentenceAddDto.setLanguageId(artAddDto.languageId);
            sentenceAddDto.setGoodEnglishAnswers(newSentence.getGoodEnglishAnswers());
            sentenceAddDto.setGoodForeignAnswers(newSentence.getGoodForeignAnswers());
            sentenceAddDto.setMemoPictureURL(newSentence.getMemoPictureURL());

            String newId = addNewSentence(sentenceAddDto);

            //We find parts that use this sentence
            for(ArtPartAddDto part : artAddDto.artParts){
                if(part.newUsedSentences.contains(newSentence.getPartTimeId())){
                    part.sentences.add(newId);
                }
            }
        }
        List<ArtPart> parts = new ArrayList<>();

        for(ArtPartAddDto part : artAddDto.artParts){
            parts.add(ArtPart.builder().subtitle(part.subtitle)
                    .sentences(part.sentences).build());
        }


        ArtEntity artEntity = ArtEntity.builder()
                .textName(artAddDto.textName)
                .languageId(artAddDto.languageId)
                .originalAuthor(artAddDto.originalAuthor)
                .artType(artAddDto.artType)
                .artUrl(artAddDto.artUrl)
                .artParts(parts)
                .build();

        return artsRepository.add(artEntity);
    }

    public String addNewSentence(SentenceAddDto sentenceAddDto){
        SentenceEntity sentenceEntity = SentenceEntity.builder()
                .id(null)
                .languageId(sentenceAddDto.getLanguageId())
                .translation(sentenceAddDto.getTranslation())
                .memoPictureURL(sentenceAddDto.getMemoPictureURL())
                .goodForeignAnswers(sentenceAddDto.getGoodForeignAnswers())
                .goodEnglishAnswers(sentenceAddDto.getGoodEnglishAnswers())
                .build();

        return sentencesRepository.add(sentenceEntity);
    }

    public List<ArtEntity> searchArts(ArtQueryDto textQueryDto) {
        return artsRepository.findArts(textQueryDto);
    }

    public ArtEntity getArt(String artId){
        return artsRepository.find(artId);
    }

    public SentenceEntity getSentence(String id){
        return sentencesRepository.find(id);
    }

    public List<SentenceEntity> getAllSentences(){
        return sentencesRepository.findAll();
    }

    public void updateSentence(String id, List<String> goodEnglish, List<String> goodForeign, String memoPictureURL){
        SentenceEntity sentence = sentencesRepository.find(id);
        sentence.setGoodEnglishAnswers(goodEnglish);
        sentence.setGoodForeignAnswers(goodForeign);
        if(memoPictureURL != null && memoPictureURL != "")
            sentence.setMemoPictureURL(memoPictureURL);
        sentencesRepository.update(sentence);
    }
}
