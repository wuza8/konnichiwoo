package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.*;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
class ArtsService {

    private ArtsRepository artsRepository;
    private SentencesRepository sentencesRepository;

    public Long addNewArt(ArtAddDto artAddDto) {

        //Firstly we add new sentences
        for(SentenceAddWithArtDto newSentence : artAddDto.addedSentences){
            SentenceAddDto sentenceAddDto = new SentenceAddDto();

            sentenceAddDto.setLanguageId(artAddDto.languageId);
            sentenceAddDto.setTranslation(newSentence.getTranslation());
            sentenceAddDto.setGoodEnglishAnswers(newSentence.getGoodEnglishAnswers());
            sentenceAddDto.setGoodForeignAnswers(newSentence.getGoodForeignAnswers());
            sentenceAddDto.setMemoPictureURL(newSentence.getMemoPictureURL());

            Long newId = addNewSentence(sentenceAddDto);

            //We find parts that use this sentence
            for(ArtPartDto part : artAddDto.artParts){
                if(part.newUsedSentences.contains(newSentence.getPartTimeId())){
                    part.sentences.add(newId);
                }
            }
        }

        ArtEntity artEntity = ArtEntity.builder()
                .textName(artAddDto.textName)
                .languageId(artAddDto.languageId)
                .memoAuthorUID(artAddDto.memoAuthorUID)
                .originalAuthor(artAddDto.originalAuthor)
                .artType(artAddDto.artType)
                .artUrl(artAddDto.artUrl)
                .artParts(createArtPartsString(artAddDto.artParts))
                .build();

        return artsRepository.add(artEntity);
    }

    public Long addNewSentence(SentenceAddDto sentenceAddDto){
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

    //TODO: Very risky function!
    private String createArtPartsString(List<ArtPartDto> artParts){
        StringBuilder sb = new StringBuilder();
        for(ArtPartDto part : artParts){
            sb.append(part.subtitle);
            sb.append("@");

            for(Long id : part.sentences){
                sb.append(id);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<ArtPreviewDto> getArtPreviews(ArtQueryDto textQueryDto) {
        return artsRepository.find(textQueryDto);
    }
}
