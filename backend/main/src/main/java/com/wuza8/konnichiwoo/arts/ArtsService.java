package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.*;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
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
            for(ArtPartAddDto part : artAddDto.artParts){
                if(part.newUsedSentences.contains(newSentence.getPartTimeId())){
                    part.sentences.add(newId);
                }
            }
        }
        List<ArtPartDto> parts = new ArrayList<>();

        for(ArtPartAddDto part : artAddDto.artParts){
            parts.add(ArtPartDto.builder().subtitle(part.subtitle).sentences(part.sentences).build());
        }


        ArtEntity artEntity = ArtEntity.builder()
                .textName(artAddDto.textName)
                .languageId(artAddDto.languageId)
                .memoAuthorUID(artAddDto.memoAuthorUID)
                .originalAuthor(artAddDto.originalAuthor)
                .artType(artAddDto.artType)
                .artUrl(artAddDto.artUrl)
                .artParts(createArtPartsString(parts))
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

    //TODO: Very risky function!
    private List<ArtPartDto> artPartsStringToList(String artParts){
        List<ArtPartDto> parts = new ArrayList<>();
        String lines[] = artParts.split("\n");

        for(String line : lines){
            var newPart = ArtPartDto.builder();
            List<Long> sentences = new ArrayList<>();
            String nameSplit[] = line.split("@");
            newPart.subtitle(nameSplit[0]);

            String[] ids = nameSplit[1].split(" ");

            for(String id : ids){
                sentences.add(Long.parseLong(id));
            }
            newPart.sentences(sentences);
            parts.add(newPart.build());
        }

        return parts;
    }

    public List<ArtPreviewDto> getArtPreviews(ArtQueryDto textQueryDto) {
        return artsRepository.findPreviews(textQueryDto);
    }

    public ArtDto getArt(Long artId){
        ArtEntity entity = artsRepository.find(artId);
        ArtDto result = ArtDto.builder()
                .id(entity.getId())
                .textName(entity.getTextName())
                .languageId(entity.getLanguageId())
                .memoAuthorUID(entity.getMemoAuthorUID())
                .originalAuthor(entity.getOriginalAuthor())
                .artType(entity.getArtType())
                .artUrl(entity.getArtUrl())
                .artParts(artPartsStringToList(entity.getArtParts()))
                .build();

        return result;
    }

    public SentenceDto getSentence(Long id){
        SentenceEntity entity = sentencesRepository.find(id);

        return SentenceDto.builder()
                .id(entity.getId())
                .languageId(entity.getLanguageId())
                .translation(entity.getTranslation())
                .memoPictureURL(entity.getMemoPictureURL())
                .goodForeignAnswers(entity.getGoodForeignAnswers())
                .goodEnglishAnswers(entity.getGoodEnglishAnswers())
                .build();
    }
}
