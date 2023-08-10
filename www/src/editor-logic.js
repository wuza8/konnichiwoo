const ArtCreator = class {
    creation = this.CreateArtAddDto();
    nextId = 1;

    addNewSentence(){
        this.creation.addedSentences.push(this.SentenceAddWithArtDto(this.nextId));
        this.nextId++;
    }

    addSentence(id){
        console.log(this.creation.artParts[0]);
        this.creation.artParts[0].sentences.push(id);
    }

    removeSentence(id){
        this.creation.artParts[0].sentences = this.creation.artParts[0].sentences.filter(item => item !== id);
    }

    addNewSentence(romaji){
        let dto = this.SentenceAddWithArtDto(this.nextId);
        dto.goodForeignAnswers = [romaji];
        this.creation.addedSentences.push(dto);
        this.nextId++;
    }

    CreateArtAddDto(){
        let obj = Object();
        obj["textName"] = "untitled";
        obj["languageId"] = 1;
        obj["originalAuthor"] = "";
        obj["artType"] = "";
        obj["artUrl"] = "";
        obj["artParts"] = [this.ArtPartAddDto()];
        obj["addedSentences"] = [];
        return obj;
    }
    
    ArtPartAddDto() {
        let obj = Object();
        obj["subtitle"] = "all";
        obj["sentences"] = [];
        obj["newUsedSentences"] = [];
        return obj;
    }
    
    SentenceAddWithArtDto(id) {
        let obj = Object();
        obj["partTimeId"] = id;
        obj["memoPicture"] = null;
        obj["goodForeignAnswers"] = ["",""];
        obj["goodEnglishAnswers"] = [""];
        return obj;
    }
};

artCreator = new ArtCreator();

