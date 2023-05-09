addedWordsPlace = null;
clickedWord = null;

wordEditor = null;
noSelectedWordEditorErrorElement = null;

wordEditorForeignKanjiInput = null;
wordEditorForeignRomajiInput = null;
wordEditorEnglishInput = null;
addedWordEditorImageDisplay = null;

function bindInit(){
    addedWordsPlace = document.querySelector("#added-wordlist-place");

    document.querySelector(".ebind-textname").onchange = function(event){
        artCreator.creation.textName = event.originalTarget.value;
    }

    document.querySelector("#metadata-originalauthor").onchange = function(event){
        artCreator.creation.originalAuthor = event.originalTarget.value;
    }

    document.querySelector("#metadata-arttype").onchange = function(event){
        artCreator.creation.artType = event.originalTarget.value;
    }

    document.querySelector("#metadata-arturl").onchange = function(event){
        artCreator.creation.artUrl = event.originalTarget.value;
    }

    wordEditor = document.querySelector("#added-word-editor-active");
    noSelectedWordEditorErrorElement = document.querySelector("#added-word-editor-nonactive");

    wordEditorForeignKanjiInput = document.querySelector("#added-word-editor-input-foreign-kanji");
    wordEditorForeignRomajiInput = document.querySelector("#added-word-editor-input-foreign-romaji");
    wordEditorEnglishInput = document.querySelector("#added-word-editor-input-english");
    wordEditorMemoImage = document.querySelector("#added-word-editor-input-memoimage");
    addedWordEditorImageDisplay = document.querySelector("#added-word-editor-image-display");

    rebindWordEditor();
    recreateWordButtons();
}

function recreateWordButtons(){
    addedWordsPlace.innerHTML = "";

    artCreator.creation.addedSentences.forEach(sentence =>{
        let text = "";
        let html = `
            <div class="added-word-button {{additional}}" onclick="setWordClicked({{id}})">
                {{text}}
                <button onclick="removeWord({{id}})"> remove </button>
            </div>
        `

        text += sentence.goodForeignAnswers[0];
        text += " -> ";
        text += sentence.goodForeignAnswers[1];
        text += " -> ";
        text += sentence.goodEnglishAnswers[0];
        
        let bakedHtml = html.replace("{{text}}", text).replaceAll("{{id}}", sentence.partTimeId);

        if(clickedWord != null && sentence.partTimeId == clickedWord.partTimeId){
            bakedHtml = bakedHtml.replace("{{additional}}", "added-word-button-clicked");
        }
        else{
            bakedHtml = bakedHtml.replace("{{additional}}", "");
        }

        addedWordsPlace.innerHTML += bakedHtml;
    });
}

function rebindWordEditor(){
    if(clickedWord == null){
        wordEditor.style.display="none";
        noSelectedWordEditorErrorElement.style.display="inline-block";
        return;
    }

    document.querySelector("#romajidesu-button").href = "https://www.romajidesu.com/dictionary/meaning-of-"+clickedWord.goodForeignAnswers[0]+".html";

    wordEditor.style.display="inline-block";
    noSelectedWordEditorErrorElement.style.display="none";
    
    wordEditorForeignKanjiInput.value = clickedWord.goodForeignAnswers[0];
    wordEditorForeignRomajiInput.value = clickedWord.goodForeignAnswers[1];
    wordEditorEnglishInput.value = clickedWord.goodEnglishAnswers[0];
    if(clickedWord.memoPicture != null)
        addedWordEditorImageDisplay.src = URL.createObjectURL(clickedWord.memoPicture);
    else 
        addedWordEditorImageDisplay.src = ""

    wordEditorForeignKanjiInput.onchange = function(event){
        clickedWord.goodForeignAnswers[0] = event.originalTarget.value;
        recreateWordButtons();
    };

    wordEditorForeignRomajiInput.onchange = function(event){
        clickedWord.goodForeignAnswers[1] = event.originalTarget.value;
        recreateWordButtons();
    };

    wordEditorEnglishInput.onchange = function(event){
        clickedWord.goodEnglishAnswers[0] = event.originalTarget.value;
        recreateWordButtons();
    };

    wordEditorMemoImage.onchange = function(event){
        clickedWord.memoPicture = event.originalTarget.files[0];
        rebindWordEditor();
    }
}

function setWordClicked(id){
    clickedWord = artCreator.creation.addedSentences.find(sentence => sentence.partTimeId == id);
    rebindWordEditor();
    recreateWordButtons();
}

function removeWord(id){
    artCreator.creation.addedSentences = artCreator.creation.addedSentences.filter(sentence => sentence.partTimeId != id);
    if(clickedWord != null && clickedWord.partTimeId == id)
        clickedWord = null;
    rebindWordEditor();
    recreateWordButtons();
}

function printCreation() {
    console.log(artCreator.creation);
}